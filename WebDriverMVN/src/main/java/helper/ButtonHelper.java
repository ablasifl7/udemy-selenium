package helper;


import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ButtonHelper extends StartWebDriver{
	
	private static final Logger oLog = LoggerHelper.getLogger(ButtonHelper.class);
	
	public static void clickButton(String locator){
		WebElement ele = getElement(locator);
		ele.click();
		oLog.info(" clickButton : "+locator);
	}
	public static void clickButtonFromXpathElement(String locator){
		WebElement ele = getXpathElement(locator);
		ele.click();
		oLog.info(" clickButtonFromXpathElement : "+locator);
	}
	public static void doubleClickButtonFromIdElement(String locator){
		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.id(locator));
		actions.doubleClick(elementLocator).perform();
		oLog.info(" doubleClickButtonFromIdElement : "+locator);
	}
	public static void clickButtonFromXpathElementScroll(String locator){
 		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("window.scrollTo(0,0)");
		Boolean check = (Boolean) exe.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight");
		Long scrollH = (Long)exe.executeScript("return document.documentElement.scrollHeight");
		Long clientH = (Long)exe.executeScript("return document.documentElement.clientHeight");
		int index = 1;
		WebElement ele;
		if(check.booleanValue()){
			while(scrollH.intValue() > 0){
				try {
					ele = getXpathElement(locator);
					ele.click();
					break;
				} catch (org.openqa.selenium.WebDriverException e) {
					exe.executeScript("window.scrollTo(0,"+(clientH * index)+")");
					scrollH = scrollH - clientH;
					index++;
				}
			}
		}else{
			ele = getXpathElement(locator);
			ele.click();
		} 
		oLog.info(" clickButtonFromXpathElementScroll : "+locator);
	}
	public static void clickLogout(){
		WebElement ele = getElement("login_link_top");
		ele.click();
		oLog.info(" clickLogout");
	}
	public static void clickUsingKeyword(XSSFRow row){
		clickButton(row.getCell(2).getStringCellValue());
	}
	

}
