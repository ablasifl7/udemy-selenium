package oops.java;

public class AbsClassTwo extends  AbsClassOne{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbsClassTwo abs = new AbsClassTwo();
		abs.displayMethods();
		abs.spinMethods();
	}
	
	public void displayMethods(){
		System.out.println("hi, I am from concrete Class Method 1");
	}
	
	public void spinMethods(){
		System.out.println("hi, I am from concrete Class Method 2");
	}
	public void fromMethodThree(){
		
	}

}
