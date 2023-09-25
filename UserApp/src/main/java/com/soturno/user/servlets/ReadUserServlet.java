package com.soturno.user.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/readServlet")
public class ReadUserServlet extends HttpServlet {
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user");
			PrintWriter out = response.getWriter();
			
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>");
			out.println("First Name");
			out.print("</th>");
			out.print("<th>");
			out.println("Last Name");
			out.print("</th>");
			out.print("<th>");
			out.println("Email");
			out.print("</th>");		
			out.print("</tr>");
			while(resultSet.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.print(resultSet.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.print(resultSet.getString(3));
				out.println("</td>");
				out.println("</tr>");
			}
			out.print("</table>");
			
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
