package testcase;


import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import helper.*;

public class TestKeyBoard extends StartWebDriver{
	@Test
	public void testKey(){
		Actions act = new Actions(driver);
		act.keyDown(driver.findElement(By.id("quicksearch_top")) ,Keys.SHIFT)
		.sendKeys(driver.findElement(By.id("quicksearch_top")) ,"f")
		.sendKeys(driver.findElement(By.id("quicksearch_top")) ,"x")
		.keyUp(driver.findElement(By.id("quicksearch_top")) ,Keys.SHIFT)
		.build()
		.perform();
		
		//quicksearch_top

		/**
		 * my own code
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("http://google.com");
				 */
		// about:addons
		((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if("firefox".equalsIgnoreCase(file.getBrowser())){
			driver.get("about:addons");
		}else if("chrome".equalsIgnoreCase(file.getBrowser())){
			driver.get("chrome://settings/");
		}
		

		
	}

}
