package com.hsbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.exceptions.AssetNotInStockException;
import com.hsbc.exceptions.DidNotBorrowAssetException;
import com.hsbc.exceptions.NoUserFoundException;
import com.hsbc.exceptions.TransactionNotFound;
import com.hsbc.pojo.Borrow;

public class BorrowDaoImpl implements BorrowDao {
	static Connection con;
	static PreparedStatement getUsersById, getUsersByCategory, getIsEligible, insBorrow, addMsg;
	static {
		con = DBUtil.getMyConnection();
		try {
			getUsersById = con.prepareStatement("select * from borrow where userId=?");
			getUsersByCategory = con.prepareStatement(
					"select b.id,b.userId,b.assetId,b.remark,b.dateOfBorrow,b.isReturned,b.returnDate from borrow b,asset a,category c where b.assetId=a.id and a.assetType=c.assetType and c.assetType=?");
			getIsEligible = con.prepareStatement(
					"select b.isReturned,b.dateOfBorrow,b.returnDate,c.lendingPeriod,c.bannedDaysCount from borrow b,asset a,category c where b.assetId=a.id and a.assetType=c.assetType and b.userId=?");
			insBorrow = con.prepareStatement("insert into borrow values(?,?,?,?,?,?,?)");
			addMsg = con.prepareStatement("update borrow set remark=? where id=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// return Transaction details of given userId
	@Override
	public List<Borrow> getBorrowDetailsById(int userId) throws DidNotBorrowAssetException {
		List<Borrow> users = new ArrayList<>();
		try {
			getUsersById.setInt(1, userId);
			ResultSet rs = getUsersById.executeQuery();
			while (rs.next()) {
				users.add(new Borrow(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5),
						rs.getBoolean(6), rs.getDate(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (users.size() == 0) {
			throw new DidNotBorrowAssetException("User with id= " + userId + " didn't borrow any asset");
		}
		return users;
	}

	// return Transaction details of given Asset Type
	@Override
	public List<Borrow> getBorrowDetailsByCategory(String assetType) throws NoUserFoundException {
		List<Borrow> users = null;
		try {
			getUsersByCategory.setString(1, assetType);
			ResultSet rs = getUsersByCategory.executeQuery();
			while (rs.next()) {
				users.add(new Borrow(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDate(5),
						rs.getBoolean(6), rs.getDate(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (users == null) {
			throw new NoUserFoundException("No user borrowed an asset with category= " + assetType);
		}
		return users;
	}

	// check whether the user with given userId is eligible to borrow assets or not
	@Override
	public boolean isEligibleToBorrow(int userId) throws DidNotBorrowAssetException {

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
	public void addtransaction(Borrow newTransaction)
			throws AssetNotFoundException, AssetNotInStockException, DidNotBorrowAssetException {
		AssetDao ad = AssetDaoFactory.getAssetDoaObject();
		try {
			boolean availableInStock = ad.isAvailable(newTransaction.getAssetId());
			//check overdue's status
			if (availableInStock && isEligibleToBorrow(newTransaction.getUserId())) {
				insBorrow.setString(1, newTransaction.getTransactionId());
				insBorrow.setInt(2, newTransaction.getUserId());
				insBorrow.setInt(3, newTransaction.getAssetId());
				insBorrow.setString(4, null);
				// java.sql.Date dateOfBorrow = new
				// java.sql.Date(newTransaction.getDateOfBorrow().getTime());
				insBorrow.setDate(5, Date.valueOf(LocalDate.now()));
				insBorrow.setBoolean(6, false);
				insBorrow.setDate(7, null);
				insBorrow.executeUpdate();

				// after borrowing the asset the availability of it is turned to false
				PreparedStatement assetUpdate = con.prepareStatement("update asset set isAvailable=false where id=?");
				assetUpdate.setInt(1, newTransaction.getAssetId());
				assetUpdate.executeUpdate();
			} else {
				throw new AssetNotInStockException("Asset is not available in stock");
			}
		} catch (AssetNotFoundException e1) {
			// TODO Auto-generated catch block
			throw e1;
		} catch (SQLException e2) {

		}
	}

	// add remarks to transaction
	@Override
	public void addmessage(String message, int transacId) throws TransactionNotFound {
		try {
			addMsg.setString(1, message);//username
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

}
