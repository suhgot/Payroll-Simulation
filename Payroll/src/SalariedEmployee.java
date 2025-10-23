/**
 * @author Saugat Shah
 * @version 09/27/2025
 * 
 * The SalariedEmployee class is a subclass of the Employee.java class
 * This class is a type of Employee that get's paid on a salaried basis
 * 
 * This class emulates and calculates a specified salaried employee's paycheck based on their annual set salary on a bi-weekly basis
 * 
 * This class contains getters and accessors for a salaried employee's paycheck and salary
 * This class also gets access to methods from the superclass Employee
 * 
 */
public class SalariedEmployee extends Employee {
	
	/**yearly pay is used to store a specific employee's salary (protected to ensure it cannot be tampered)*/
	protected float yearlyPay;
	
	/**
	 * The SalariedEmployee constructor initializes a Salaried employee by their first name, last name, and their given salary, the employee is also given a unique Id.
	 * @param First (their first name)
	 * @param Last (their last name)
	 * @param salary (their given salary)
	 */
	public SalariedEmployee(String First, String Last, float salary) {
		super (First, Last);
		this.yearlyPay = salary;
	}
	
	/**
	 * getSalary returns a specified employee's Yearly Salary
	 * @return Employee's Salary for that year
	 */
	public float getSalary() {
		return yearlyPay;
	}
	
	/**
	 * changeSalary modifies an employee's salary to a given new (float) amount
	 * @param salary (Employee's new salary in a float format)
	 */
	public void changeSalary(float salary){
		this.yearlyPay = salary;
	}
	
	/**
	 * getPaycheck calculates an employee's bi-weekly paycheck amount by dividing their yearly salary by 26 (bi-weekly) weeks
	 * @return The Employee's bi-weekly paycheck
	 */
	public float getPaycheck(){
		return yearlyPay / 26.0f;
	}
	
	/**
	 * toString Overrides the toString method and returns the Employee's type, their base yearly salary, their Id, and name
	 * @return returns the Employee's: salary, Id number, and their name
	 */
	@Override 
	public String toString() {
		return "Salaried, Base : $" + String.format("%.2f", getSalary()) + "; " + super.toString(); 
	} 
}
