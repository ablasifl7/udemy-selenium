package helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

public class AlertHelper extends StartWebDriver{
	
	
	
	private static  Alert alert = null;

	
	public static String getText(){
		alert = driver.switchTo().alert();
	    return alert.getText();
	}
	
	public static void clickCancel(){
		alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public static void clickOK(){
		alert = driver.switchTo().alert();
		alert.accept();
	}
	public static void sendKeys(String value){
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	
	public static void clickButtonFromXpathElement(String locator){
		WebElement ele = getXpathElement(locator);
		do{
			ele.click();
		}while(!isAlertPresent());
		
	}
	  private static boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }
}
