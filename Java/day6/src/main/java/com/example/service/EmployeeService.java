package com.example.service;

import com.example.exception.EmployeeNotFoundException;
import com.example.exception.InvalidSalaryException;
import com.example.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// This service class handles all the business logic for managing employees.
public class EmployeeService {
    // We use a Map to store employees, with the employee's ID as the key.
    private final Map<Integer, Employee> employees = new HashMap<>();

    // Adds a new employee to our collection.
    public void addEmployee(Employee employee) {
        // Check if an employee with the same ID already exists to prevent duplicates.
        if (employees.containsKey(employee.getId())) {
            throw new IllegalArgumentException("Employee with ID " + employee.getId() + " already exists.");
        }
        // Ensure that the employee's salary is not a negative number.
        if (employee.getSalary() < 0) {
            throw new InvalidSalaryException("Salary cannot be negative.");
        }
        // If all checks pass, add the employee to the map.
        employees.put(employee.getId(), employee);
    }

    // Returns all the employees currently in our system.
    public Collection<Employee> viewAllEmployees() {
        return employees.values();
    }

    // Finds a single employee by their ID.
    public Employee findEmployeeById(int id) throws EmployeeNotFoundException {
        // Get the employee from the map.
        Employee employee = employees.get(id);
        // If no employee is found, we throw a custom exception.
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
        // Return the found employee.
        return employee;
    }

    // Updates the salary for an existing employee.
    public void updateSalary(int id, double newSalary) throws EmployeeNotFoundException {
        // First, find the employee to make sure they exist.
        Employee employee = findEmployeeById(id);
        // Validate that the new salary is not negative.
        if (newSalary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative.");
        }
        // Set the new salary for the employee.
        employee.setSalary(newSalary);
    }

    // Removes an employee from the system using their ID.
    public void removeEmployee(int id) throws EmployeeNotFoundException {
        // If remove() returns null, it means no employee with that ID was found.
        if (employees.remove(id) == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }
    }
}
