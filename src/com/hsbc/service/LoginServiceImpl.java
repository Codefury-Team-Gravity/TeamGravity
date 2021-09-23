package com.hsbc.service;

import com.hsbc.dao.*;

public class LoginServiceImpl implements LoginService{
	private LoginDao loginDao;
	public LoginServiceImpl() {
		loginDao=LoginDaoFactory.getLoginDaoObject();
	}
	@Override
	public boolean credentialCheck(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.credentialCheck(username, password);
	}
	public boolean CheckWhetherUserNamePresent(String username){
		return loginDao.CheckWhetherUserNamePresent(username);
	}
	

}
