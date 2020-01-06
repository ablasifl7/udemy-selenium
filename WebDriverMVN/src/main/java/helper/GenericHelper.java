package helper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericHelper extends StartWebDriver{
	
	private static final Logger oLog = LoggerHelper.getLogger(GenericHelper.class);
	
	public static void takeScreenShot(String fileName){
		try {
			java.io.File src  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new java.io.File("ScreenShot\\"+fileName+".jpg"));
			oLog.info(" takeScreenShot");
		} catch (IOException e) {
			oLog.error(" File Not Found : "+e);
			e.printStackTrace();
		}

	}
	public static boolean isElementPresent(String locator){
		boolean flag = false;
		if(locator.contains("/"))
			flag = true;
		if(driver.findElements(By.id(locator)).size() >= 1){
			return true;	
		}else if(driver.findElements(By.name(locator)).size() >= 1){
			return true;		
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() >= 1){
			return true;		
		}else if(driver.findElements(By.xpath(locator)).size() >= 1){
			return true;	
		}else{
			return false;
		}
	}
	public static boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }finally{
	    }
	  }
	
	
	public static void executeScript(String script){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript(script);
		oLog.info(" executeScript");
	}
	
	public static void waitForElement(String locator,int...delay){
		WebDriverWait wait = null;
		
		if(delay.length >= 1){
			wait = new WebDriverWait(driver,delay[0]);	
		} else {
			wait = new WebDriverWait(driver,30);
		}
		boolean flag = false;
		if(locator.contains("/")){
			flag = true;
		}
		if(driver.findElements(By.id(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
			return;
		}else if(driver.findElements(By.name(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
			return;
		}else if(!flag && driver.findElements(By.cssSelector(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
			return;
		}else if(driver.findElements(By.xpath(locator)).size() >= 1){
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
			return;
		}else{
			oLog.error(" Element Not Found : "+locator);
			throw new NoSuchElementException(" Element Not Found : "+locator);
		}
		
	}
	
	public static void waitUsingKeyword(XSSFRow row){
		waitForElement(	row.getCell(2).getStringCellValue(),
				(int)row.getCell(3).getNumericCellValue());
	}
	public static void implicitlyWait(int seconds){
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}
