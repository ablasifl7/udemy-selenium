package com.automation.Selenium4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementScreenShot {

	private WebDriver driver;
	
	@Before
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}
	@After
	public void tearDown(){
		if(driver != null){
			driver.quit();
		}
	}
	@Test
	public void testelementScreenShot() throws IOException{
		driver.get("http://localhost:5001/");
		WebElement element = driver.findElement(By.id("enter_bug"));
//		byte[] screenShot = element.getScreenshotAs(OutputType.BYTES);
//		
//		try(FileOutputStream save = new FileOutputStream(new File("test.jpeg")) ) {
//			save.write(screenShot);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		File screenShot = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("test1.jpeg"));
	}
}
