package com.hsbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.exceptions.AssetNotInStockException;
import com.hsbc.exceptions.DidNotBorrowAssetException;
import com.hsbc.exceptions.NoUserFoundException;
import com.hsbc.exceptions.TransactionNotFound;
import com.hsbc.pojo.Asset;
import com.hsbc.pojo.Borrow;
import com.hsbc.pojo.User;

public class BorrowDaoImpl implements BorrowDao {
	static Connection con;
	static PreparedStatement getUsersById, getUsersByCategory, getIsEligible, insBorrow, addMsg, getFee, getUser,
			getAsset;
	static {
		con = DBUtil.getMyConnection();
		try {
			getUsersById = con.prepareStatement("select * from borrow where userId=?");
			getUser = con.prepareStatement("select * from user where id=?");
			getAsset = con.prepareStatement("select * from asset where id=?");

			getUsersByCategory = con.prepareStatement(
					"select b.id,b.userId,b.assetId,b.remark,b.dateOfBorrow,b.isReturned,b.returnDate,c.lateFee,c.lendingPeriod,c.bannedDaysCount from borrow b,asset a,category c where b.assetId=a.id and a.assetType=c.assetType and c.assetType=?");
			getIsEligible = con.prepareStatement(
					"select b.isReturned,b.dateOfBorrow,b.returnDate,c.lendingPeriod,c.bannedDaysCount from borrow b,asset a,category c where b.assetId=a.id and a.assetType=c.assetType and b.userId=?");
			insBorrow = con.prepareStatement(
					"insert into borrow(assetId,userId,remark,dateOfBorrow,isReturned,returnDate) values(?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			addMsg = con.prepareStatement("update borrow set remark=? where id=?");
			getFee = con.prepareStatement(
					"select lendingPeriod,lateFee,bannedDaysCount from borrow b,asset a,category c where b.assetId=a.id and a.assetType=c.assetType and b.userId=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// return overdue Transaction details of given userId
	@Override
	public List<Borrow> getOverDueBorrowDetailsById(int userId)
			throws DidNotBorrowAssetException, NoUserFoundException, AssetNotFoundException {
		List<Borrow> users = new ArrayList<>();
		try {
			getFee.setInt(1, userId);
			ResultSet r = getFee.executeQuery();
			double lateFee = 0;
			if (r.next()) {
				lateFee = r.getDouble(1);
			}
			getUsersById.setInt(1, userId);
			ResultSet rs = getUsersById.executeQuery();
			while (rs.next()) {
				Date borrowDate = rs.getDate(2);
				Date returnDate = rs.getDate(7);
				int lendingPeriod = r.getInt(4);
				int bannedPeroid = r.getInt(5);
				double totalLateFee = calculateLateFee(lateFee, borrowDate, returnDate, lendingPeriod, bannedPeroid);
				if (!isEligibleToBorrow(userId)) {
					UserDao ud = UserDaoFactory.getUserDoaObject();
					User u = ud.getUserById(userId);

					AssetDao ua = AssetDaoFactory.getAssetDoaObject();
					Asset a = ua.getAssetById(rs.getInt(2));

					users.add(new Borrow(rs.getInt(1), u, a, rs.getString(4), rs.getDate(5), rs.getBoolean(6),
							rs.getDate(7), totalLateFee));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (users.size() == 0) {
			throw new DidNotBorrowAssetException("User with id= " + userId + " didn't borrow any asset");
		}
		return users;
	}

	// return overdue Transaction details of given Asset Type
	@Override
	public List<Borrow> getOverDueBorrowDetailsByCategory(String assetType)
			throws NoUserFoundException, DidNotBorrowAssetException, AssetNotFoundException {
		List<Borrow> users = null;
		try {
			getUsersByCategory.setString(1, assetType);
			ResultSet rs = getUsersByCategory.executeQuery();
			while (rs.next()) {
				
				double lateFee = rs.getDouble(8);
				Date borrowDate = rs.getDate(5);
				Date returnDate = rs.getDate(7);
				int lendingPeriod = rs.getInt(9);
				int bannedPeroid = rs.getInt(10);
				double totalLateFee = calculateLateFee(lateFee, borrowDate, returnDate, lendingPeriod, bannedPeroid);
				if (!isEligibleToBorrow(rs.getInt(2))) {
					UserDao ud = UserDaoFactory.getUserDoaObject();
					User u = ud.getUserById(rs.getInt(3));

					AssetDao ua = AssetDaoFactory.getAssetDoaObject();
					Asset a = ua.getAssetById(rs.getInt(2));

					users.add(new Borrow(rs.getInt(1), u, a, rs.getString(4), rs.getDate(5), rs.getBoolean(6),
							rs.getDate(7), totalLateFee));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (users == null) {
			throw new NoUserFoundException("No user borrowed an asset with category= " + assetType);
		}
		return users;
	}

	@Override
	//get borrow details of given userId
	public List<Borrow> getBorrowDetailsById(int userId) throws DidNotBorrowAssetException, NoUserFoundException, AssetNotFoundException {
		List<Borrow> b = new ArrayList<>();
		try {
			getFee.setInt(1, userId);
			ResultSet r = getFee.executeQuery();
			double lateFee = 0;
			if (r.next()) {
				lateFee = r.getDouble(1);
			}
			getUsersById.setInt(1, userId);
			ResultSet rs = getUsersById.executeQuery();
			while (rs.next()) {
				//calculating overdue fee
				System.out.println("In while");
				Date borrowDate = rs.getDate(2);
				Date returnDate = rs.getDate(7);
				int lendingPeriod = r.getInt(1); 
				int bannedPeroid = r.getInt(3);
				double totalLateFee = calculateLateFee(lateFee, borrowDate, returnDate, lendingPeriod, bannedPeroid);
				//fetch user details
				UserDao ud = UserDaoFactory.getUserDoaObject();
				User u = ud.getUserById(userId);

				//fetch asset details
				AssetDao ua = AssetDaoFactory.getAssetDoaObject();
				Asset a = ua.getAssetById(rs.getInt(2));
				
				//create borrow object
				b.add(new Borrow(rs.getInt(1), u, a, rs.getString(4), rs.getDate(5), rs.getBoolean(6),
						rs.getDate(7), totalLateFee));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (b.size() == 0) {
			throw new DidNotBorrowAssetException("User with id= " + userId + " didn't borrow any asset");
		}
		System.out.println("B size"+b.size());
		return b;

	}

	// check whether the user with given userId is eligible to borrow assets or not
	@Override
	public boolean isEligibleToBorrow(int userId) throws DidNotBorrowAssetException, NoUserFoundException, AssetNotFoundException {

		try {
			// check whether the user borrowed the asset
			getBorrowDetailsById(userId);
			getIsEligible.setInt(1, userId);
			ResultSet rs = getIsEligible.executeQuery();
			while (rs.next()) {
				Date borrowDate = rs.getDate(2);
				Date returnDate = rs.getDate(3);
				int lendingPeriod = rs.getInt(4);
				int bannedPeroid = rs.getInt(5);
				if (returnDate == null
						&& lendingPeriod < getDifferenceDays(borrowDate, Date.valueOf(LocalDate.now()))) {
					return false;
				}
				if (returnDate != null) {
					long days = getDifferenceDays(borrowDate, returnDate);
					if (rs.getBoolean(1) == true && days > lendingPeriod
							&& bannedPeroid < getDifferenceDays(returnDate, Date.valueOf(LocalDate.now()))) {
						return false;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}

	// add transaction details
	@Override
	public boolean addtransaction(Borrow newTransaction)
			throws AssetNotFoundException, AssetNotInStockException, DidNotBorrowAssetException, NoUserFoundException {
		AssetDao ad = AssetDaoFactory.getAssetDoaObject();
		int TransId = 0;
		try {
			boolean availableInStock = ad.isAvailable(newTransaction.getAsset().getAssetId());
			if (availableInStock && isEligibleToBorrow(newTransaction.getUser().getUserId())) {
				insBorrow.setInt(1,newTransaction.getAsset().getAssetId());
				insBorrow.setInt(2,newTransaction.getUser().getUserId());
				insBorrow.setString(3, null);
				// java.sql.Date dateOfBorrow = new
				// java.sql.Date(newTransaction.getDateOfBorrow().getTime());
				insBorrow.setDate(4, Date.valueOf(LocalDate.now()));
				insBorrow.setBoolean(5, false);
				insBorrow.setDate(6, null);
				insBorrow.executeUpdate();
				ResultSet keys = insBorrow.getGeneratedKeys();
				while (keys.next()) {
					TransId = keys.getInt(1);
				}

				// after borrowing the asset the availability of it is turned to false
				PreparedStatement assetUpdate = con.prepareStatement("update asset set isAvailable=false where id=?");
				assetUpdate.setInt(1, newTransaction.getAsset().getAssetId());
				assetUpdate.executeUpdate();
				return true;
			} else {
				throw new AssetNotInStockException("Asset is not available in stock");
			}
		} catch (AssetNotFoundException e1) {
			// TODO Auto-generated catch block
			throw e1;
		} catch (SQLException e2) {

		}
		return false;
	}

	// add remarks to transaction
	@Override
	public void addmessage(String message, int transacId) throws TransactionNotFound {
		try {
			addMsg.setString(1, message);
			addMsg.setInt(2, transacId);
			int num1 = addMsg.executeUpdate();
			if (num1 < 0) {
				throw new TransactionNotFound("transaction not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// calculate number of days between given two dates
	public static long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	// calculate lateFee
	private double calculateLateFee(double lateFee, Date borrowDate, Date returnDate, int lendingPeriod,
			int bannedPeroid) {
		if (returnDate == null && lendingPeriod < getDifferenceDays(borrowDate, Date.valueOf(LocalDate.now()))) {
			return ((getDifferenceDays(borrowDate, Date.valueOf(LocalDate.now())) - lendingPeriod) * lateFee);
		}
		if (returnDate != null) {
			long days = getDifferenceDays(borrowDate, returnDate);
			if (days > lendingPeriod) {
				return (getDifferenceDays(returnDate, Date.valueOf(LocalDate.now())) * lateFee);
			}
		}
		return 0;
	}

}
