
public class HourlyEmployee extends Employee {
	
	private float hoursWorked;
	private float payRate;
	
	
	public void timeSheet (float hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	public float getTimeSheet() {
		return this.hoursWorked;
	}
	
	public void changeWage(float wage) {
		this.payRate = wage;
	}
	
	public float getWage() {
		return this.payRate;
	}
	
	public float getPaycheck() {
		return this.hoursWorked * this.payRate;
	}
	
	public HourlyEmployee(String First, String Last, float payRate){
		super(First, Last);
		this.payRate = payRate;
	}
	
	public String toString() {
		return "Hourly: $" + this.getWage() + "; " + super.toString();
	}
	
}
