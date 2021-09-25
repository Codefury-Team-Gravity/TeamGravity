package com.hsbc.service;

import java.util.List;

import com.hsbc.dao.CategoryDao;
import com.hsbc.dao.CategoryDaoFactory;
import com.hsbc.dao.LoginDao;
import com.hsbc.pojo.Category;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao;
	public CategoryServiceImpl() {
		categoryDao=CategoryDaoFactory.getCategoryDaoImplObject();
	}
	
	@Override
	public boolean addCategory(Category c) {
		// TODO Auto-generated method stub
		return categoryDao.addCategory(c);
	}
	@Override
	public Category getCategoryByName(String assetType) {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryByName(assetType);
	}
	public List<String> getAllCategory(){
		return categoryDao.getAllCategory();
	}
	

}
