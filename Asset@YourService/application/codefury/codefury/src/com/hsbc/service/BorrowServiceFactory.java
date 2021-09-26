package com.hsbc.service;


public class BorrowServiceFactory {
	public static BorrowServiceImpl getBorrowServiceImplObject()
	{
		return new BorrowServiceImpl();
	}
}
