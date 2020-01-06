package oops.java;

public class Car {
	
	String name;
	int model;
	String fuelType;

	public void runningMode(){
		
	}
	
	public void speed(){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car BMW = new Car();
		Car Audi = new Car();
		Car Hyundai = new Car();
		
		BMW.name = "X5";
		BMW.model = 2017;
		BMW.fuelType = "Hybrid";
		
		Audi.name = "A6";
		Audi.model = 2018;
		Audi.fuelType = "Diesel";
		
		Hyundai.name = "i20";
		Hyundai.model = 2019;
		Hyundai.fuelType = "Petrol";
		
		System.out.println(BMW.model);
		System.out.println(Hyundai.name);
	}

}
