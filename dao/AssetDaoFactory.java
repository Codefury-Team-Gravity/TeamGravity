package com.hsbc.dao;

public class AssetDaoFactory {
	
	//creates and return object of AssetDaoImpl class;
	public static AssetDaoImpl getAssetDoaObject()
	{
		return new AssetDaoImpl();
	}
}
