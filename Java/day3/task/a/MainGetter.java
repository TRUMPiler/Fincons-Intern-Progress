package day2.task.a;

import java.util.Scanner;

// This is the main class that collects user input to create and display employee details.
// It demonstrates the instantiation and usage of the Employee and Address classes.
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

        // Creating an Address object from the user's input.
        Address address = new Address(city, pincode, state);
        // Creating an Employee object, passing the Address object to its constructor.
        Employee employee1 = new Employee(address, salary, name, (short) age, 1);

        // Printing the employee's details using the overridden toString method.
        System.out.println(employee1.toString());
    }
}