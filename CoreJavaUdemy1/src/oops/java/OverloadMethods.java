package oops.java;

public class OverloadMethods {
	
	int area;
	
	
	public void getArea(int length, int width) {
		area = length * width;
		System.out.println("area of squre is: "+area);
	}
	public int getArea(int length, int width, int hieght) {
		area = length * width * hieght;
		return area;
		//System.out.println("area of rectangle is: "+area);
	}
	public void getArea(float length, float width) {
		float area;
		area = length * width;
		System.out.println("area of squre is (float): "+area);
	}
	
	public static void main(String args[]){
		OverloadMethods  overMthd = new OverloadMethods();
		overMthd.getArea(4f, 4f);
		overMthd.getArea(4, 3, 2);
	}

}
