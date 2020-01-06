package cucumber.stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

class dataTableClass {
	public String getLinkName() {
		return linkName;
	}
	public String getTitle() {
		return title;
	}

	String linkName;
	String title;
}

public class NavigationUrlStpDef {

	private WebDriver driver;
		
	@Given("^User should be at home page \"([^\"]*)\"$")
	public void user_should_be_at_home_page(String url) throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("--------- Background Step ---------");
	}
//
//	@When("^I click on \"([^\"]*)\" link$")
//	public void i_click_on_link(String link) throws Throwable {
//		driver.findElement(By.linkText(link)).click();
//	}
//
//	@Then("^I check for the title as \"([^\"]*)\"$")
//	public void i_check_for_the_title_as(String title) throws Throwable {
//		driver.quit();
//		/*
//		try {
//			Assert.assertEquals(driver.getTitle(), title);
//		} catch (AssertionError e) {
//			String tit = driver.getTitle();
//			driver.quit();
//			Assert.assertEquals(tit, title);
//		}
//		*/
//	}
//	}
	


	//@When("^I click on the link I assert for the title$")
	public void i_click_on_the_link_I_assert_for_the_title(DataTable data) throws Throwable {
//		List<DataTableRow> dataRow = data.getGherkinRows();
//		for(int i=1;i<dataRow.size();i++){
//			String link = dataRow.get(i).getCells().get(0);
//			driver.findElement(By.linkText(link)).click();
//			String title = dataRow.get(i).getCells().get(1);
//			Assert.assertEquals(driver.getTitle(), title);
//		}
		List<dataTableClass> list = data.asList(dataTableClass.class);
		for(dataTableClass dataTableClass : list){
			System.out.println("link name : "+dataTableClass.getLinkName()+", Title : "+dataTableClass.getTitle());
			driver.findElement(By.linkText(dataTableClass.getLinkName())).click();
			Assert.assertEquals(driver.getTitle(), dataTableClass.getTitle());
		}
	}

	//@And("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
		driver.quit();
	}
	
	@When("^I click on the link \"([^\"]*)\"$")
	public void i_click_on_the_link(String linkName) throws Throwable {
		driver.findElement(By.linkText(linkName)).click();
	}

	@Then("^I assert for the \"([^\"]*)\"$")
	public void i_assert_for_the(String title) throws Throwable {
		Assert.assertEquals(driver.getTitle(), title);

	}

	@And("^I close the \"([^\"]*)\"$")
	public void i_close_the(String browser) throws Throwable {
		System.out.println("Browser name : "+browser);
		driver.quit();
	}

}
