package com.hsbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	//singleton pattern
		private static Connection conn;
		
		public static Connection getMyConnection() {
			try {
			if(conn==null) {
				String url="jdbc:mysql://localhost:3306/eAsset";
				String username="root";
				String password="rama123";
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				conn=DriverManager.getConnection(url,username,password);
				conn.setAutoCommit(true);
			}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		
		public static void closeMyConnection() {
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
