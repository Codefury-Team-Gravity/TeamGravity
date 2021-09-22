package com.hsbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hsbc.pojo.Category;

public class CategoryDaoImpl implements CategoryDao{
	static Connection con;
	static PreparedStatement addCat,getCat;
	static {
		con = DBUtil.getMyConnection();
		try {
			addCat=con.prepareStatement("insert into category values(?,?,?,?)");
			getCat=con.prepareStatement("select * from Category where AssetType=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//add new category type to database
	@Override
	public boolean addCategory(Category c) {
		try {
			addCat.setString(1, c.getAssetType());
			addCat.setInt(2, c.getLendingPeriod());
			addCat.setFloat(3, c.getLateFee());
			addCat.setInt(4,c.getbannedDaysCount());
			addCat.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Category getCategoryByName(String assetType) {
		Category c=null;
		try {
			getCat.setString(1, assetType);
			ResultSet rs=getCat.executeQuery();
			if(rs.next())
			{
				c=new Category();
				c.setAssetType(rs.getString(1));
				c.setLendingPeriod(rs.getInt(2));
				c.setLateFee(rs.getFloat(3));
				c.setbannedDaysCount(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

}
