package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import net.sql.BaseDades;

/**
 * Hello world!
 *
 */
public class App 
{
	final private static String DriverName = "com.mysql.jdbc.Driver";
	
    public static void main( String[] args )
    {
    	
    	testOne();
//    	String url= "jdbc:mysql://localhost:3306/mysql";
//    	String user = "root";
//    	String password = "diluvi";
//    	BaseDades bd = new BaseDades(url, user, password);
//    	bd.connexio("");

	
	
	
    }
    
    public static void testOne(){
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
