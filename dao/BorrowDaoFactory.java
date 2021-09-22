package com.hsbc.dao;

public class BorrowDaoFactory {
	//creates and return object of BorrowDaoImpl class;
	public static BorrowDaoImpl getBorrowDaoImplObject()
	{
		return new BorrowDaoImpl();
	}
}
