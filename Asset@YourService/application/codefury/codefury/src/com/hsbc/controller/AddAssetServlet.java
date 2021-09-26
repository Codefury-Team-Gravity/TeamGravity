package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.dao.AssetDao;
import com.hsbc.exceptions.AssetAlreadyPresentException;
import com.hsbc.exceptions.CategoryNotException;
import com.hsbc.pojo.Asset;

import com.hsbc.service.AssetService;
import com.hsbc.service.AssetServiceFactory;



public class AddAssetServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Asset asset = new Asset();
		//asset.setAssetId(101);///////////////////////
		asset.setName(request.getParameter("subcategory"));//change "subcategory" to "name"
		asset.setAssetType(request.getParameter("category"));//change "category" to "type"
		asset.setDateOfAdded(Date.valueOf(LocalDate.now()));
		asset.setDescription(request.getParameter("description"));
		asset.setAvailable(false);
		
		AssetService aService = AssetServiceFactory.getAssetServiceObject();		//System.out.println(asset);
		try {
			aService.addAsset(asset);
		} catch (AssetAlreadyPresentException | CategoryNotException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(count == 0)
//		{
//			response.setContentType("text/html");
//			PrintWriter out = response.getWriter();
//			out.print("<html>");
//			out.print("<body><h1>Asset add unsuccessful</h1></body>");
//			out.print("<a href = \"AddAsset.jsp\">Click to try again...</a>");
//			out.print("</html>");
//		}
		RequestDispatcher rd = request.getRequestDispatcher("AddAsset.jsp");
		rd.forward(request, response);
		
		
	}

}
