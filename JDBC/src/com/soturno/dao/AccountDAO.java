package com.soturno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class AccountDAO {
	
	private static String user = "soturno";
	private static String password = "123456";

	public static void main(String[] args) {
		
		try {
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", user, password);
			Statement statement = conn.createStatement();
			/** insert */
			//int result = statement.executeUpdate("insert into account values(1, 'thippireddy', 'soturno', 10000)");
			/** update */
			//int result = statement.executeUpdate("update account set bal=65466 where accno=1");
			/** update */
			int result = statement.executeUpdate("delete from account where accno=1");
			
			System.out.println(result + " linhas afetadas");
		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
