package day4.practical;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// This class provides a console interface to manage and search for employees.
class MainsGetter {

    // Searches for an employee by ID in the given map.
    static Employees details(int id, Map<Integer, Employees> map) {
        return map.getOrDefault(id, null);
    }

    public static void main(String[] args) {
        Map<Integer, Employees> employees = new HashMap<>();
        Scanner input = new Scanner(System.in);

        // Loop to input details for 5 employees.
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Employee " + (i + 1));
            System.out.print("Department: ");
            String deptname = input.next();
            System.out.print("Name: ");
            String name = input.next();
            System.out.print("Salary: ");
            double salary = input.nextDouble();

            // Basic validation for salary.
            if (salary < 0) {
                System.out.println("Salary can't be negative. Please re-enter the details.");
                i--; // Decrement to repeat the current iteration.
                continue;
            }

            System.out.print("Email: ");
            String email = input.next();
            employees.put(i, new Employees(name, deptname, email, salary));
        }

        int choice;
        // Interactive menu for searching employees.
        do {
            System.out.println("\nEnter 1 to search for an employee, or 0 to exit.");
            choice = input.nextInt();
            if (choice == 1) {
                System.out.print("Enter Employee ID to search: ");
                int id = input.nextInt();
                Employees e = details(id, employees);
                if (e == null) {
                    System.out.println("Employee not found.");
                } else {
                    System.out.println("Name: " + e.getName() + ", Salary: " + e.getSalary() +
                            ", Department: " + e.getDepartment() + ", Email: " + e.getEmailId());
                }
            }
        } while (choice != 0);
    }
}