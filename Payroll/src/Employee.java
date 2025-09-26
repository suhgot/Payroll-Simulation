public abstract class Employee {
	private static int nextEmployeeNumber = 1;
	private int employeeNumber;
	
	private String employeeFirstName;
	private String employeeLastName;
	
	public int getEmployeeNumber(){
		return employeeNumber;
	}
	
	public String getEmployeeName() {
		return employeeLastName + ", " + employeeFirstName;
	}
	
	public void changeEmployeeName(String First, String Last) {
		this.employeeFirstName = First;
		this.employeeLastName = Last;
	}
	
	public Employee (String First, String Last) {
		this.employeeFirstName = First;
		this.employeeLastName = Last;
		this.employeeNumber = nextEmployeeNumber;
		nextEmployeeNumber++;
		
	}
	public abstract float getPaycheck(); 
	
	public String toString() {
		return "Id:" + this.getEmployeeNumber() + " - " + this.getEmployeeName();
	}
}
