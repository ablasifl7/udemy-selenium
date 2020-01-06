package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import helper.*;


public class TestAlert extends StartWebDriver{
	@Test
	public void alert(){
		driver.get("https://www.w3schools.com/jsref/met_win_confirm.asp");
		ButtonHelper.clickButtonFromXpathElementScroll(".//div[@id='main']//div[5]//a[1]");
		WindowHelper.switchTo(2);
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		//ButtonHelper.clickButtonFromXpathElement(".//button[contains(text(),'Try it')]");
		AlertHelper.clickButtonFromXpathElement(".//button[contains(text(),'Try it')]");
		System.err.println("String : "+AlertHelper.getText());
		AlertHelper.clickCancel();
		//ButtonHelper.clickButtonFromXpathElement(".//button[contains(text(),'Try it')]");
		AlertHelper.clickButtonFromXpathElement(".//button[contains(text(),'Try it')]");
		AlertHelper.clickOK();
		WindowHelper.switchToParentWithClose();
		driver.get("https://www.w3schools.com/jsref/met_win_alert.asp");
		ButtonHelper.clickButtonFromXpathElementScroll(".//div[@id='main']//div[2]//a[1]");
		WindowHelper.switchTo(1);
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		//ButtonHelper.clickButtonFromXpathElement(".//button[contains(text(),'Try it')]");
		AlertHelper.clickButtonFromXpathElement(".//button[contains(text(),'Try it')]");
		System.err.println("String : "+AlertHelper.getText());
		AlertHelper.clickOK();
	}
}
