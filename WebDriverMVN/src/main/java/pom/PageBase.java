package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import helper.ButtonHelper;

public class PageBase {
	
	@SuppressWarnings("unused")
	private WebDriver driver;

	@FindBy(how=How.XPATH,xpath=".//div[@id='header']//a[contains(text(),'Home')]")
	private WebElement home;
	
	public PageBase(WebDriver webDriver){
		PageFactory.initElements(webDriver, this);
		driver = webDriver;
	}
	
	protected void logOut(){
		ButtonHelper.clickLogout();
	}
	protected void navigationToHome(){
		home.click();
	}
}
