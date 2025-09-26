public class SalariedEmployee extends Employee {
	protected float yearlyPay;
	
	public SalariedEmployee(String First, String Last, float salary) {
		super (First, Last);
		this.yearlyPay = salary;
	}
	
	public float getSalary() {
		return yearlyPay;
	}
	
	public void changeSalary(float salary){
		this.yearlyPay = salary;
	}
	
	public float getPaycheck(){
		return yearlyPay / 26.0f;
	}
	
	public String toString() {
		return "Salaried, Base : $" + String.format("%.2f", getSalary()) + "; " + super.toString(); 
	} 
}
