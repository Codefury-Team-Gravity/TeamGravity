package com.hsbc.service;



public class UserServiceFactory {
	public static UserServiceImpl getUserServiceObject()
	{
		return new UserServiceImpl();
	}
}
