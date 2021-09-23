package com.hsbc.dao;

public class LoginDaoFactory {
	//creates and return object of LoginDaoImpl class;
	public static LoginDaoImpl getLoginDaoObject()
	{
		return new LoginDaoImpl();
	}
}
