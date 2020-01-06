package testcase;

import org.testng.annotations.Test;

import pom.*;
import helper.StartWebDriver;
import helper.WindowHelper;

public class TestPageObjectModel extends StartWebDriver{
	@Test
	public void testCase(){
		WindowHelper.navigateToPage("http://localhost:5001/");
		HomePage hPage = new HomePage(driver);
		LoginPage lPage = hPage.clickFileABug();
		
		EnterBug ePage = lPage.login(file.getUsername(),file.getPassword());
		BugDetails bPage = ePage.clickTestTG();
		bPage.selectSeverity("critical");
	}
}
