/**
 * @author Saugat Shah
 * @version 9/27/2025
 * 
 * The HourlyEmployee class is a subclass of the Employee.java class
 * This class is a type of Employee that get's paid on a hourly basis
 * 
 * This class emulates and calculates a specified hourly employee's paycheck based on their hoursWorked and their given wage
 * This class contains getters and setters for an Employee's hours worked (time sheet) and their wage
 * This class also gets access to methods from the superclass Employee
 * 
 */
public class HourlyEmployee extends Employee {
	
	/**hoursWorked is a private member of the Hourly Employee class that ensures that each hourly employee can input their hours into the time sheet  (private to ensure that other members cannot alter an Employees' hours)*/
	private float hoursWorked;
	/**payRate is a set Wage of an Hourly Employee it is set private to ensure that other members of the company cannot alter their wage.*/
	private float payRate;
	
	/**
	 * timeSheet records the hours Worked by a particular Hourly Employee
	 * @param hoursWorked (the employee's hours worked for that pay period)
	 */
	public void timeSheet (float hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	
	/**
	 * getTimeSheet returns the hours Worked by a particular Hourly Employee
	 * @return hoursWorked (the employee's hours worked for that pay period)
	 */
	public float getTimeSheet() {
		return hoursWorked; 
	}
	
	/**
	 * changeWage allows altering of an employee's wage
	 * @param wage (The Employee's new Wage)
	 */
	public void changeWage(float wage) {
		this.payRate = wage;
	}
	
	/**
	 * getWage returns the Wage of a specific employee
	 * @return the Employee's Wage
	 */
	public float getWage() {
		return payRate;
	}
	
	/**
	 * getPaycheck returns the paycheck of a particular employee by multiplying their hours worked by their Wage
	 * @return The Employee's Paycheck for the specified pay period
	 */
	public float getPaycheck() {
		return hoursWorked * payRate;
	}
	
	/**
	 * the Hourly Employee constructor initializes a new Hourly Employee's First name, Last name, their Wage, initializes their hours worked as 0, and assigns them a unique ID,
	 * @param First (The employee's first name)
	 * @param Last (The employee's last name)
	 * @param payRate (The employee's wage)
	 */
	public HourlyEmployee(String First, String Last, float payRate){
		super(First, Last);
		this.payRate = payRate;
	}
	
	/**
	 * toString Overrides the toString method and returns the Employee's type, their wage, their Id, and name
	 * @return returns the Employee's: wage, Id number, and their name
	 */
	@Override 
	public String toString() {
		return "Hourly: $" + String.format("%.2f", getWage()) + "; " + super.toString();
	}
	
}
