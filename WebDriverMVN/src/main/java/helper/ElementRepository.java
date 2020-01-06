package helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ElementRepository {
	/*
	@FindBy(linkText="File a Bug")
	public static WebElement file_a_Bug;
	
	@FindBy(id="Bugzilla_login")
	public static WebElement username_text_box;
	
	@FindBy(id="Bugzilla_password")
	public static WebElement password_text_box;
	
	@FindBy(id="log_in")
	public static WebElement login_button;
	
	@FindBy(xpath=".//div[@id='header']//li[11]//a[1]")
	public static WebElement logout_button;
	*/
	
	@FindBy(how=How.LINK_TEXT,using="File a Bug")
	//@CacheLookup
	public static WebElement file_a_Bug; //id or value of name attribute
	
	@FindBy(how=How.ID,using="Bugzilla_login")
	public static WebElement username_text_box;
	
	@FindBy(how=How.ID,using="Bugzilla_password")
	public static WebElement password_text_box;
	
	@FindBy(how=How.ID,using="log_in")
	//@CacheLookup
	public static WebElement login_button;
	
	@FindBy(how=How.XPATH,using=".//div[@id='header']//li[11]//a[1]")
	//@CacheLookup
	public static WebElement logout_button;
}
