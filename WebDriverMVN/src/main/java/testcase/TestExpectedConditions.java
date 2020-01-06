package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import helper.StartWebDriver;
import helper.WindowHelper;
import helper.AlertHelper;
import helper.ButtonHelper;
import helper.LinkHelper;

public class TestExpectedConditions extends StartWebDriver{
	
	@Test
	public void testConditions() {
		/*
		WindowHelper.navigateToPage("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		
		WebDriverWait  wait = new WebDriverWait(driver,30);
		wait.pollingEvery(Duration.ofMillis(1));
		ButtonHelper.clickButton(".//button[contains(text(),'Try it')]");
		
		//Function<WebDriver,Boolean> p = new Function<WebDriver,Boolean> (){

		wait.until(ExpectedConditions.alertIsPresent());
		System.err.println("Text : "+AlertHelper.getText());
		AlertHelper.clickOK();
		*/
		LinkHelper.clickLink("File");
		WebDriverWait  wait = new WebDriverWait(driver,30);
		wait.pollingEvery(Duration.ofMillis(1));
		//wait.until(ExpectedConditions.titleContains("Log in to Bugzilla"));
		wait.until(new ExpectedCondition<WebElement>(){

			@Override
			public WebElement apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		System.out.println("Login Page Displayed");
	}

}
