package com.hsbc.service;

import java.sql.Date;

import com.hsbc.exceptions.AssetAlreadyPresentException;
import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.pojo.Asset;

public interface AssetService {
	public void addAsset(Asset asset) throws AssetAlreadyPresentException;
	public Asset getAssetById(int id) throws AssetNotFoundException;
	void returnAsset(int assetId,Date returnDate) throws AssetNotFoundException;

}
