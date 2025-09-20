
public class HourlyEmployee extends Employee {
	
	private int hoursWorked;
	private int payRate;
	
	
	public void timeSheet (int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	public int getTimeSheet() {
		return this.hoursWorked;
	}
	
	public void changeWage(int wage) {
		this.payRate = wage;
	}
	
	public int getWage() {
		return this.payRate;
	}
	
	public float getPaycheck() {
		return this.hoursWorked * this.payRate;
	}
	
	public HourlyEmployee(String First, String Last, int payRate){
		super(First, Last);
		this.payRate = payRate;
	}
	
	public String toString() {
		return "Hourly: " + this.getWage() + "; " + super.toString();
	}
	
}
