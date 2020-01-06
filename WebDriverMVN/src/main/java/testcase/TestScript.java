package testcase;

import org.testng.annotations.Test;

import helper.LinkHelper;
import helper.*;

public class TestScript extends StartWebDriver{
	
	@Test
	public void script(){
		LinkHelper.clickLink("File a Bug");
	
		GenericHelper.executeScript("document.getElementById('Bugzilla_login').value='ablasifl7@gmail.com'");
		GenericHelper.executeScript("document.getElementById('Bugzilla_password').value='Pa55w0rd'");
		GenericHelper.executeScript("document.getElementById('Bugzilla_restrictlogin').click()");
		GenericHelper.executeScript("document.getElementById('log_in').click()");
		LinkHelper.clickLink("Testng");
		GenericHelper.executeScript("window.scrollTo(100,1000)");
	}

}
