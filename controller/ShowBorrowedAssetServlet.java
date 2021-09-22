package com.hsbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.dao.AssetDao;
import com.hsbc.pojo.BorrowedAssetBean;


@WebServlet("/ShowBorrowedAssetServlet")
public class ShowBorrowedAssetServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int userId = 2; //request.getParameter(...);

		AssetDao dao = new AssetDao();
		List<BorrowedAssetBean> assets = dao.showBorrowedAssets(userId);

		RequestDispatcher rd = request.getRequestDispatcher("userReturn.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	}

}
