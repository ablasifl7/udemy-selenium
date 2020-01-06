package testcase.testOne;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void initWebDriver(){
		driver = new FirefoxDriver();
		
	}
	@AfterClass
	public static void tearDown(){
		if( driver != null){
			driver.close();
			driver.quit();
			driver = null;
		}
	}
	@Test
	public void seleniumTest(){
		driver.get("http://localhost:5001/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Title : "+driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Bugzilla"));
	}
	
}
