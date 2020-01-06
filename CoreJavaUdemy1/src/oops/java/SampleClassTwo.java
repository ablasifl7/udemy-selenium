package oops.java;

public class SampleClassTwo extends SampleClassOne{
	
	public void methodOne(){
		System.out.println("Hi, I am from Class 2 and Method 1");
	}
	/*
	public void methodTwo(){
		System.out.println("Hi, I am from Class 2 and Method 2");
	}
	*/
	public static void main(String[] args){
		SampleClassTwo sc2 = new SampleClassTwo();
		
		sc2.methodOne();
		sc2.methodTwo();
	}
}
