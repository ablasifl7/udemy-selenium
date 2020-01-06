package testcase;

import org.openqa.selenium.WebDriver.Navigation;
import org.testng.annotations.Test;

import helper.*;

public class TestNavigation extends StartWebDriver{

	@Test
	public void navigator(){
		LinkHelper.clickLink("File a Bug");
		WindowHelper.windowMaximize();
		WindowHelper.back();
		WindowHelper.forward();
		WindowHelper.refresh();
		WindowHelper.navigateToPage("http://mail.google.com");
	}
}
