package com.hsbc.dao;

import java.util.List;

import com.hsbc.pojo.Category;

public interface CategoryDao {
	public boolean addCategory(Category c);
	public Category getCategoryByName(String assetType);
	public List<String> getAllCategory();
	
}
