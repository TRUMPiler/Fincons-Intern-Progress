
package com.fincons.day2.service;

import com.fincons.day2.dto.EmployeeDto;
import java.util.List;
import java.util.UUID;

/**
 * Defines the business logic for managing employees.
 * This interface acts as a contract for the EmployeeServiceImpl.
 */
public interface EmployeeService {

    /**
     * Finds an employee by their ID.
     * @param id The ID of the employee to find.
     * @return The data transfer object for the found employee.
     */
    EmployeeDto getEmployeeById(UUID id);

    /**
     * Retrieves a list of all employees.
     * @return A list of all employee data transfer objects.
     */
    List<EmployeeDto> getAllEmployees();

    /**
     * Creates a new employee.
     * @param employeeDto The data needed to create the new employee.
     * @return The data transfer object for the newly created employee.
     */
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    /**
     * Updates an existing employee's information.
     * @param id The ID of the employee to update.
     * @param employeeDto The new data for the employee.
     * @return The data transfer object for the updated employee.
     */
    EmployeeDto updateEmployee(UUID id, EmployeeDto employeeDto);

    /**
     * Deletes an employee from the system.
     * @param id The ID of the employee to delete.
     */
    void deleteEmployee(UUID id);
}
