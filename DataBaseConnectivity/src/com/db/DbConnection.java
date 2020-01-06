package com.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;

import com.db.helper.DataBaseHelper;
import com.db.helper.SqlDbHelper;

import java.sql.ResultSetMetaData;

public class DbConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		String connectionString = "jdbc:sqlserver://localhost;databaseName=SqlData;integratedSecurity=true;";
		Connection connection = null;
		Statement statement = null;
		ResultSet result;
		ResultSetMetaData data;
		
		String deleteQuery = "delete from Table_1 where Id = 2;";
		String updateQuery = "update Table_1 set Code = 105 where Name like 'Name%';";
		String insertQuery = "INSERT INTO Table_1  (Name, Address, Code, Id) VALUES ('Name Four', 'Address Four', '107', 1);";
		
		DataBaseHelper db = new SqlDbHelper();
		
		try {
		
			
			LinkedHashMap<Integer, LinkedHashMap<String,String>> dbData = 
					db.setConnectionString(connectionString).executeQuery("select * from Table_1;");
			System.out.println(dbData.toString());
			
			
			/*
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(connectionString);
			statement = connection.createStatement();
//			int count = statement.executeUpdate(insertQuery);
//			System.out.println("row affected : "+count);
			result = statement.executeQuery("select * from Table_1;");
			data = result.getMetaData(); //only for ''Select'
			
		
			
			String[] columnName = new String[data.getColumnCount()];
			for(int i=1;i<=data.getColumnCount();i++){
				columnName[i-1] = data.getColumnName(i);
				//System.out.println(data.getColumnName(i));
			}
			
			
			while(result.next()){
				System.out.println( String.format("%s : %s : %s : %d ",
						result.getString(1),
						result.getString(2),
						result.getString(3),
						result.getInt(4)) );
			
//				System.out.println(result.getString(1));
//				System.out.println(result.getString(2));
//				System.out.println(result.getString(3));
//				System.out.println(result.getInt(4));
			}
				*/


		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			db.close();
	

		}
//		try {
//			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		System.out.println("done");
	}

}
