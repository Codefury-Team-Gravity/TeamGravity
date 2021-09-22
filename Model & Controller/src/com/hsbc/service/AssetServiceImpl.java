package com.hsbc.service;

import java.sql.Date;

import com.hsbc.dao.*;
import com.hsbc.exceptions.AssetAlreadyPresentException;
import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.pojo.Asset;

public class AssetServiceImpl implements AssetService {
	private AssetDao assetDao;
	public AssetServiceImpl() {
		//new AssetDaoFactory();
		assetDao= AssetDaoFactory.getAssetDoaObject();
		
	}
	@Override
	public void addAsset(Asset asset) throws AssetAlreadyPresentException {
		// TODO Auto-generated method stub
		assetDao.addAsset(asset);
		
	}
	@Override
	public Asset getAssetById(int id) throws AssetNotFoundException {
		// TODO Auto-generated method stub
		return assetDao.getAssetById(id);
	}
	@Override
	public void returnAsset(int assetId, Date returnDate) throws AssetNotFoundException {
		// TODO Auto-generated method stub
		assetDao.returnAsset(assetId, returnDate);
		
	}
	

}
