package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.dao.AssetDao;
import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.exceptions.DidNotBorrowAssetException;
import com.hsbc.service.AssetService;
import com.hsbc.service.AssetServiceFactory;

@WebServlet("/ReturnAssetServlet")
public class ReturnAssetServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int assetId = Integer.parseInt(request.getParameter("assetid"));
		
		//int transactionId = Integer.parseInt(request.getParameter("transactionid"));
		//Date date= Date.valueOf(LocalDate.now());
		AssetService service = AssetServiceFactory.getAssetServiceObject();
		try {
			service.returnAsset(assetId);
		} catch (AssetNotFoundException | DidNotBorrowAssetException |NullPointerException e ) {
			// TODO Auto-generated catch block
			//!!!!!!!!!!!!!UI ppl
			PrintWriter pr= response.getWriter();
			pr.write("<html><body><h1>No Asset Borrowed</h1></body></html>");
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("UReturn.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
