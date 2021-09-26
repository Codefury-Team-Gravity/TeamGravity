package com.hsbc.service;

public interface LoginService {
	public boolean credentialCheck(String username,String password);
	public boolean CheckWhetherUserNamePresent(String username);
}
