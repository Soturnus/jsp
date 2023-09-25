package com.soturno.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String user = "soturno";
	private static String password = "123456";
    private Connection conn;
    
	public void init() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Statement statement;
		try {
			
			statement = conn.createStatement();
			int result = statement.executeUpdate("update user set password='" + password + "' where email='" + email + "'");
			
			PrintWriter out = response.getWriter();
			if(result > 0) {
				out.print("<h1>Password Updated</h1>");				
			} else {
				out.print("<h1>Error updating the password.</h1>");	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void destroy() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
