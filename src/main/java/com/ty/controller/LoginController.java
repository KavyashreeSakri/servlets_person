package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.PersonDao.PersonDao;
import com.ty.PersonDto.Person;

public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password= req.getParameter("pwd");
		
		PersonDao dao=new PersonDao();
		String dbperson=dao.LoginPerson(email);
		PrintWriter printWriter=resp.getWriter();
		if(password.equals(dbperson))
		{
			
//			printWriter.print("Successfully logged in");
//			RequestDispatcher dispatcher=req.getRequestDispatcher("SuccessLogin.html");
//			dispatcher.forward(req, resp);
			
			resp.sendRedirect("https://www.google.com/");
			
			
		}
		else
		{
//			printWriter.print("Invalid password");
			RequestDispatcher dispatcher=req.getRequestDispatcher("LoginPerson.html");
			dispatcher.forward(req, resp);
		}
		
		
	
	}
}
