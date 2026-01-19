
package com.fincons.day2.service;

import com.fincons.day2.entity.Employee;
import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing employees.
 */
public interface EmployeeService {

    /**
     * Retrieves an employee by their ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return The employee with the specified ID, or null if not found.
     */
    Employee getEmployeeById(UUID id);

    /**
     * Retrieves a list of all employees.
     *
     * @return A list of all employees.
     */
    List<Employee> getAllEmployees();

    /**
     * Creates a new employee.
     *
     * @param employee The employee to create.
     * @return The created employee.
     */
    Employee createEmployee(Employee employee);

    /**
     * Updates an existing employee.
     *
     * @param id       The ID of the employee to update.
     * @param employee The updated employee information.
     * @return The updated employee, or null if the employee with the specified ID is not found.
     */
    Employee updateEmployee(UUID id, Employee employee);

    /**
     * Deletes an employee by their ID.
     *
     * @param id The ID of the employee to delete.
     */
    void deleteEmployee(UUID id);
}
