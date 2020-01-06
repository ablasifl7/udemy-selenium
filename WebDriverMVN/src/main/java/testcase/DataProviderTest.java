package testcase;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@DataProvider (name="data")
	public static Object[][] getData(Method name){
		Object[][] obj = null;
		
		if(name.getName().equalsIgnoreCase("testCaseOne")){
			obj = new Object[2][2];
			obj[0][0] = "String 1";
			obj[0][1] = 123;
			
			obj[1][0] = "String 2";
			obj[1][1] = 321;
		}
		if(name.getName().equalsIgnoreCase("testCaseTwo")){
			obj = new Object[3][2];
			obj[0][0] = "Abc";
			obj[0][1] = 1;
			
			obj[1][0] = "Cde";
			obj[1][1] = 2;
			
			obj[2][0] = "Fgh";
			obj[2][1] = 3;
		}
		
		if(name.getName().equalsIgnoreCase("testCaseThree")){
			obj = new Object[3][2];
			obj[0][0] = "Test Case 3";
			obj[0][1] = 1;
			
			obj[1][0] = "Test Case 4";
			obj[1][1] = 2;
			
			obj[2][0] = "Test Case 5";
			obj[2][1] = 3;
		}
		
		return obj;
	}
	
	
	@Test(dataProvider="data")
	public void testCaseOne(String a,Integer b){
		System.out.println("Argument : "+a+ "\nArgument : "+b);
	}
	
	@Test(dataProvider="data")
	public void testCaseTwo(String a,Integer b){
		System.out.println("Argument : "+a+ "\nArgument : "+b);
	}
	
	@Test(dataProvider="data")
	public void testCaseThree(String a,Integer b){
		System.out.println("Argument : "+a+ "\nArgument : "+b);
	}
}
