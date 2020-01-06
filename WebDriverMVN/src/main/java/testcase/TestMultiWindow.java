package testcase;

import helper.StartWebDriver;
import helper.ButtonHelper;
import helper.TextBoxHelper;




import org.testng.annotations.Test;
import helper.WindowHelper;

public class TestMultiWindow  extends StartWebDriver{
	@Test
	public void win() {
		
		ButtonHelper.clickButtonFromXpathElementScroll(".//div[@id='main']//div[6]//a[1]");
		WindowHelper.switchTo(1);
		driver.get("https://www.w3schools.com/js/js_popup.asp");
		ButtonHelper.clickButtonFromXpathElementScroll(".//div[@id='main']//div[6]//a[1]");
		WindowHelper.switchTo(2);
		driver.get("https://www.w3schools.com/js/js_popup.asp");
		ButtonHelper.clickButtonFromXpathElementScroll(".//div[@id='main']//div[6]//a[1]");
		WindowHelper.switchTo(3);
		/*
		Set<String> set = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(set);
		TargetLocator tar = driver.switchTo();
		tar.window(list.get(2));
		ButtonHelper.clickButton("textarea");
		TextBoxHelper.clearWithAction("textarea");
		TextBoxHelper.typeInTextBox(".//div[@id='textareawrapper']/div/div/textarea", "Webdriver");
	*/
		WindowHelper.switchToParentWithClose();

		
	}

}
