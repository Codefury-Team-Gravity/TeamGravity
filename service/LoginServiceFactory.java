package com.hsbc.service;



public class LoginServiceFactory {
	public static LoginServiceImpl getLoginServiceObject()
	{
		return new LoginServiceImpl();
	}

}
