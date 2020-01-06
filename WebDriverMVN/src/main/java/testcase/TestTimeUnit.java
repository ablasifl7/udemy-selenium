package testcase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import helper.StartWebDriver;

public class TestTimeUnit extends StartWebDriver{
	@Test
	public void testTime(){
		//helper.LinkHelper.clickLink("File a Bug");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MICROSECONDS);
		driver.get("http://www.seventhsonmovie.com/mobile/");
		//helper.ButtonHelper.clickButton("log_in");
	}

}
