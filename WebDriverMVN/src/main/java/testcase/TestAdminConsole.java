package testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import helper.*;

public class TestAdminConsole extends StartWebDriver{
	@Test
	public void testAdmin() throws IOException, InterruptedException {
//		WindowHelper.windowMaximize();
//		Process p = Runtime.getRuntime().exec("C:\\Users\\Agustí\\AutoIT Script\\Test.exe");
//		ButtonHelper.clickButtonFromXpathElement(".//span[contains(text(),'Manager App')]");
//		p.waitFor();
		LinkHelper.clickLink("File a Bug");
		TextBoxHelper.typeInTextBox("Bugzilla_login", "ablasifl7@gmail.com");
		TextBoxHelper.typeInTextBox("Bugzilla_password", "Pa55w0rd");
		ButtonHelper.clickButton("log_in");
		LinkHelper.clickLink("TestProduct");
		ButtonHelper.clickButtonFromXpathElement(".//div[@id='attachment_false']//input");
		if("firefox".equalsIgnoreCase(file.getBrowser())){
			ButtonHelper.doubleClickButtonFromIdElement("data");
		}else{
			ButtonHelper.clickButton("data");
		}
		Process p = Runtime.getRuntime().exec("C:\\Users\\Agustí\\AutoIT Script\\Upload.exe");
		p.waitFor();
		
	}
}
