package com.db.helper;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedHashMap;


public class SqlDbHelper implements DataBaseHelper,Closeable {

	private String connString;

	private Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(connString);
	}
	
	private Statement getStatement() throws ClassNotFoundException, SQLException{
		return getConnection().createStatement();
	}
	
	
	@Override
	public DataBaseHelper setConnectionString(String connString) {
		this.connString = connString;
		return this;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int executeUpdate(String sqlQuery) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getStatement().executeUpdate(sqlQuery);

	}

	@Override
	public LinkedHashMap<Integer, LinkedHashMap<String, String>> executeQuery(String sqlQuery) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		ResultSet result = getStatement().executeQuery(sqlQuery);
	
		String[] columnName = getColumnName(result);
		
		LinkedHashMap<Integer, LinkedHashMap<String, String>> dbData = new LinkedHashMap<Integer, LinkedHashMap<String, String>> ();
		int counter = 1;// row number
		
		while(result.next()){
			dbData.put(counter++, getDbData(columnName,result));
		}
		return dbData;
		
	
		
		
		

	
	}
	
	
	
	private LinkedHashMap<String, String> getDbData(String[] columnName, ResultSet result) throws SQLException {
		LinkedHashMap<String, String> columnData = new LinkedHashMap<String, String>();
		
	
		
		for(int i=0 ;i < columnName.length ; i++){;
			columnData.put( columnName[i], getColumnData(i,result));
		}
		
		return columnData;
		
	}

	private String getColumnData(int i, ResultSet result) throws SQLException {
		int type = result.getMetaData().getColumnType(i + 1);

		switch (type) {
		case Types.NVARCHAR:
			return result.getString(i + 1);
		case Types.NCHAR:
			return result.getString(i + 1);
		case Types.INTEGER:
			return ""+result.getInt(i + 1);
		default:
			return null;
		}
	}

	private String[] getColumnName(ResultSet result) throws SQLException{
		ResultSetMetaData data = result.getMetaData();
		String[] columnName = new String[data.getColumnCount()];
		for(int i=1;i<=data.getColumnCount();i++){
			columnName[i-1] = data.getColumnName(i);
		}
		return  columnName;
	}

	@Override
	public void close(){
		
		try {
			if(getStatement() != null){
				getStatement().close();
				getConnection().close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
