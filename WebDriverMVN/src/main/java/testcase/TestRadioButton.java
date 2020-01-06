package testcase;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRadioButton extends helper.StartWebDriver {
	@Test
	public void testRadioButon(){
		try {
			helper.LinkHelper.clickLink("File a Bug");
			helper.TextBoxHelper.typeInTextBox("Bugzilla_login", "ablasifl7@gmail.com");
			helper.TextBoxHelper.typeInTextBox("Bugzilla_password","Pa55w0rd");
			helper.CheckBoxHelper.clickCheckBox("Bugzilla_restrictlogin");
			helper.ButtonHelper.clickButton("log_in");
			Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
			//helper.LinkHelper.clickLink("Administration");
			//helper.StartWebDriver.getXpathElement(".//html/body/div/ul/li[9]/a").click();
			helper.ButtonHelper.clickButtonFromXpathElement(".//div[@id='header']//a[contains(text(),'Administration')]");
			helper.LinkHelper.clickLink("Parameters");
			Assert.assertTrue(driver.getTitle().contains("Configuration: Required Settings"));
			helper.CheckBoxHelper.clickCheckBox("ssl_redirect-on");
			System.out.println("Selected : "+helper.CheckBoxHelper.isChecked("ssl_redirect-off"));
			
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
}
