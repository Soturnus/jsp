package com.soturno.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AdditionServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("number1") != null && request.getParameter("number2") != null) {
			Long num1 = Long.parseLong(request.getParameter("number1"));
			Long num2 = Long.parseLong(request.getParameter("number2"));
			
			PrintWriter out = response.getWriter();
			out.println("The result is :" + (num1 + num2));
		}
		

	}

}
