package com.code.java.selenium;

import org.testng.annotations.*;

public class TestNGTestMaven
{
	@DataProvider(name="data")
	public Object[][] getData(){
		Object[][] data = new Object[2][1];
		data[0][0] = "Data Provider";
		data[1][0] = "TestNG";	
		return data;
	}
	
	@Test(dataProvider="data")
	public void testCaseOne(String args){
		System.out.println("Argument : "+args+"\n");
	}		
	
}