package testcase;

import helper.StartWebDriver;

import java.time.Duration;
import java.util.function.Function;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class TestFluentWait extends StartWebDriver{

	@Test
	public void testWait(){
		
		/*helper.LinkHelper.clickLink("File");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Step -1
		FluentWait<WebDriver> wait = new FluentWait<WebDriver> (driver);
		//Step -2
		//wait.withTimeout(30, TimeUnit.SECONDS);
		wait.withTimeout(Duration.ofSeconds(30));
		//Step -3
		//wait.pollingEvery(5, TimeUnit.SECONDS);
		wait.pollingEvery(Duration.ofMillis(5));
		//Step -4
		wait.ignoring(org.openqa.selenium.NoSuchElementException.class);
		
		Function<WebDriver,WebElement> fun = new Function<WebDriver,WebElement> (){

			@Override
			public WebElement apply(WebDriver t) {
				System.out.println("Not Found");
				return t.findElement(By.id("log_in"));
			}
			
		};
		wait.until(fun).click();
		System.out.println("Element Found");*/
		helper.WindowHelper.navigateToPage("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_autocomplete");
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		//FluentWait<WebElement> wait = new FluentWait<WebElement> (driver.findElement(By.id("myInputautocomplete-list")));
		
	
		Function<WebElement,Boolean> fun = new Function<WebElement,Boolean> (){

			@Override
			public Boolean apply(WebElement t) {
				if(!t.getText().equalsIgnoreCase("")){
					System.out.println("Text : "+t.getText());
					return true;
				}else{
					System.err.println("Text Not Found");
					return false;
				}

			}
			
		};
		
	
		
		helper.TextBoxHelper.typeInTextBox("myInput", "j");
		FluentWait<WebElement> wait = new FluentWait<WebElement> (driver.findElement(By.id("myInputautocomplete-list")));
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofMillis(1));
		wait.until(fun);
	}

}
