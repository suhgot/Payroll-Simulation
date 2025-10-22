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

import java.util.*; //Imports all classes from package java.util

public class Payroll {

    private static Scanner keyboard = new Scanner(System.in); //Scanner that reads the user's inputs.
    private static Employee[] employees = new Employee[50]; //Initializes the array of employees.
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
            System.out.print("Enter choice: ");

            String choice = keyboard.nextLine();
            
            //Switch case calls a method based on the users input.
            switch (choice) {
                case "1": createEmployee(); break;
                case "2": searchByLastName(); break;
                case "3": displayByNumber(); break;
                case "4": runPayroll(); break;
                case "5": quit = true; break;
                default: System.out.println("Invalid choice. Please enter a valid input (1-5).");
            }

        }

        System.out.println("Thank you for using the Payroll System!");
        keyboard.close();
    }
}


