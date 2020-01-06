package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;



public class BugDetails extends PageBase{
//	private By severity = By.id("bug_severity");
//	private By showAdvancedFields = By.linkText("Show Advanced Fields");
	@SuppressWarnings("unused")
	private WebDriver driver;
	
	@FindBy(how=How.ID,id="bug_severity")
	private WebElement severity;
	
	@FindBy(how=How.LINK_TEXT,linkText="Show Advanced Fields")
	private WebElement showAdvancedFields;
	
	public BugDetails(WebDriver webDriver){
		super(webDriver);
		driver = webDriver;
	}
	
	public void selectSeverity(String value){
		//Select select = new Select(driver.findElement(severity));
		Select select = new Select(severity);
		select.selectByVisibleText(value);
	
	}
	public void navigateToShowAdvancedFields(){
		//driver.findElement(showAdvancedFields).click();
		showAdvancedFields.click();
	}
	public void logout(){
		logOut();
	}
}
