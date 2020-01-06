package com.automation.Selenium4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserReSize {

	private WebDriver driver;
	
	@Before
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	@After
	public void tearDown(){
		if(driver != null){
			driver.quit();
		}
	}
	@Test
	public void testBrowserReSize(){
		driver.get("http://localhost:5001/");
		driver.manage().window().fullscreen();
		driver.manage().window().maximize();
	}
}
