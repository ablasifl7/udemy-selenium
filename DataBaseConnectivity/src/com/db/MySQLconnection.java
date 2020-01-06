package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLconnection {
	
	 final private static String DriverName = "com.mysql.jdbc.Driver";


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String database = "";
		String connectionString = "jdbc:mysql://localhost:3306/mysql";
		Connection cx;
		try {
			Class.forName(DriverName);
			cx = DriverManager.getConnection(connectionString,"root","diluvi");
	        if (cx != null) {
	            if (database.equals("")) {
	                System.out.println("Estem conectats ....");
	            } else {
	                System.out.println("Estem conectats la base de dades '"+database+"'");
	            }
	        }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	
	
	System.out.println("done");

		
		
	}

}
