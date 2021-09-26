package com.hsbc.service;

import java.sql.SQLException;
import java.util.List;

import com.hsbc.dao.*;
import com.hsbc.exceptions.NoUserFoundException;
import com.hsbc.exceptions.UserAlreadyPresentException;
import com.hsbc.pojo.Credential;
import com.hsbc.pojo.User;

public class UserServiceImpl implements UserService{
	private UserDao userdao;
	@SuppressWarnings("static-access")
	public UserServiceImpl() {
		UserDaoFactory userdaof=new UserDaoFactory();
		userdao= userdaof.getUserDoaObject();
		
	}
	@Override
	public int addUser(User u, Credential c) throws UserAlreadyPresentException {
		// TODO Auto-generated method stub
		//System.out.println(c.getUserName());
		return userdao.addUser(u, c);
		
		
	}
	@Override
	public User getUserById(int userId) throws NoUserFoundException {
		// TODO Auto-generated method stub
		
		return userdao.getUserById(userId);
	}
	@Override
	public User getUserByUserName(String username) throws NoUserFoundException {
		// TODO Auto-generated method stub
		return userdao.getUserByUserName(username);
	}
	@Override
	public void importUsers(List<User> users, List<Credential> cred) throws UserAlreadyPresentException {
		// TODO Auto-generated method stub
		userdao.importUsers(users, cred);
		
	}
	public List<String> displayMessage(int userId) throws SQLException{
		return userdao.displayMessage(userId);
	}
	
}
