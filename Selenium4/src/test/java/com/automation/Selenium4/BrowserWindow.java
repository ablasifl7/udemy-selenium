package com.automation.Selenium4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindow {

	
	private WebDriver driver;
	
	@Before
	public void setUp(){
		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	@After
	public void tearDown(){
		if(driver != null){
			driver.quit();
		}
	}
	@Test
	public void testBrowserWindows(){
		driver.get("https://www.google.com");
		driver.switchTo().newWindow(WindowType.TAB); // new tab in the same windows
		driver.get("https://www.youtube.com");
		driver.switchTo().newWindow(WindowType.WINDOW); // new browser windows
		driver.get("https://mail.google.com");
	
	}
}
