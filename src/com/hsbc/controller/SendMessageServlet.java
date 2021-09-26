package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.*;
import javax.servlet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.*;
import com.hsbc.exceptions.TransactionNotFound;

import com.hsbc.service.BorrowService;
import com.hsbc.service.BorrowServiceFactory;


public class SendMessageServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		HttpSession session = req.getSession();
		int transactionId = Integer.parseInt(req.getParameter("transactionId"));
		String message = req.getParameter("message");

		BorrowService bs = BorrowServiceFactory.getBorrowServiceImplObject();

		try {
			bs.addmessage(message,transactionId);//Check the parameters. Given in the dao are Transaction id and message
//			System.out.println("from servlet "+list);
			session.setAttribute("message",message);
			RequestDispatcher rd = req.getRequestDispatcher("Sendmessage.jsp");
			rd.forward(req, resp);
		} catch (TransactionNotFound e) {
			e.printStackTrace();
		}

	}
}