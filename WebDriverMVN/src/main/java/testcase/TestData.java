package testcase;

import org.testng.annotations.Test;

public class TestData {

	@Test(dataProvider="data",dataProviderClass=DataProviderTest.class)
	public void testCaseThree(String a,Integer b){
		System.out.println("Argument : "+a+ "\nArgument : "+b);
	}
}
