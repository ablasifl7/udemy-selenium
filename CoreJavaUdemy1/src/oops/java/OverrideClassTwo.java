package oops.java;

public class OverrideClassTwo extends  OverrideClassOne{
	
	public void getMethod(){
		System.out.println("Hi, I am getMethod() from Child Class");
	}
	public void calculateArea(int len, int width){
		int area = len * width;
	}
	
	
	public static void main(String args[]){
		OverrideClassTwo child = new OverrideClassTwo();
		child.getMethod();
		child.calculateArea(10, 10);
		child.dispaly();
	}
}
