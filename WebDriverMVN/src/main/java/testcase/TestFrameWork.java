package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import helper.StartWebDriver;

public class TestFrameWork extends StartWebDriver{
	@Test
	public void testCase(){
		System.out.println("Title : "+driver.getTitle());
		System.out.println("Url : "+driver.getCurrentUrl());
		Assert.assertEquals(driver.getTitle(), "Google");
	}
}
