package day4.handsOn;

import java.util.*;
import java.util.stream.*;

// Demonstrates the use of Java Streams to process a list of employees.
public class MainGetter {
    public static void main(String[] args) {
        // Creating a list of employees, including duplicates.
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Riya", "9326163059", "naisaldoshi@gmail.com", 2));
        emp.add(new Employee("Naisal", "9326163059", "naisaldoshi@gmail.com", 1));
        emp.add(new Employee("Riya", "9326163059", "naisaldoshi@gmail.com", 1));

        // Using a stream to sort the employees, remove duplicates, and collect them into a LinkedHashSet.
        LinkedHashSet<Employee> filteredEmp = emp.stream()
                .sorted()       // Sorts the stream based on the compareTo method in Employee.
                .distinct()     // Removes duplicate employees based on the equals and hashCode methods.
                .collect(Collectors.toCollection(LinkedHashSet::new)); // Collects the result into a LinkedHashSet to maintain order.

        // Iterating through the filtered set and printing the details of each unique, sorted employee.
        for (Employee e : filteredEmp) {
            System.out.printf("id: %d, name: %s, PhoneNumber: %s, email: %s%n",
                    e.getId(), e.getName(), e.getPhonenumber(), e.getEmail());
        }
    }
}