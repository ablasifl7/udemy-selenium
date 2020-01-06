package testcase;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import helper.ButtonHelper;
import helper.DataProviderClass;
import helper.GenericHelper;
import helper.LinkHelper;
import helper.ReadExcelFile;
import helper.StartWebDriver;
import helper.TextBoxHelper;

public class TestClass extends StartWebDriver{
	
	
	private ArrayList<String> status = new  ArrayList<String>();
	
	
	@Test(dataProvider="testValidLogin",dataProviderClass=DataProviderClass.class)
	public void testCase(Map<String,Object> data){
		LinkHelper.clickLink("File a Bug");
		TextBoxHelper.typeInTextBox("Bugzilla_login", data.get("UserName").toString());
		TextBoxHelper.typeInTextBox("Bugzilla_password", data.get("Password").toString());
		ButtonHelper.clickButton("log_in");
		if(data.get("Valid").toString().equalsIgnoreCase("no")){
			Assert.assertTrue(GenericHelper.isElementPresent("error_msg"));
			status.add("Fail");
		}else if(data.get("Valid").toString().equalsIgnoreCase("yes")){
			status.add("Pass");
		}
		
		
		ButtonHelper.clickButtonFromXpathElement(".//div[@id='header']//a[contains(text(),'Home')]");
	    

	    
	}
	@AfterClass
	public void writeToExcel() throws IOException{
		ReadExcelFile.UpdateToExcel(3, 
				"TestLogin.xlsx",
				"TestLogin_updated.xlsx", "LoginDetails", status);
	}
}
