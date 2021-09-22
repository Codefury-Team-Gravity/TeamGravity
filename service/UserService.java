package com.hsbc.service;

import java.util.List;

import com.hsbc.exceptions.NoUserFoundException;
import com.hsbc.exceptions.UserAlreadyPresentException;
import com.hsbc.pojo.Credential;
import com.hsbc.pojo.User;

public interface UserService {
	//add user to database
		public void addUser(User u,Credential c) throws UserAlreadyPresentException;
		
		//return object of User class of given userId
		public User getUserById(int userId) throws NoUserFoundException;
		
		//return object of User class of given userName
		public User getUserByUserName(String username) throws NoUserFoundException;
		
		//add a list of users to database
		public void importUsers(List<User> users,List<Credential> cred) throws UserAlreadyPresentException;
}
