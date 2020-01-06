package testcase.testcase;



import org.testng.annotations.Test;

import helper.StartWebDriver;

public class TestFirefoxDriver extends StartWebDriver{

	@Test
	public void runFirefox(){
		System.out.println("Firefox Driver");
	}
}
