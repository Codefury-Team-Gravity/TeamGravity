package com.hsbc.service;

import java.sql.Date;
import java.util.List;

import com.hsbc.exceptions.AssetAlreadyPresentException;
import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.exceptions.CategoryNotException;
import com.hsbc.exceptions.DidNotBorrowAssetException;
import com.hsbc.pojo.Asset;

public interface AssetService {
	public void addAsset(Asset asset) throws AssetAlreadyPresentException, CategoryNotException;
	public Asset getAssetById(int id) throws AssetNotFoundException;
	void returnAsset(int assetId) throws AssetNotFoundException, DidNotBorrowAssetException;
	public boolean isAvailable(int assetId) throws AssetNotFoundException;
	public List<Asset> getAllAvailableAsset();

}
