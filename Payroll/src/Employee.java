/**
 * @author Saugat Shah
 * @since 09/27/2025
 * 
 * This abstract class Employee is the template for every employee in a certain company's payroll simulation
 * 
 * Each employee is given a unique ID, and is assigned their first and last name with getters and accessors for those members
 * 
 * This class also makes sure that all subclasses implement a paycheck method so that all employee's can access their paycheck information and edit required information to enhance
 * workflow 
 */
public abstract class Employee {
	
	/**nextEmployeeNumber ensures next employee # is 1 at the beginning of running the program (private to ensure that it cannot be modified by others)*/
	private static int nextEmployeeNumber = 1; 
	/**employeeNumber is a set Id # that gets modified per employee (private to ensure that it cannot be modified by others)*/
	private int employeeNumber;
	
	/**employeeFirstName creates a base employee first name string (private to ensure that it cannot be modified by others)*/
	private String employeeFirstName;
	/**employeeLastName creates a base employee last name string (private to ensure that it cannot be modified by others)*/
	private String employeeLastName;
	
	
	/**
	 * getEmployeeNumber returns the unique employee number of a specified employee
	 * @return Employee's Number
	 */
	public int getEmployeeNumber(){
		return employeeNumber;
	}
	
	/**
	 * getEmployeeName returns the unique employee name of a specified employee
	 * @return Employee's full name in the format "Last, First"
	 */
	public String getEmployeeName() {
		return employeeLastName + ", " + employeeFirstName;
	}
	
	/**
	 * changeEmployeeFirstName implements a system for employee's to change their legal first name for marriage or legal purposes.
	 * @param First (their new first name)
	 */
	public void changeEmployeeFirstName(String First) {
		this.employeeFirstName = First;
	}
	
	/**
	 * changeEmployeeLastName implements a system for employee's to change their legal last name for marriage or legal purposes.
	 * @param Last (their new first name)
	 */
	public void changeEmployeeLastName(String Last) {
		this.employeeLastName = Last;
	}
	
	/**
	 * The Employee Constructor creates a new employee with a unique ID with their given first and last name
	 * @param First (their first name)
	 * @param Last (their last name)
	 */
	public Employee (String First, String Last) {
		this.employeeFirstName = First;
		this.employeeLastName = Last;
		this.employeeNumber = nextEmployeeNumber;
		nextEmployeeNumber++;
	}
	
	/**
	 * getPayCheck is an abstract method that ensures all subclasses have an implementation so that employee's can access their paychecks
	 * @return float of their paycheck amount that must be implemented by subclasses
	 */
	public abstract float getPaycheck(); 
	
	/**
	 * the ToString method is overridden so that the toString method always gives the employee's Id and their Name
	 * @return returns the Employee's Id number and their name
	 */
	@Override 
	public String toString() {
		return "Id:" + this.getEmployeeNumber() + " - " + this.getEmployeeName();
	}
}
