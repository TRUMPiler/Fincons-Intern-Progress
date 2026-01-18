package com.fincons.day6.handsOn.service;

import com.fincons.day6.handsOn.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for managing employees.
 *
 * This interface defines the contract for employee-related operations, such as
 * adding and retrieving employees.
 */
public interface EmployeeService {

    /**
     * Adds a new employee to the system.
     *
     * @param employee The employee to add.
     * @return {@code true} if the employee was added successfully, {@code false} otherwise.
     */
    public boolean setEmployee(Employee employee);

    /**
     * Retrieves a list of employees based on specified criteria.
     *
     * @param department The department to filter by (can be {@code null}).
     * @param salary The minimum salary to filter by.
     * @return A list of employees matching the criteria.
     */
    public List<Employee> getEmployees(String department, double salary);



}
