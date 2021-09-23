package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.UserDao;
import com.hsbc.exceptions.NoUserFoundException;
import com.hsbc.pojo.User;
import com.hsbc.service.LoginService;
import com.hsbc.service.LoginServiceFactory;
import com.hsbc.service.UserService;
import com.hsbc.service.UserServiceFactory;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// AuthenticationDao authDao = new AuthenticationDao();
		LoginService loginService = LoginServiceFactory.getLoginServiceObject();
		if(loginService.credentialCheck(username, password)) {
			//Obtaining user details using username !!doubt!!
			User currentUser=null;
			try {
				currentUser = UserServiceFactory.getUserServiceObject().getUserByUserName(username);
			} catch (NoUserFoundException e1) {
				// TODO Auto-generated catch block
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");//Login.jsp PAge or USerHomepage.jsp
			}
			
	//!!!!!	boolean lastLoginUpdated = userDao.updateLastLogin(username);!!(Should inform Dao)
			// String role = authDao.getRole(userid);
			String role = currentUser.getRole();
		    int userid=currentUser.getUserId();	
			HttpSession session = request.getSession();
			session.setAttribute("userid",userid);
		    session.setAttribute("currentUser",currentUser);
			if(role.equals("Admin")) {
				RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
				//RequestDispatcher rd=request.getRequestDispatcher("Success2.jsp");
				//response.sendRedirect("AdminHome.jsp");
				try {
					
					rd.forward(request, response);
				} catch (ServletException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			} else {
				//RequestDispatcher rd=request.getRequestDispatcher("borrowAssetServlet");  
				RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
				try {
					rd.forward(request,response);
				} catch (ServletException e) {
					e.printStackTrace();
				}		
			}
		} else {
			response.sendRedirect("index.jsp");
		}
	}
}