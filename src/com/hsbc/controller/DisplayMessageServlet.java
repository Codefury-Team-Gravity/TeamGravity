package com.hsbc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.*;
import com.hsbc.service.UserService;
import com.hsbc.service.UserServiceFactory;

public class DisplayMessageServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		HttpSession session = req.getSession();
		int uid = Integer.parseInt(req.getParameter("uid"));
		

		UserService usservice=UserServiceFactory.getUserServiceObject();

		try {
			List<String> list = usservice.displayMessage(uid);
			System.out.println("from servlet " + list);
			session.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("DisplayMessage.jsp");
			rd.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
