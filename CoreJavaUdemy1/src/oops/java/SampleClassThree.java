package oops.java;

public class SampleClassThree extends SampleClassTwo{
	
	public void methodThree(){
		System.out.println("Hi, I am from Class 3 and Method 1");
	}

	public static void main(String[] args){
		SampleClassThree sc3 = new SampleClassThree();
		sc3.methodOne();
		sc3.methodTwo();
	}
}
