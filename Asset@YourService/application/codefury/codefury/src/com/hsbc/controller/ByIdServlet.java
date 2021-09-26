package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.*;
import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.exceptions.DidNotBorrowAssetException;
import com.hsbc.exceptions.NoUserFoundException;
import com.hsbc.pojo.Borrow;

import com.hsbc.service.BorrowService;
import com.hsbc.service.BorrowServiceFactory;

public class ByIdServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		HttpSession session = req.getSession();
		int UserId = Integer.parseInt(req.getParameter("userid"));

		BorrowService bs=BorrowServiceFactory.getBorrowServiceImplObject();
		

		try {
			List<Borrow> list = bs.getBorrowDetailsById(UserId);
//			System.out.println("from servlet "+list);
			session.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("searchById.jsp");//!!!!!!!!!!!!!!!
			rd.forward(req, resp);
		} catch (DidNotBorrowAssetException |NoUserFoundException | AssetNotFoundException |NullPointerException e) {
			// TODO Auto-generated catch block
			PrintWriter pr= resp.getWriter();
			pr.write("<html><body><h1> No Data Found </h1></body></html>");
			e.printStackTrace();
		} 

	}
}