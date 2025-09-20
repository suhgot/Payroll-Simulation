
public class SalariedEmployee extends Employee {
	protected int yearlyPay;
	
	public SalariedEmployee(String First, String Last, int salary) {
		super (First, Last);
		this.yearlyPay = salary;
	}
	
	public int getSalary() {
		return this.yearlyPay;
	}
	
	private void changeSalary(int salary){
		this.yearlyPay = salary;
	}
	
	public int getPaycheck(){
		return this.yearlyPay * (1/26);
	}
	
	public String toString() {
		return "Salaried, Base : " + this.getSalary() + "; " + super.toString(); 
	}
}
