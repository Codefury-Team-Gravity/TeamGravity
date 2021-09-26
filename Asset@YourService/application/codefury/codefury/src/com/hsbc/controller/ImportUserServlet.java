package com.hsbc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.hsbc.exceptions.UserAlreadyPresentException;
import com.hsbc.pojo.*;
import com.hsbc.service.UserService;
import com.hsbc.service.UserServiceFactory;

@WebServlet("/getDataFromfile/*")
public class ImportUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String fname = request.getPathInfo();
		//System.out.println(fname);
		String path = this.getServletContext().getRealPath(fname);
		// System.out.println("converting to obj");
		FileReader fr = new FileReader(path);
		JSONParser jsonParser = new JSONParser();
		Object obj = null;
		try {
			obj = jsonParser.parse(fr);
			System.out.println("json obj" + obj);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject jobj = (JSONObject) obj;
		 //System.out.println("json obj : "+jobj);
		JSONArray jsonArray = (JSONArray) jobj.get("user");
		 //System.out.println("json Array : "+jsonArray);
		ArrayList<Object> listdata = new ArrayList<Object>();
		ArrayList<Object> objlist = new ArrayList<Object>();

		// Checking whether the JSON array has some value or not
		if (jsonArray != null) {

			// Iterating JSON array
			for (int i = 0; i < jsonArray.size(); i++) {

				// Adding each element of JSON array into ArrayList
				listdata.add(jsonArray.get(i));
			}
		}

		//System.out.println("Array list" + listdata.get(0));
		ArrayList<String> slist1 = new ArrayList<String>();
		
		
		for(int i=0;i<listdata.size(); i++)
			{
			slist1.add(listdata.get(i).toString());
			System.out.println(listdata.get(i));
			}
		List<User> ulist=new ArrayList<User>();
		List<Credential> clist=new ArrayList<Credential>();
		for(int i=0;i<slist1.size();i++) {
			//String arr[]=slist1.replaceAll(":",",");
			//System.out.println(slist1.get(i).replaceAll(":",","));
			String str=slist1.get(i).replaceAll(":",",");
			String arr[] = str.split(",");
			System.out.println(arr[i]);
			ulist.add(new User(arr[7],arr[3],arr[5],arr[9],arr[11]));
			clist.add(new Credential(arr[11],arr[1]));
		}
		UserService us=UserServiceFactory.getUserServiceObject();
		try {
			us.importUsers(ulist, clist);
		} catch (UserAlreadyPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
