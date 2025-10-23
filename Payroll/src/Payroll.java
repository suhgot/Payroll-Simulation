/**

	This Java Program is the driver class for a Payroll application. It is a continuation of Project 2.
	
	The program options are: 
	
	1)	Create an employee
	2)	Search for an employee by last name
	3)	Display an employee, by employee number
	4)	Run payroll
	5)	Quit
	
	
	The program runs in a loop until the user chooses to quit.
	
	@author IECE 213 | Fall 2025 | Saugat Shah  
	@version Final
	@since 10/22/2025

*/

import java.util.*; //Imports all classes from package java.util.

public class Payroll {

    private static final Scanner keyboard = new Scanner(System.in); //Scanner that reads the user's inputs.
    private static final Employee[] employees = new Employee[50]; //Initializes the array of employees.
    private static int empCount = 0; //Initializes the number of employees to zero.

    public static void main(String[] args) {
        boolean quit = false; //Condition that exits the application
        
        System.out.println("Welcome to the payroll application!");
        
        //While loop makes sure the user gets a continuous selection of options until they decide to quit
        while (!quit) {
            System.out.println("=============================================================");
            System.out.println("Payroll Menu:");
            System.out.println("1) Create an Employee");
            System.out.println("2) Search for Employee by Last Name");
            System.out.println("3) Display Employee by Employee Number");
            System.out.println("4) Run Payroll");
            System.out.println("5) Quit");
            System.out.println("\nEnter your choice: ");

            String choice = keyboard.nextLine();
            
            //Switch case calls a method based on the users input.
            switch (choice) {
                case "1": {
                	System.out.println("=============================================================");
                	createEmployee(); 
                	break;
                }
             
                case "2": {
                	System.out.println("=============================================================");
                	searchByLastName(); 
                	break;
                }
                
                case "3": {
                	System.out.println("=============================================================");
                	displayByEmployeeNumber(); 
                	break;
                }
                
                case "4": {
                	System.out.println("=============================================================");
                	runPayroll(); 
                	break;
                }
                
                case "5": {
                	System.out.println("=============================================================");
                	quit = true; break;
                }
                
                default: System.out.println("Invalid choice. Please enter a valid input (1-5).");
            }

        }

        System.out.println("Thank you for using the Payroll System!");
        keyboard.close();
    }
    
    
    
    
    
    
    // -------------------------------- VALIDATOR METHODS -------------------------------
    
    /**
     * validString checks to see if the user has given a valid parameter for their string arguments.
     * @param question that is being asked
     * @return valid strings only, returns q if user inputs q
     */
    private static String validStringChecker(String question) {
    	while(true) {
    		System.out.print(question);
    		String input = keyboard.nextLine().trim();
    		if (input.equalsIgnoreCase("q")) 
    			return "q";
    		if (!input.isEmpty() && input.matches("[a-zA-Z\\-\\s]+"))
    			return input;
    			System.out.println("Please enter a valid input");
    	}
    	
    }
    
    /**
     * validInt checks to see if the user has given a valid parameter for their integer arguments.
     * @param question that is being asked
     * @return valid integers only, returns -1 if user enters q
     */
    private static int validIntChecker(String question) {
    	while(true) {
    		System.out.print(question);
    		String input = keyboard.nextLine().trim();
    		if (input.equalsIgnoreCase("q")) 
    			return -1; 
    		try {
    			int val = Integer.parseInt(input);
    			if (val >= 0) 
    				return val;
    			System.out.println("Your value must not be negative.");
    		}
    		catch (NumberFormatException e){
    			System.out.println("Please enter a valid Integer");
    		}	
    	}
    	
    }
    
    
    /**
     * validFloat checks to see if the user has given a valid parameter for their float arguments.
     * @param question that is being asked
     * @return valid floats only, returns -1.0f if user enters q
     */
    private static float validFloatChecker(String question) {
    	while(true) {
    		System.out.print(question);
    		String input = keyboard.nextLine().trim();
    		if (input.equalsIgnoreCase("q")) 
    			return -1.0f; 
    		try {
    			float val = Float.parseFloat(input);
    			if (val >= 0) 
    				return val;
    			System.out.println("Your value must not be negative.");
    		}
    		catch (NumberFormatException e){
    			System.out.println("Please enter a valid Float.");
    		}	
    	}
    	
    }
   

    // ---------------------------------- HELPER METHODS -----------------------------------
    
    /**
     * Swap is a generic method used in partition to swap elements in the wrong place
     * @param <T> type of elements in array
     * @param array with elements to be swapped
     * @param i index of first element to swap
     * @param j index of second element to swap
     */
    public static <T> void swap(T[] array, int i, int j) {
    	T temp = array[i];
    	array[i] = array[j];
    	array[j] = temp;
    }
    
