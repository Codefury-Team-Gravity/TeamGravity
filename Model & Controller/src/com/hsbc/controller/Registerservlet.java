package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.RegisterDao;
import com.hsbc.pojo.Credential;
import com.hsbc.pojo.User;
import com.hsbc.service.UserServiceFactory;

@SuppressWarnings("serial")
public class Registerservlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String role = req.getParameter("role");
		String phoneNumber = req.getParameter("phoneNumber");
		String email = req.getParameter("email");
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String confpassword = req.getParameter("conpass");
		
		//Date d1 = Date.valueOf(LocalDate.now());
		if (confpassword.equals(password)) {
			Credential credit= new Credential(userName,password);
			User bean = new User(name, role, phoneNumber, email, userName);
			int check = UserServiceFactory.getUserServiceObject().addUser(bean, credit);
			//Check if the registration is happening successfully(pending)
			if (check == 1) {
				resp.sendRedirect("UnameEmail.jsp");
			} else if (check == 2) {
				resp.sendRedirect("Username.jsp");
			} else if (check == 3) {
				resp.sendRedirect("Email.jsp");
			} else if (check == 0) {
				resp.sendRedirect("Success.jsp");
			}
		} else {
			resp.sendRedirect("Password.jsp");
		}
	}
}