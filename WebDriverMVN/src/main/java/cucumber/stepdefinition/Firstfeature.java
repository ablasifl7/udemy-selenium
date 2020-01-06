package cucumber.stepdefinition;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Firstfeature {
	
	private WebDriver driver;
	
	@Given("^I shoud be at the login page$")
	public void i_shoud_be_at_the_login_page() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:5001/");
	}

	@And("^I provide valid userId and password$")
	public void i_provide_valid_userId_and_password() throws Throwable {
		driver.findElement(By.xpath(".//span[contains(text(),'File a Bug')]")).click();
		driver.findElement(By.id("Bugzilla_login")).sendKeys("ablasifl7@gmail.com");
		driver.findElement(By.id("Bugzilla_password")).sendKeys("Pa55w0rd");
	}

	@When("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		driver.findElement(By.id("log_in")).click();
	}

	@Then("^I should be able to login inside the bugzilla$")
	public void i_should_be_able_to_login_inside_the_bugzilla() throws Throwable {

	}

	@And("^The title of web page should be Bugzilla Main page$")
	public void the_title_of_web_page_should_be_Bugzilla_Main_page() throws Throwable {
		Assert.assertTrue(driver.getTitle().contains("Enter Bug"));
		driver.quit();
	}
	
	
}