    /**
     * Partition  is a generic method used in quick sort in order to split the sorting
     * Rearranges array so all elements are less than or equal to the pivot come before and
     * values that are greater than the pivot come after
     * @param <T> type of elements in array
     * @param array with elements that you need to partition
     * @param low starting index of sub array that needs to be partitioned
     * @param high ending index of sub array that needs to be partitioned
     * @param comparator the comparator to determine the order of elements
     * @return the final index position of the pivot element after partitioning
     */
    public static <T> int partition(T[]array, int low, int high, Comparator <T> comparator) {
    	T pivot = array[high];
    	int i = low -1;
    	for (int j = low; j<high; j++) {
    		if (comparator.compare((array[j]),  pivot) <=0){
    		i++;
    		swap(array, i, j);
    		}
    	}
    	swap (array, i+1, high);
    	return i+1;
    }
    
    /**
     * quickSortHelper sorts a sub array using the quick sort 
     * it partitions the sub array recursively
     * @param <T> type of elements in the array 
     * @param array the array being sorted
     * @param low the starting index of the sub array to sort
     * @param high the ending index of the sub array to sort
     * @param comparator the comparator to determine the order of elements
     */
    public static <T> void quickSortHelper (T[] array, int low, int high, Comparator<T> comparator){
    	if (low < high) {
    		int pivot = partition(array, low, high, comparator);
    			quickSortHelper(array, low, pivot - 1, comparator);
    			quickSortHelper(array, pivot + 1, high, comparator);
    		}
    	}
    
    
    // ---------------------------------- SORTING METHODS -----------------------------------
   
    /**
     * Sorts an array using the quick sort algorithm
     * it validates the input before using the recursive helper method
     * @param <T> the type of elements in the array
     * @param array the array to be sorted
     * @param count the number of elements to sort (starting from index 0)
     * @param comparator the comparator to determine the order of elements
     */
    public static <T> void quickSort(T[] array, int count, Comparator <T> comparator) {
        if (count > 0) {
            quickSortHelper(array, 0, count - 1, comparator);
        }
    }
    
    /**
     * selectionSortPaycheck Sorts an array of employees by paycheck amount in descending order using selection sort
     * Employees with the highest paychecks will be placed at the beginning of the array
     * @param array the array of employees to be sorted
     * @param count the number of employees to sort in the array
     */
    public static void selectionSortPaycheck(Employee[] array, int count) {
        for (int i = 0; i < count - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (array[j].getPaycheck() > array[maxIndex].getPaycheck()) {
                    maxIndex = j;
                }
            }
            Employee temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }
    
    // ---------------------------------- SEARCHING METHODS -----------------------------------
    
    /**
     * Performs recursive binary search to find an employee by employee number (array must be sorted first)
     * @param array the sorted array of employees to search
     * @param low the starting index of the search range
     * @param high the ending index of the search range  
     * @param num the employee number to search for
     * @return the index of the employee with the matching number, or -1 if not found
     */
    public static int binarySearch(Employee[] array, int low, int high, int num) {
    	if (high>=low) {
    		int mid = low + (high - low)/2;
    		if (array[mid].getEmployeeNumber() == num) {
    			return mid;
    		}
    		if (array[mid].getEmployeeNumber() > num) {
    			return binarySearch(array, low, mid - 1, num);
    		}
    		return binarySearch(array, mid + 1, high, num);   			
    	}
    	return -1;
    }
    
    // ---------------------------------- OPTION 1 -----------------------------------
    /**
     * createEmployee allows the user to 'create an employee' when (1) is selected.
     * it validates names, allows quitting with 'q' and asks for employee specifications.
     * it also creates a correct subclass instance and adds it to the array of employees of the company.
     */
    private static void createEmployee() {
    	
    	if (empCount >= employees.length) {
            System.out.println("You have the maximum # of employees (50), you cannot have anymore!");
            return;
        }

        String first = validStringChecker("Enter the first name of your employee (enter 'q' to quit): ");
        if (first.equalsIgnoreCase("q")) 
        	return;

        String last = validStringChecker("Enter the last name of your employee (enter 'q' to quit): ");
        if (last.equalsIgnoreCase("q")) 
        	return;

        String type = validStringChecker("Is your employee Hourly or Salaried? (enter 'q' to quit): ");
        if (type.equalsIgnoreCase("q")) 
        	return;

        if (type.equalsIgnoreCase("salaried")) {
            float salary = validFloatChecker("Enter the Employee's Salary (enter 'q' to quit): ");
            
            if (salary == -1.0f) 
            	return; 
            employees[empCount++] = new SalariedEmployee(first, last, salary);
            System.out.println("A new salaried employee has been added!");
        }
        
        else if (type.equalsIgnoreCase("hourly")) {
            float wage = validFloatChecker("Enter the Employee's Wage (enter 'q' to quit): ");
            if (wage == -1.0f) 
            	return; 
            employees[empCount++] = new HourlyEmployee(first, last, wage);
            System.out.println("A new hourly employee has been added!");
        } 
        
        else {
            System.out.println("Invalid employee type. Must be 'Hourly' or 'Salaried'. Please try again.");
        }
    }

    
    // ---------------------------------- OPTION 2 -----------------------------------

