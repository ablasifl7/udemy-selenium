package testcase;

import org.openqa.selenium.WebDriver;

interface interfaceOne{// By default public abstract
	//int i = 0;// == public static final i = 0;
	//void displayed();//y default it will be public abstract
	//public abstract void getMsg();
	public abstract void display();
	String getMsg(String str);
	
}

interface interfaceTwo{
	void showInt();
}

class baseClass implements interfaceOne,interfaceTwo {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.err.println("Interface One Method");
	}

	@Override
	public String getMsg(String str) {
		// TODO Auto-generated method stub
		return str;
	}

	@Override
	public void showInt() {
		// TODO Auto-generated method stub
		System.err.println("Inter Face two : 100");
	}

}

public class TestInterface {

	public static WebDriver driver = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*baseClass obj = new baseClass();
		obj.display();
		System.err.println("Value : "+obj.getMsg("Method""));
		obj.showInt();*/
		/*
		interfaceOne obj1 = new baseClass();
		obj1.display();
		System.err.println("Value : "+obj1.getMsg("Method"));
		
		interfaceTwo obj2 = new baseClass();
		obj2.showInt();*/
		
		
	
	}

}
