package com.hsbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDaoImpl implements LoginDao {
	
	static Connection con;
	static PreparedStatement pselect,getUserName;
	static {
		con = DBUtil.getMyConnection();
		try {
			pselect = con.prepareStatement("select * from credential where userName=? and password=?");
			getUserName=con.prepareStatement("select * from credential where username=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//validate userName and password
	@Override
	public boolean credentialCheck(String username,String password){
		try {
			pselect.setString(1, username);
			pselect.setString(2, password);
			ResultSet rs = pselect.executeQuery();
			if (rs.next()) {
				if ((rs.getString(1).equals(username)) && (rs.getString(2).equals(password))) {
					return true;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	//check whether the given userName is present in the database
	@Override
	public boolean CheckWhetherUserNamePresent(String username)
	{
		try {
			getUserName.setString(1, username);
			ResultSet rs=getUserName.executeQuery();
			if(rs.next())
			{
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
