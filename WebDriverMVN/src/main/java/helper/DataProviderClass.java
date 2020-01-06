package helper;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name="getLoginData")
	public static Object[][] gerLoginData() throws IOException{
		
		return ReadExcelFile.getExcelData("Login.xlsx", "LoginDetails");
		
	}
	@DataProvider(name="testValidLogin")
	public static Object[][] testValidLogin() throws IOException{
		
		return ReadExcelFile.getExcelData("TestLogin.xlsx", "LoginDetails");
		
	}
}
