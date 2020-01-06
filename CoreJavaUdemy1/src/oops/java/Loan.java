package oops.java;

public class Loan {
	
	private int interestrate;
	private int browerAge;
	private String loanTenure;
	
	
	
	protected void setInterestRate(int interestRate) {
		if(interestRate >= 2 && interestRate <= 8){
			interestrate = interestRate;
		}else{
			System.out.println("Please enter valid Interes rate, value between 2-8");
		}
		
		interestrate = interestRate;
	}

	protected void setAge(int age) {
		browerAge = age;
	}
	protected int getInterestrate() {
		return interestrate;
	}


	protected int getBrowerAge() {
		return browerAge;
	}

	public void printIntrestRate(){
		System.out.println("HomeLond Tnterest rate is : " +interestrate);
	}
	
	public void printLoanTenure(){
		System.out.println("HomeLond Tenure is : " +loanTenure);
	}


}
