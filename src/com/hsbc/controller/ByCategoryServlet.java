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

public class ByCategoryServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		HttpSession session = req.getSession();
		String category = req.getParameter("category");

		BorrowService bs=BorrowServiceFactory.getBorrowServiceImplObject();
		

		try {
			List<Borrow> list = bs.getOverDueBorrowDetailsByCategory(category);
			System.out.println("from servlet "+list);
			session.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("searchByCategory.jsp");
			rd.forward(req, resp);
		} catch (NoUserFoundException e) {
			
			e.printStackTrace();
		} catch (DidNotBorrowAssetException e) {
			
			e.printStackTrace();
		} catch (AssetNotFoundException e) {
			
			e.printStackTrace();
		}
		  catch (NullPointerException e) {
			  PrintWriter j = resp.getWriter();
			  j.write("<html><body><h1>No Asset Found</h1></body></html>");
			  e.printStackTrace();
		  }

	}
}