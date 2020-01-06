package helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class CheckBoxHelper extends StartWebDriver{
	
	private static final Logger oLog = LoggerHelper.getLogger(CheckBoxHelper.class);
	
	public static void clickCheckBox(String locator){
		WebElement ele = getElement(locator);
		ele.click();
		oLog.info(" clickCheckBox : "+locator);
	}
	public static boolean isChecked(String locator){
		WebElement ele = getElement(locator);
		oLog.info(" isChecked : "+locator);
		return ele.isSelected();
		
	}
}
