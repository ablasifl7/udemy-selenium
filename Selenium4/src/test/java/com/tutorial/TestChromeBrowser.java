package com.tutorial;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestChromeBrowser {

	@Test
	public void testChromeBrowser() {
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		if(driver != null){
			driver.quit();
		}
	}
	@Test
	public void testFirefoxDriver(){
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		
		if(driver != null){
			driver.quit();
		}
	}
}
