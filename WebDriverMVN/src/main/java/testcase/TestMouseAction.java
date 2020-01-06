package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import helper.StartWebDriver;

public class TestMouseAction extends StartWebDriver{
	/*
	 * Step 1 : compose your action
	 * Step 2 : call the build()
	 * Step 3 : call the perform()
	 * 
	 */
	@Test
	public void action(){
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		Actions act = new Actions(driver);
		/*
		act.clickAndHold(driver.findElement(By.xpath(".//div[@id='draggable']")))
		.moveToElement(driver.findElement(By.xpath(".//div[@id='example-search-wrapper']")))
		.release()
		.build()
		.perform();
	*/
//		act.contextClick(driver.findElement(By.xpath(".//div[@id='draggable']")))		
//		.build()
//		.perform();
	
		act.dragAndDrop(driver.findElement(By.xpath(".//div[@id='draggable']"))
				,driver.findElement(By.xpath(".//div[@id='example-search-wrapper']")))
		.build()
		.perform();
		
		act.dragAndDrop(driver.findElement(By.xpath(".//div[@id='draggable']"))
				,driver.findElement(By.xpath(".//div[@id='droptarget']")))
		.build()
		.perform();
	}

}
