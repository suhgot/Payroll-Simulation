
public class SalariedEmployee extends Employee {
	protected int yearlyPay;
	
	public SalariedEmployee(String First, String Last, int salary) {
		super (First, Last);
		this.yearlyPay = salary;
	}
	
	public int getSalary() {
		return this.yearlyPay;
	}
	
	public void changeSalary(int salary){
		this.yearlyPay = salary;
	}
	
	public float getPaycheck(){
		return this.yearlyPay / 26.0f;
	}
	
	public String toString() {
		return "Salaried, Base : " + this.getSalary() + "; " + super.toString(); 
	} 
}
