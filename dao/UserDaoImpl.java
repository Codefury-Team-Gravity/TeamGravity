package com.hsbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hsbc.exceptions.NoUserFoundException;
import com.hsbc.exceptions.UserAlreadyPresentException;
import com.hsbc.pojo.Credential;
import com.hsbc.pojo.User;

public class UserDaoImpl implements UserDao {
	static Connection con;
	static PreparedStatement insUser, getUserById, getUserByUserName, inscred;
	static {
		con = DBUtil.getMyConnection();
		try {
			insUser = con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			inscred = con.prepareStatement("insert into credential values(?,?)");
			getUserById = con.prepareStatement("select * from user where id=?");
			getUserByUserName = con.prepareStatement("select * from user where userName=? ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//add user to database
	@Override
	public int addUser(User u,Credential c) throws UserAlreadyPresentException {
		int generatedId = 0;
		//create user id with name+phone number
		 try {
				getUserById(u.getUserId());
				//return 2
			    throw new UserAlreadyPresentException("user with id= "+u.getUserId()+" is already present");
				 
		 }catch(NoUserFoundException e)	{
			    try {
			    	LoginDao ld=LoginDaoFactory.getLoginDaoObject();
			    	boolean l=ld.CheckWhetherUserNamePresent(u.getUserName());
			    	if(l)
			    	{
			    		return 3;
			    	}
			    	insUser.setInt(1,u.getUserId());
					insUser.setString(2, u.getName());
					insUser.setString(3, u.getRole());
					insUser.setString(4, u.getPhoneNumber());
					insUser.setString(5, u.getEmail());
	                insUser.setString(6, u.getUserName());
	                
	                inscred.setString(1,c.getUserName());
	                inscred.setString(2, c.getPassword());
	                
	                int num1=inscred.executeUpdate();
	                int num2=insUser.executeUpdate();
	                System.out.println(num1+" "+num2);
	                return 1;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		 return 2;
	}

	//return object of User class of given userId
	@Override
	public User getUserById(int userId) throws NoUserFoundException {
		User user = null;
	try {
			getUserById.setInt(1, userId);
			ResultSet rs = getUserById.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user == null) {
			throw new NoUserFoundException("User not found with id= " + userId);
		}
		return user;
		
	}

	//return object of User class of given userName
	@Override
	public User getUserByUserName(String username) throws NoUserFoundException {
		User user = null;
		try {
			getUserByUserName.setString(1, username);
			ResultSet rs = getUserById.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (user == null) {
			throw new NoUserFoundException("User not found with name= " + username);
		}
		return user;

	}

	//add a list of users to database
	@Override
	public void importUsers(List<User> users, List<Credential> cred) throws UserAlreadyPresentException {
		int i = 0;
		for (User u : users) {
			Credential c = cred.get(i++);
			addUser(u, c);
		}
	}
}
