package com.hsbc.service;

public class CategoryServiceFactory {
	public static CategoryServiceImpl getCategoryServiceImplObject()
	{
		return new CategoryServiceImpl();
	}
}
