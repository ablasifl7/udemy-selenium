package seleniumgrid;




import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.ElementRepository;
import helper.ReadConfigProperty;

public class ChromeTest extends ElementRepository{

	private static WebDriver driver;
	private static WebDriverWait wait;
	private static DesiredCapabilities cap;
	private static ReadConfigProperty file = new ReadConfigProperty();
	
	@BeforeClass
	public static void setUp() throws MalformedURLException{
		cap = DesiredCapabilities.chrome();
		driver = new RemoteWebDriver(new URL("http://192.168.0.157:1194/wd/hub"),cap);
		PageFactory.initElements(driver, ElementRepository.class);
		wait = new WebDriverWait(driver,40);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(file.getUrl());
	}
	@Test(priority=1)
	public void testAdmin(){
		file_a_Bug.click();
		username_text_box.sendKeys(file.getUsername());
		password_text_box.sendKeys(file.getPassword());
		login_button.click();
		driver.findElement(By.xpath(".//div[@id='header']//a[contains(text(),'Administration')]")).click();
		Assert.assertTrue(driver.getTitle().contains("Administer"));
		logout_button.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//h1[@id='welcome']")));
	}
	
	@Test(priority=2)
	public void testPref(){
		file_a_Bug.click();
		username_text_box.sendKeys(file.getUsername());
		password_text_box.sendKeys(file.getPassword());
		login_button.click();
		driver.findElement(By.xpath(".//div[@id='header']//a[contains(text(),'Preferences')]")).click();
		Assert.assertTrue(driver.getTitle().contains("Preferences"));
		logout_button.click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//h1[@id='welcome']")));
	}
	
	
	
	
	
	@AfterClass(alwaysRun=true)
	public static void teadDown(){
		if(driver != null){
			driver.close();
			driver.quit();
			driver = null;
		}
		
	}
}