    /**
     * searchByLastName uses quick sort to sort the array of employee's
     * then it uses sequential searching to find the employee's with that last name.
     */
    private static void searchByLastName() {
        if (empCount == 0) {
            System.out.println("You have no employees, please create some employees first.");
            return;
        }
        
        String lastName = validStringChecker("Please enter the Last Name of the employee you would like to search for (enter 'q' to quit): ");
        if (lastName.equalsIgnoreCase("q"))
            return;
        
        // Sort by last name then first name using generic quick sort
        quickSort(employees, empCount, new Comparator<Employee>() {
            public int compare(Employee e1, Employee e2) {
                int lastNameCompare = e1.getEmployeeLastName().compareToIgnoreCase(e2.getEmployeeLastName());
                if (lastNameCompare != 0) 
                    return lastNameCompare;
                return e1.getEmployeeFirstName().compareToIgnoreCase(e2.getEmployeeFirstName());
            }
        });
        
        // Search using sequential search 
        boolean foundEmployee = false;
        boolean passedLastName = false;
        System.out.println("\nHere are the employees with Last Name '" + lastName + "': ");
        
        for (int i = 0; i < empCount; i++) {
            String currentLastName = employees[i].getEmployeeLastName();
            if (currentLastName.equalsIgnoreCase(lastName)) {
                System.out.println(employees[i].getEmployeeFirstName() + " " + 
                                 currentLastName + " Employee " + 
                                 employees[i].getEmployeeNumber());
                foundEmployee = true;
            } else if (foundEmployee) {
                // Only break when we've passed the last name AND we've already found matches
                passedLastName = true;
            }
            
            // Stops the search after passing that last name
            if (passedLastName && !currentLastName.equalsIgnoreCase(lastName)) {
                break;
            }
        }
            
        if (!foundEmployee) {
            System.out.println("You have no employees with that last name!");
        }
    }
    
    // ---------------------------------- OPTION 3 -----------------------------------
    
    private static void displayByEmployeeNumber() {
    	if (empCount == 0) {
    		System.out.println("You have no employees, please create some employees first.");
    		return;
    	}
    	
    	//Initializes the ID of the Employee that the user wants to find
    	int empNum;
    	
    	do{
    		empNum = validIntChecker("Enter the employee's number you would like to find: ");
    		if (empNum > empCount)
    			System.out.println("Out of Employee Range!, Please enter an employee ID that is in the range. (1 - " + empCount + "): ");
    	}
    	while (empNum > empCount);
    	
    	if (empNum == -1)
    		return;
    		
    	// Sort by employee number using generic quick sort
		quickSort(employees, empCount, new Comparator<Employee>() {
		    public int compare(Employee e1, Employee e2) {
		        return Integer.compare(e1.getEmployeeNumber(), e2.getEmployeeNumber());
		    }
		});
		
		int empIndex = binarySearch(employees, 0, empCount -1, empNum);
    	System.out.println(employees[empIndex].toString());
    }
    
    
    // ---------------------------------- OPTION 4 -----------------------------------
    
    /**
     * runPayroll is created to list the payRoll's of employee's from greatest paycheck to the least. 
     * It show's the paycheck's of all employee's on a bi-weekly timing.
     */
    private static void runPayroll() {
       
        if (empCount == 0) {
            System.out.println("You have no employees, please create some employees first.");
            return;
        }
        
        for(int i = 0; i < empCount; i++) {
            if(employees[i] instanceof HourlyEmployee) {
                float hoursWorked = validFloatChecker("How many hours did " + employees[i].getEmployeeFirstName() + " work? Enter 'q' to return to main menu: ");
                if (hoursWorked == -1.0f) {
                    float confirm = validFloatChecker("Are you sure you want to quit? You will lose any values entered so far. Enter 'q' again to confirm or enter hours to continue: ");
                    if (confirm == -1.0f) {
                        return;
                    } 
                    else {
                        hoursWorked = confirm;
                    }
                }
                ((HourlyEmployee) employees[i]).timeSheet(hoursWorked);
            }
        }

        //Selection sort implementation
        selectionSortPaycheck(employees, empCount);
        
        //Formatting for output
        for(int i = 0; i < empCount; i++) {
            String name = employees[i].getEmployeeLastName() + ", " + employees[i].getEmployeeFirstName();
            float paycheck = employees[i].getPaycheck();
            System.out.printf("%-30s $%,10.2f%n", name, paycheck);
        }
        
        System.out.println("\nEnd of Payroll");
    }


}    

