package com.fincons.day6.practical.service;

import com.fincons.day6.practical.model.Employee;

import java.util.List;

/**
 * Service interface for managing employees (Version 2).
 *
 * This interface defines the contract for employee-related operations, such as
 * adding, retrieving, and updating employees.
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
     * Retrieves an employee by their ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return The employee with the specified ID.
     */
    public Employee getEmployees(int id);

    /**
     * Updates the salary of an employee.
     *
     * @param id The ID of the employee to update.
     * @param salary The new salary to set.
     * @return {@code true} if the update was successful, {@code false} otherwise.
     */
    public boolean updateEmployee(int id, double salary);


}
