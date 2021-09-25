package com.hsbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.pojo.Category;

public class CategoryDaoImpl implements CategoryDao{
	static Connection con;
	static PreparedStatement addCat,getCat,getAllAssetTypes;
	static {
		con = DBUtil.getMyConnection();
		try {
			addCat=con.prepareStatement("insert into category values(?,?,?,?)");
			getCat=con.prepareStatement("select * from Category where AssetType=?");
			getAllAssetTypes=con.prepareStatement("select AssetType from category");
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
	
	//return all category names
		@Override
		public List<String> getAllCategory()
		{
			List<String> categories=new ArrayList<>();
			try {
				ResultSet rs=getAllAssetTypes.executeQuery();
				while(rs.next())
				{
					categories.add(rs.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return categories;
		}

}
