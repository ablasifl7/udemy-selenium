package cucumber.stepdefinition;

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

public class Hooks {



	@When("^I click on \"([^\"]*)\" link$")
	public void i_click_on_link(String link) throws Throwable {
		TestSettings.driver.findElement(By.linkText(link)).click();
	}

	@Then("^the title should be \"([^\"]*)\"$")
	public void the_title_should_be(String title) throws Throwable {
		Assert.assertEquals(title,TestSettings.driver.getTitle());
	}

	@And("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
		//driver.quit();
	}
	

}
