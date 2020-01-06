package helper;


import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class StartWebDriver extends ElementRepository{
	public static WebDriver driver = null;
	
	public ReadConfigProperty file;
	@BeforeSuite
	public void setUp(){
		
		try {
			file = new ReadConfigProperty();
			if("firefox".equalsIgnoreCase(file.getBrowser())){
				driver = new FirefoxDriver();
			}else if("chrome".equalsIgnoreCase(file.getBrowser())){
				driver = new ChromeDriver();
			}else if("explorer".equalsIgnoreCase(file.getBrowser())){
				driver = new InternetExplorerDriver();
			}else{
				driver = new HtmlUnitDriver();
			}
			driver.manage().timeouts().implicitlyWait(file.getElementWait(),
					TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(file.getPageLoadWait(),
					TimeUnit.SECONDS);
			driver.get(file.getUrl());
			PageFactory.initElements(driver, ElementRepository.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static WebElement getElement(String locator){
		boolean flag = false;
		if(locator.contains("/"))
			flag = true;
		if(driver.findElements(By.id(locator)).size() == 1){
			return driver.findElement(By.id(locator));	
		}else if(driver.findElements(By.name(locator)).size() == 1){
			return driver.findElement(By.name(locator));	
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() == 1){
			return driver.findElement(By.cssSelector(locator));	
		}else if(driver.findElements(By.xpath(locator)).size() == 1){
			return driver.findElement(By.xpath(locator));
		}else{
			throw new NoSuchElementException("No Such Element : "+locator);
		}
	}
	public static WebElement getXpathElement(String locator){
		try {
			return driver.findElement(By.xpath(locator));
		} catch (Exception e) {
			throw new NoSuchElementException("No Such Xpath Element : "+locator);
		}
	}
	
	public static WebElement getIdElement(String locator){
		try {
			return driver.findElement(By.id(locator));
		} catch (Exception e) {
			throw new NoSuchElementException("No Such Id Element : "+locator);
		}
	}
	
	@BeforeClass
	public void afterTest(){
		
	}
	
	@AfterClass
	public void afterClass(){

	}
	
	@AfterSuite(alwaysRun=true)
	public void tearDown(){
	
		try {
			driver.close();
			if(!"firefox".equalsIgnoreCase(file.getBrowser())){
				driver.quit();
			}
			if( driver != null){
				driver = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
