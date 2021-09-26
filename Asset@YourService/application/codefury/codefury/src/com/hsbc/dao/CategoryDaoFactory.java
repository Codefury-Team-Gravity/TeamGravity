package com.hsbc.dao;

public class CategoryDaoFactory {
	public static CategoryDaoImpl getCategoryDaoImplObject()
	{
		return new CategoryDaoImpl();
	}
}
