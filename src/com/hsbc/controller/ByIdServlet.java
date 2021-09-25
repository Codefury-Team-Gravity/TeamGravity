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
		System.out.println(UserId);
		BorrowService bs=BorrowServiceFactory.getBorrowServiceImplObject();
		

		try {
			List<Borrow> list = bs.getBorrowDetailsById(UserId);
//			System.out.println("from servlet "+list);
			session.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("searchById.jsp");//!!!!!!!!!!!!!!!
			rd.forward(req, resp);
		} catch (DidNotBorrowAssetException e) {
			PrintWriter j = resp.getWriter();
			j.write("<html><body><h1>Did not borrow asset</h1></body></html>");
			e.printStackTrace();
		} catch (NoUserFoundException e) {
			PrintWriter j = resp.getWriter();
			j.write("<html><body><h1>No user found with ID ="+UserId+"</h1></body></html>");
			e.printStackTrace();
		} catch (AssetNotFoundException e) {
			PrintWriter j = resp.getWriter();
			j.write("<html><body><h1>Asset not found</h1></body></html>");
			e.printStackTrace();
		}

	}
}