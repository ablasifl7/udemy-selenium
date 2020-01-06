package testcase.testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import helper.GenericHelper;
import helper.GridHelper;
import helper.StartWebDriver;
import helper.WindowHelper;

public class TestWebTable extends StartWebDriver{
	@Test
	public void testGrid() throws InterruptedException {
		String url = "https://wet-boew.github.io/v4.0-ci/demos/tables/tables-en.html";
		WindowHelper.navigateToPage(url);
		WebElement ele;
		String xpath;



		
		url = "https://demos.telerik.com/kendo-ui/grid/custom-command";
		WindowHelper.navigateToPage(url);
		Thread.sleep(5000);
		//tr[1]//td[4]//a[1] 
		GridHelper.clickButtonInGrid(".//div[@class='k-grid-content k-auto-scrollable']//table", 2, 3);
	}
}
