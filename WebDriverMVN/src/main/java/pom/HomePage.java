package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;




public class HomePage extends PageBase{

	/* Region - All the Web Element */
	private WebDriver driver;

	@FindBy(how=How.LINK_TEXT,linkText="File a Bug")
	private WebElement fileBug;
	
	@FindBy(how=How.ID,id="quicksearch_main")
	private WebElement quickSearchTxtBox;
	
	@FindBy(how=How.ID,id="find")
	private WebElement quickSearchButton;
	
	@FindBy(how=How.LINK_TEXT,linkText="New")
	private WebElement New;
//	private By fileBug = By.linkText("File a Bug");
//	private By quickSearchTxtBox = By.id("quicksearch_main");
//	private By quickSearchButton = By.id("find");
//	private By New = By.linkText("New");
	
	/* Region - All the actions */
	public HomePage(WebDriver webDriver){
		super(webDriver);
		driver = webDriver;
	}
	
	
	public LoginPage clickFileABug(){
		//driver.findElement(fileBug).click();
		fileBug.click();
		return new LoginPage(driver);
	}
	public void quickSearch(String searchText){
		//driver.findElement(quickSearchTxtBox).sendKeys(searchText);
		//driver.findElement(quickSearchButton).click();
		quickSearchTxtBox.sendKeys(searchText);
		quickSearchButton.click();
	}
	
	/* Region - Navigation */
	public void navigateToNewPage(){
		//driver.findElement(New).click();
		New.click();
	}

public void logout(){
	logOut();
}
}
