package cucumber.generchooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.settings.TestSettings;

public class GenericHooks {


	
	@Before(value="@firefox")
	public  void setUpFirefox(){
		TestSettings.driver = new FirefoxDriver();
		TestSettings.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TestSettings.driver.manage().window().maximize();
	}
	
	@Before(value="@chrome")
	public  void setUpChrome(){
		TestSettings.driver = new ChromeDriver();
		TestSettings.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TestSettings.driver.manage().window().maximize();
	}
	

	
	@After(value={"@firefox,@chrome"})
	public void tearDown(){
		TestSettings.driver.quit();
	}
}
