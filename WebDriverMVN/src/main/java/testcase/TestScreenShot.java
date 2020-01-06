package testcase;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TestScreenShot extends helper.StartWebDriver{

	@Test
	public void screenShot(){
		String url = "https://www.udemy.com/course/test-automation-with-selenium-webdriver/?dtcode=E9Lpwll1Wth7";
		url = "https://www.udemy.com/course/test-automation-with-selenium-webdriver";
		helper.WindowHelper.navigateToPage(url);
		threadSleep(2000);
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("window.scrollTo(0,0)");
		Boolean check = (Boolean) exe.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight");
		Long scrollH = (Long)exe.executeScript("return document.documentElement.scrollHeight");
		Long clientH = (Long)exe.executeScript("return document.documentElement.clientHeight");
		int index = 1;
		if(check.booleanValue()){
			while(scrollH.intValue() > 0){
				helper.GenericHelper.takeScreenShot("Screen -" + index);
				exe.executeScript("window.scrollTo(0,"+(clientH * index)+")");
				scrollH = scrollH - clientH;
				threadSleep(2000);
				index++;
			}
			
		}else{
			helper.GenericHelper.takeScreenShot("Screen -1");
		}
	
	}
	private void threadSleep(long miliseconds){
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
