package com.hsbc.dao;

public interface LoginDao {
	//validate userName and password
	public boolean credentialCheck(String username,String password);
	
	//check whether the given userName is present in the database
	public boolean CheckWhetherUserNamePresent(String username);
}
