package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface WebDriverEventListener {
	
	public void afterChangeValueOf(WebElement arg0,WebDriver arg1);
	public void afterClickOn(WebElement arg0,WebDriver arg1);
	public void afterFindBy(WebElement arg0,WebDriver arg1);
	public void afterNavigateBack(WebElement arg0,WebDriver arg1);
	public void afterNavigateForward(WebElement arg0,WebDriver arg1);
	public void afterNavigateTo(WebElement arg0,WebDriver arg1);
	public void afterScript(WebElement arg0,WebDriver arg1);
	public void beforeChangeValueOf(WebElement arg0,WebDriver arg1);
	public void beforeClickOn(WebElement arg0,WebDriver arg1);
	public void beforeFindBy(WebElement arg0,WebDriver arg1);
	public void beforeNavigateBack(WebElement arg0,WebDriver arg1);
	public void beforeNavigateForward(WebElement arg0,WebDriver arg1);
	public void beforeNavigateTo(WebElement arg0,WebDriver arg1);
	public void beforeScript(WebElement arg0,WebDriver arg1);
}
