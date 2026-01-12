package com.example;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeService;

import java.util.Scanner;

// This is the main class that runs the console application.
public class App {
    public static void main(String[] args) {
        // Create an instance of our employee service to manage data.
        EmployeeService service = new EmployeeService();
        // Create a scanner to read input from the user.
        Scanner scanner = new Scanner(System.in);

        // The main loop keeps the application running until the user decides to exit.
        while (true) {
            // Display the menu of options to the user.
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Find Employee by ID");
            System.out.println("4. Update Salary");
            System.out.println("5. Remove Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Read the user's choice.
            int choice = scanner.nextInt();
            // Consume the rest of the line to prevent input issues.
            scanner.nextLine(); 

            try {
                // Use a switch statement to perform an action based on the user's choice.
                switch (choice) {
                    case 1:
                        // Get employee details from the user.
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Department: ");
                        String department = scanner.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        // Create a new employee and add it to the service.
                        service.addEmployee(new Employee(id, name, department, salary));
                        System.out.println("Employee added successfully.");
                        break;
                    case 2:
                        // Display all employees.
                        System.out.println("All Employees:");
                        service.viewAllEmployees().forEach(System.out::println);
                        break;
                    case 3:
                        // Find and display a specific employee by their ID.
                        System.out.print("Enter ID: ");
                        int findId = scanner.nextInt();
                        System.out.println(service.findEmployeeById(findId));
                        break;
                    case 4:
                        // Update an employee's salary.
                        System.out.print("Enter ID: ");
                        int updateId = scanner.nextInt();
                        System.out.print("Enter New Salary: ");
                        double newSalary = scanner.nextDouble();
                        service.updateSalary(updateId, newSalary);
                        System.out.println("Salary updated successfully.");
                        break;
                    case 5:
                        // Remove an employee from the system.
                        System.out.print("Enter ID: ");
                        int removeId = scanner.nextInt();
                        service.removeEmployee(removeId);
                        System.out.println("Employee removed successfully.");
                        break;
                    case 6:

                        System.out.println("Exiting...");
                        return;
                    default:
                        // Handle the cases of an invalid option.
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (EmployeeNotFoundException e) {
                // Catch and display a specific error if an employee isn't found.
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                // Catch any other unexpected errors to prevent the app from crashing.
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
