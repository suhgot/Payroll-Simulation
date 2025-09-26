/**
 * @author Saugat Shah
 * @version 9/26/2025
 */

public class HourlyEmployee extends Employee {
	
	private float hoursWorked;
	private float payRate;
	
	public void timeSheet (float hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	public float getTimeSheet() {
		return hoursWorked;
	}
	
	public void changeWage(float wage) {
		this.payRate = wage;
	}
	
	public float getWage() {
		return payRate;
	}
	
	public float getPaycheck() {
		return hoursWorked * payRate;
	}
	
	public HourlyEmployee(String First, String Last, float payRate){
		super(First, Last);
		this.payRate = payRate;
		hoursWorked = 0;
	}
	
	public String toString() {
		return "Hourly: $" + String.format("%.2f", getWage()) + "; " + super.toString();
	}
	
}
