package com.hsbc.service;

import java.sql.Date;
import java.util.List;

import com.hsbc.dao.*;
import com.hsbc.exceptions.AssetAlreadyPresentException;
import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.exceptions.CategoryNotException;
import com.hsbc.exceptions.DidNotBorrowAssetException;
import com.hsbc.pojo.Asset;

public class AssetServiceImpl implements AssetService {
	private AssetDao assetDao;
	public AssetServiceImpl() {
		//new AssetDaoFactory();
		assetDao= AssetDaoFactory.getAssetDoaObject();
		
	}
	@Override
	public void addAsset(Asset asset) throws AssetAlreadyPresentException, CategoryNotException {
		// TODO Auto-generated method stub
		assetDao.addAsset(asset);
		
	}
	@Override
	public Asset getAssetById(int id) throws AssetNotFoundException {
		// TODO Auto-generated method stub
		return assetDao.getAssetById(id);
	}
	@Override
	public void returnAsset(int assetId) throws AssetNotFoundException, DidNotBorrowAssetException {
		// TODO Auto-generated method stub
		assetDao.returnAsset(assetId);
		
	}
	public boolean isAvailable(int assetId) throws AssetNotFoundException{
		return assetDao.isAvailable(assetId);
	}
	public List<Asset> getAllAvailableAsset(){
		return assetDao.getAllAvailableAsset();
	}
	

}
