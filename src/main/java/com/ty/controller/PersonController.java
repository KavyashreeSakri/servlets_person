package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.ty.PersonDao.PersonDao;
import com.ty.PersonDto.Person;

public class PersonController extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String email=req.getParameter("email");
		String Password=req.getParameter("pwd");
		Long phone=Long.parseLong(req.getParameter("phone"));
		
		Person person=new Person();
		person.setFirstName(firstname);
		person.setLastName(lastname);
		person.setEmail(email);
		person.setPassword(Password);
		person.setPhone(phone);
		
		PersonDao dao=new PersonDao();
//		dao.savePerson(person);
		
		dao.updatePerson(email, person);
		
		PrintWriter printWriter=res.getWriter();
//		printWriter.print("Person saved successfully");
		printWriter.print("Person updated successfully");
		
	}

}
