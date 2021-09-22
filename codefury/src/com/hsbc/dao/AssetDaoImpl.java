package com.hsbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.hsbc.pojo.Category;

import com.hsbc.exceptions.AssetAlreadyPresentException;
import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.exceptions.CategoryNotException;
//import com.hsbc.exceptions.CategoryNotFoundException;
import com.hsbc.exceptions.DidNotBorrowAssetException;
import com.hsbc.pojo.Asset;

public class AssetDaoImpl implements AssetDao {
	static Connection con;
	static PreparedStatement insAsset, assetgetById, assetReturnInAsset, assetReturnInBorrow,getIdFromBorrow;
	static {
		con = DBUtil.getMyConnection();
		try {
			insAsset = con.prepareStatement("insert into asset values(?,?,?,?,?,?)");
			assetgetById = con.prepareStatement("select * from asset where id=?");
			assetReturnInAsset = con.prepareStatement("update asset set isAvailable='true' where id=?");
			assetReturnInBorrow = con.prepareStatement("update borrow set isReturned='true',returnDate=? where id=?");
			getIdFromBorrow=con.prepareCall("select id from borrow where assetId=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Add asset to database
	@Override
	public void addAsset(Asset asset) throws AssetAlreadyPresentException, CategoryNotException {
		try {
			getAssetById(asset.getAssetId());//unique assetId Assetname+"1"
			throw new AssetAlreadyPresentException("Asset with id= " + asset.getAssetId() + " is alredy present");
		} catch (AssetNotFoundException e1) {
			try {
				CategoryDao cd=CategoryDaoFactory.getCategoryDaoImplObject();
				Category c=cd.getCategoryByName(asset.getAssetType());
				if(c==null)
				{
					throw new CategoryNotException("Category with AssetType= \""+asset.getAssetType()+"\" ,is not available");
				}
				insAsset.setInt(1, asset.getAssetId());
				insAsset.setString(2, asset.getName());
				insAsset.setString(3, asset.getAssetType());
				insAsset.setString(4, asset.getDescription());
				insAsset.setDate(5,Date.valueOf(LocalDate.now()));
				insAsset.setBoolean(6,true);
				insAsset.executeUpdate();
			} catch (SQLException e) {
			}
		}
		 
	}

	// return object of asset with given id, if asset with given id is not present
	// then throws AssetNotFoundException
	@Override
	public Asset getAssetById(int id) throws AssetNotFoundException {

		Asset asset = null;
		try {
			assetgetById.setInt(1, id);
			ResultSet rs = assetgetById.executeQuery();
			while (rs.next()) {
				asset = new Asset(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5),
						rs.getBoolean(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (asset == null) {
			throw new AssetNotFoundException("Asset not found with id= " + id);
		}
		return asset;
	}

	// updates Asset Availability and is_return to true in asset and borrow tables
	// respectively (i.e., users returns back the asset)
	@Override
	public void returnAsset(int assetId) throws AssetNotFoundException, DidNotBorrowAssetException{
		Asset asset;
		try {
			asset = getAssetById(assetId);
			//check whether the user have borrowed the asset with the given assetId
			PreparedStatement checkInBorrow=con.prepareStatement("select assetId from borrow where assetId=?");
			checkInBorrow.setInt(1, assetId);
			ResultSet r=checkInBorrow.executeQuery();
			if(r.next())
			{
			if (asset != null) {

				assetReturnInAsset.setInt(1, assetId);
				int num1 = assetReturnInAsset.executeUpdate();
				
				//fetching transaction id from borrow table to update is_retured=true;
				String transactionId = null;
				getIdFromBorrow.setInt(1,assetId);
				ResultSet rs = getIdFromBorrow.executeQuery();
				while (rs.next()) {
					transactionId = rs.getString(1);
				}
				assetReturnInBorrow.setDate(1,Date.valueOf(LocalDate.now()));
				assetReturnInBorrow.setString(2, transactionId);
				int num2 = assetReturnInBorrow.executeUpdate();
			}
			}
			else
			{
				throw new DidNotBorrowAssetException("did not borrow asset with id= "+assetId);
			}
		} catch (AssetNotFoundException e1) {
			throw e1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//return whether the given asset is available in the storage
	//return true---asset inserted in asset table and is available
	//return false---asset inserted in asset table and is not available
	//return exception if asset is not inserted in the asset table
	@Override
	public boolean isAvailable(int assetId) throws AssetNotFoundException
	{
		//throw exception if given assetId not found 
		try {
			getAssetById(assetId);
			
			//if assetId is present in the database then retrieve the availability of that asset
			boolean available=false;
			try {
				PreparedStatement isa=con.prepareStatement("select isAvailable from asset where id=?");
				isa.setInt(1, assetId);
				ResultSet rs=isa.executeQuery();
				if(rs.next())
				{
					available=rs.getBoolean(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return available;
		} catch (AssetNotFoundException e1) {
			 throw e1;
		}
	}
}
