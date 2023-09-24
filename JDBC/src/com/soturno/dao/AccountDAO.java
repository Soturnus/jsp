package com.soturno.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
			/** delete */
			//int result = statement.executeUpdate("delete from account where accno=1");
					
			//System.out.println(result + " linhas afetadas");
			
			/** ler dados do banco */
			ResultSet rs = statement.executeQuery("select * from account;");
					
			while(rs.next()) {
				System.out.println("Last Name: " + rs.getString(2));
				System.out.println("First Name: " + rs.getString(3));
				System.out.println("Balance: " + rs.getInt(4));	
			}
			/** fim da leitura */
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
