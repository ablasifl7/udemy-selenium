package testcase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import helper.*;

public class TestPrompt extends StartWebDriver {
	
	@Test
	public void prompt(){
		ButtonHelper.clickButtonFromXpathElementScroll(".//div[9]//a[1]");
		WindowHelper.switchTo(2);
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		ButtonHelper.clickButtonFromXpathElement(".//button[contains(text(),'Try it')]");
		AlertHelper.clickCancel();
		ButtonHelper.clickButtonFromXpathElement(".//button[contains(text(),'Try it')]");
		AlertHelper.sendKeys("Webdriver");
		System.err.println("String : "+AlertHelper.getText());
		AlertHelper.clickOK();
	}

}
