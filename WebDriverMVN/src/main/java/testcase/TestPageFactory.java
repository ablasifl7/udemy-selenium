package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import helper.ButtonHelper;
import helper.StartWebDriver;


public class TestPageFactory extends StartWebDriver{

	@Test(priority=1)
	public void testLogin(){
		file_a_Bug.click();
		username_text_box.sendKeys("ablasifl7@gmail.com");
		password_text_box.sendKeys("Pa55w0rd");
		login_button.click();
//		LinkHelper.clickLink("File a Bug");
//		TextBoxHelper.typeInTextBox("Bugzilla_login", "ablasifl7@gmail.com");
//		TextBoxHelper.typeInTextBox("Bugzilla_password", "Pa55w0rd");
//		ButtonHelper.clickButton("log_in");
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		//ButtonHelper.clickButton(".//div[@id='header']//li[11]//a[1]");
		logout_button.click();
	}
	
	@Test(priority=2)
	public void testPreferences(){
		file_a_Bug.click();
		username_text_box.sendKeys("ablasifl7@gmail.com");
		password_text_box.sendKeys("Pa55w0rd");
		login_button.click();	
//		LinkHelper.clickLink("File a Bug");
//		TextBoxHelper.typeInTextBox("Bugzilla_login", "ablasifl7@gmail.com");
//		TextBoxHelper.typeInTextBox("Bugzilla_password", "Pa55w0rd");
//		ButtonHelper.clickButton("log_in");
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		ButtonHelper.clickButton(".//div[@id='header']//a[contains(text(),'Preferences')]");
		Assert.assertTrue(driver.getTitle().contains("User Preferences"));
		//ButtonHelper.clickButton(".//div[@id='header']//li[11]//a[1]");
		logout_button.click();
	}
	
	@Test(priority=3)
	public void testAdministration(){
		file_a_Bug.click();
		username_text_box.sendKeys("ablasifl7@gmail.com");
		password_text_box.sendKeys("Pa55w0rd");
		login_button.click();
//		LinkHelper.clickLink("File a Bug");
//		TextBoxHelper.typeInTextBox("Bugzilla_login", "ablasifl7@gmail.com");
//		TextBoxHelper.typeInTextBox("Bugzilla_password", "Pa55w0rd");
//		ButtonHelper.clickButton("log_in");
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		ButtonHelper.clickButton(".//div[@id='header']//a[contains(text(),'Administration')]");
		Assert.assertTrue(driver.getTitle().contains("Administer your installation"));
		//ButtonHelper.clickButton(".//div[@id='header']//li[11]//a[1]");
		logout_button.click();
	}
}
