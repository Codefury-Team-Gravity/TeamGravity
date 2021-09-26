package com.hsbc.service;

import java.util.List;

import com.hsbc.pojo.Category;
public interface CategoryService{
		public boolean addCategory(Category c);
		public Category getCategoryByName(String assetType);
		public List<String> getAllCategory();
		
		
	}

