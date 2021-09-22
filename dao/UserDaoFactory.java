package com.hsbc.dao;

public class UserDaoFactory {
	
	//creates and return object of AssetDaoImpl class;
	public static UserDaoImpl getUserDoaObject()
	{
		return new UserDaoImpl();
	}
}
