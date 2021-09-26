package com.hsbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.AssetDao;
import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.exceptions.DidNotBorrowAssetException;
import com.hsbc.exceptions.NoUserFoundException;
import com.hsbc.pojo.Borrow;

import com.hsbc.service.AssetService;
import com.hsbc.service.AssetServiceFactory;
import com.hsbc.service.BorrowService;
import com.hsbc.service.BorrowServiceFactory;


@WebServlet("/ShowBorrowedAssetServlet")
public class ShowBorrowedAssetServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		HttpSession session = req.getSession();
		int UserId = Integer.parseInt(req.getParameter("userId"));

		BorrowService bs=BorrowServiceFactory.getBorrowServiceImplObject();
		

		try {
			List<Borrow> list = bs.getBorrowDetailsById(UserId);
//			System.out.println("from servlet "+list);
			session.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("userReturn.jsp");//!!!!!!!!!!!!!!!
			rd.forward(req, resp);
		} catch (DidNotBorrowAssetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoUserFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AssetNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
