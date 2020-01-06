package testcase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import helper.StartWebDriver;

public class TestSelect extends StartWebDriver{
	@Test
	public void testDropDown(){
		helper.LinkHelper.clickLink("File a Bug");
		helper.TextBoxHelper.typeInTextBox("Bugzilla_login", "ablasifl7@gmail.com");
		helper.TextBoxHelper.typeInTextBox("Bugzilla_password","Pa55w0rd");
		helper.CheckBoxHelper.clickCheckBox("Bugzilla_restrictlogin");
		helper.ButtonHelper.clickButton("log_in");
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		helper.LinkHelper.clickLink("Testng");
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
//		Select sel = new Select(driver.findElement(By.id("bug_severity")));
//		sel.selectByIndex(1);
//		sel.selectByValue("trivial");
//		sel.selectByVisibleText("normal");
		helper.ComboBoxHelper.select("bug_severity", 1);
		helper.ComboBoxHelper.select("bug_severity", "trivial");
		helper.ComboBoxHelper.select("rep_platform", "Macintosh");
		

		try {
			throw new FileNotFoundException();
		} catch (Exception e) {
			helper.GenericHelper.takeScreenShot(this.getClass().toString());
			Assert.fail(e.toString());
		}
	}
}
