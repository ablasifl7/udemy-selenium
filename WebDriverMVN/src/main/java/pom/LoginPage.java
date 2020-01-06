package pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class LoginPage extends PageBase{
	
	private WebDriver driver;

	@FindBy(how=How.ID,id="Bugzilla_login")
	private WebElement bugzilla_login;
	
	@FindBy(how=How.ID,id="Bugzilla_password")
	private WebElement bugzilla_password;
	
	@FindBy(how=How.ID,id="log_in")
	private WebElement loginBtn;
	
	@FindBy(how=How.LINK_TEXT,linkText="Home")
	private WebElement home;
	
	
//	private By bugzilla_login = By.id("Bugzilla_login");
//	private By bugzilla_password = By.id("Bugzilla_password");
//	private By loginBtn = By.id("log_in");
//	private By home = By.linkText("Home");
	
	
	public LoginPage(WebDriver webDriver){
		super(webDriver);
		driver = webDriver;
	}
	
	public EnterBug login(String user,String pass){
//		driver.findElement(bugzilla_login).sendKeys(user);
//		driver.findElement(bugzilla_password).sendKeys(pass);
//		driver.findElement(loginBtn).click();
		bugzilla_login.sendKeys(user);
		bugzilla_password.sendKeys(pass);
		loginBtn.click();
		
		return new EnterBug(driver);
	}
	
	public void navigationToHome(){
		home.click();
	}
}
