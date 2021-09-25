package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.pojo.*;
import com.hsbc.pojo.Category;
import com.hsbc.service.CategoryService;
import com.hsbc.service.CategoryServiceFactory;


/**
 * Servlet implementation class AddCategoryServlet
 */
@SuppressWarnings("serial")

public class AddCategoryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Category category = new Category();
		System.out.println(request.getParameter("lendingperiod"));
		
		category.setAssetType(request.getParameter("categoryname"));
	
		category.setLendingPeriod(Integer.parseInt(request.getParameter("lendingperiod")));
		category.setLateFee(Integer.parseInt(request.getParameter("fine")));
		category.setbannedDaysCount(Integer.parseInt(request.getParameter("banperiod")));
		
		CategoryService cservice = CategoryServiceFactory.getCategoryServiceImplObject();
		
		cservice.addCategory(category);
		RequestDispatcher rd = request.getRequestDispatcher("AddNewCategory.jsp");
		rd.forward(request, response);
		
	}

}
