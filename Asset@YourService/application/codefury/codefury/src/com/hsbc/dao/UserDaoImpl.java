package com.hsbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			insUser = con.prepareStatement("insert into user(name,role,phone,email,userName) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			inscred = con.prepareStatement("insert into credential values(?,?)");
			getUserById = con.prepareStatement("select * from user where id=?");
			getUserByUserName = con.prepareStatement("select * from user where userName=? ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// add user to database
	@Override
	public int addUser(User u,Credential c) throws UserAlreadyPresentException {
		int UserId = 0;
		//create user id with name+phone number
		 	try {
			 		String query4 = "Select * from User where email=?";
			 		PreparedStatement stm=con.prepareStatement(query4);
		        
			 		stm.setString(1, u.getEmail());
			 		ResultSet r2=stm.executeQuery();
			 		if(r2.next()) {
			 			return 2;
			 		}
		       
				
			 		LoginDao ld=LoginDaoFactory.getLoginDaoObject();
			 		boolean l=ld.CheckWhetherUserNamePresent(u.getUserName());
			 		if(l)
			 		{
			 			return 3;
			 		}
			    	
					insUser.setString(1, u.getName());
					insUser.setString(2, u.getRole());
					insUser.setString(3, u.getPhoneNumber());
					insUser.setString(4, u.getEmail());
	                insUser.setString(5, u.getUserName());
	                ResultSet keys = insUser.getGeneratedKeys();
					while(keys.next()) {
						UserId = keys.getInt(1);
					}
					
				
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
		 	return 2;
		}

	

	// return object of User class of given userId
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

	// return object of User class of given userName
	@Override
	public User getUserByUserName(String username) throws NoUserFoundException {
		User user = null;
		try {
			getUserByUserName.setString(1, username);
			ResultSet rs = getUserByUserName.executeQuery();
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

	// add a list of users to database
	@Override
	public void importUsers(List<User> users, List<Credential> cred) throws UserAlreadyPresentException {
		int i = 0;
		for (User u : users) {
			Credential c = cred.get(i++);
			addUser(u, c);
		}
	}
	public List<String> displayMessage(int userId) throws SQLException {

		List<String> list = new ArrayList<String>();

		String sql = "select remark from Borrow where userId=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, userId);
		

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			list.add(rs.getString(1));
		}
		System.out.println("from dao " + list);
		return list;
	}
}
