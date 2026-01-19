package com.fincons.day1.service;

import com.fincons.day1.dto.EmployeeCreationDto;
import com.fincons.day1.dto.EmployeeDTO;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing employees.
 * Defines the contract for employee-related operations.
 */
public interface EmployeeService {

    /**
     * Retrieves an employee by their unique ID.
     *
     * @param id The UUID of the employee to retrieve.
     * @return An {@link EmployeeDTO} containing the employee's data, or {@code null} if not found.
     */
    EmployeeDTO getEmployee(UUID id);

    /**
     * Retrieves a list of all employees.
     *
     * @return A list of {@link EmployeeDTO}s for all employees.
     */
    List<EmployeeDTO> getAllEmployees();

    /**
     * Creates a new employee based on the provided data.
     *
     * @param employee The data for the new employee, encapsulated in an {@link EmployeeCreationDto}.
     * @return The created {@link EmployeeDTO} with its new ID, or null if an employee with the same email already exists.
     */
    EmployeeDTO setEmployee(EmployeeCreationDto employee);

    /**
     * Updates an existing employee's information.
     *
     * @param id       The UUID of the employee to update.
     * @param employee The new data for the employee, encapsulated in an {@link EmployeeCreationDto}.
     * @return The updated {@link EmployeeDTO}, or {@code null} if the employee was not found.
     */
    EmployeeDTO updateEmployee(UUID id, EmployeeCreationDto employee);

    /**
     * Deletes an employee by their unique ID.
     *
     * @param id The UUID of the employee to delete.
     * @return true if the employee was successfully deleted, false otherwise.
     */
    boolean deleteEmployee(UUID id);
}
