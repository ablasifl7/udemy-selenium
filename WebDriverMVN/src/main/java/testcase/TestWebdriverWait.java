package testcase;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import helper.StartWebDriver;
import helper.WindowHelper;

public class TestWebdriverWait extends StartWebDriver{
	
	@Test
	public void testWait(){
		WindowHelper.navigateToPage("https://www.w3schools.com/js/tryit.asp?filename=tryjs_timing_clock");
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		
		WebDriverWait  wait = new WebDriverWait(driver,30);
		wait.pollingEvery(Duration.ofMillis(1));
		
		Function<WebDriver,Boolean> p = new Function<WebDriver,Boolean> (){

			@Override
			public Boolean apply(WebDriver arg0) {
				String[] t = arg0.findElement(By.id("txt")).getText().split(":");
				
				if(t[2].equalsIgnoreCase("40")){
					return true;
				}else{
					System.out.println("Number : "+t[2]);
					return false;
				}
			}
		};
		wait.until(p);
		System.out.println("40 Number found");
	}

}
