package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class EnterBug extends PageBase{
	
	private WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT,linkText="Testng")
	private WebElement testNG;
	
	@FindBy(how=How.LINK_TEXT,linkText="Reports")
	private WebElement reports;
	
//	private By testNG = By.linkText("Testng");
//	private By reports = By.linkText("Reports");
	
	public EnterBug(WebDriver webDriver){
		super(webDriver);
		driver = webDriver;
	}

	public BugDetails clickTestTG(){
		//driver.findElement(testNG).click();
		testNG.click();
		return new BugDetails(driver);
	}
	
	public void navigateToReports(){
		//driver.findElement(reports).click();
		reports.click();
	}
	public void logout(){
		logOut();
	}
}
