package com.fincons.day5.practical.controller;

import com.fincons.day5.practical.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * I created this controller to handle my employee-related API requests.
 */
@RestController
@RequestMapping("/api/practical")
public class EmployeeController {
    // I'm using a simple in-memory list to store my employees for now.
    private final List<Employee> employees = new ArrayList<>();

    /**
     * I'm initializing my employee list with some sample data here.
     */
    public EmployeeController() {
        employees.add(new Employee(1, "Alice", "Engineering"));
        employees.add(new Employee(2, "Bob", "Marketing"));
        employees.add(new Employee(3, "Charlie", "Sales"));
    }

    /**
     * I created this API to fetch an employee by their ID.
     *
     * @param id The ID of the employee I want to fetch.
     * @return The employee if I find them, otherwise null.
     */
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable long id) {
        // I'm using a stream to find the employee with the matching ID.
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null); // I'll return null if I can't find the employee.
    }
}
