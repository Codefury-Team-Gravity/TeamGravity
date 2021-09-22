package com.hsbc.dao;

import java.sql.Date;

import com.hsbc.exceptions.AssetAlreadyPresentException;
import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.exceptions.*;
import com.hsbc.exceptions.DidNotBorrowAssetException;
import com.hsbc.pojo.Asset;

public interface AssetDao {
	// Add asset to database
	public void addAsset(Asset asset) throws AssetAlreadyPresentException, CategoryNotException;
	
	// return object of asset with given id, if asset with given id is not present
	// then throws AssetNotFoundException
	public Asset getAssetById(int id) throws AssetNotFoundException;
	
	// updates Asset Availability and is_return to true in asset and borrow tables
	// respectively (i.e., users returns back the asset)
	public void returnAsset(int assetId) throws AssetNotFoundException, DidNotBorrowAssetException;
	 
	//return whether the given asset is available in the storage
	public boolean isAvailable(int assetId) throws AssetNotFoundException;
}
