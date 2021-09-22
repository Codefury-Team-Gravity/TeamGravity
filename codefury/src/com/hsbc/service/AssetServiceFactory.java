package com.hsbc.service;



public class AssetServiceFactory {
	public static AssetServiceImpl getAssetServiceObject()
	{
		return new AssetServiceImpl();
	}
}
