package day2.task.b;

import java.util.Scanner;

// This is the main class that collects user input to create and display employee details.
// It demonstrates the use of the Employee class which inherits from the Address class.
public class MainGetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompting the user for employee and address information.
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter your age: ");
        int age = sc.nextInt();

        // Basic age validation.
        if (age < 18) {
            System.out.println("Invalid age");
            return;
        }

        System.out.println("Enter your salary: ");
        int salary = sc.nextInt();
        System.out.println("Enter your state: ");
        String state = sc.next();
        System.out.println("Enter your city: ");
        String city = sc.next();
        System.out.println("Enter your pincode: ");
        int pincode = sc.nextInt();

        // Creating an Employee object, which also initializes the Address part of it.
        Employee employee1 = new Employee(salary, name, (short) age, 1, city, pincode, state);

        // Printing the employee's details using the overridden toString method.
        System.out.println(employee1.toString());
    }
}