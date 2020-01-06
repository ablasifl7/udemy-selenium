package cucumber.genericstepdfn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.settings.TestSettings;

public class GenericStepDfn {
	

	
	@Given("^User is at Bugzilla login page with \"([^\"]*)\"$")
	public void user_is_at_Bugzilla_login_page_with(String url) throws Throwable {

		TestSettings.driver.get(url);
	}
}
