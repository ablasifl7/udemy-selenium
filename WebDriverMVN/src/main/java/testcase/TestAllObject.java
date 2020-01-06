package testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import helper.StartWebDriver;

public class TestAllObject extends StartWebDriver{

	@Test
	public void allTest(){
		List<WebElement> link = driver.findElements(By.tagName("a"));
		for(WebElement ele:link){
			System.out.println("Link : "+ele.getText());
			System.out.println("href : "+ele.getAttribute("href"));
						
		
		}
		
		List<WebElement> cla = driver.findElements(By.cssSelector(".txt"));
		for(WebElement ele:cla){
			System.err.println("id : "+ele.getAttribute("id"));
			System.err.println("name : "+ele.getAttribute("name"));
			System.err.println("title : "+ele.getAttribute("title"));
		}
	}
}
