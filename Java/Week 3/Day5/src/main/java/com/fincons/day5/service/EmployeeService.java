package com.fincons.day5.service;

import com.fincons.day5.dto.EmployeeDTO;

import java.util.List;

/**
 * Service interface for managing Employee operations.
 * Defines the contract for business logic related to employees.
 */
public interface EmployeeService {

    /**
     * Creates a new employee.
     *
     * @param employeeDTO The Data Transfer Object containing the details of the employee to be created.
     * @return The EmployeeDTO of the newly created employee.
     */
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    /**
     * Retrieves an employee by their unique identifier.
     *
     * @param id The unique ID of the employee to retrieve.
     * @return The EmployeeDTO corresponding to the given ID.
     * @throws com.fincons.day5.exception.ResourceNotFoundException if no employee is found with the given ID.
     */
    EmployeeDTO getEmployeeById(Long id);

    /**
     * Retrieves a list of all employees.
     *
     * @return A list of EmployeeDTOs representing all employees in the system.
     */
    List<EmployeeDTO> getAllEmployees();

    /**
     * Updates an existing employee.
     *
     * @param id The unique ID of the employee to update.
     * @param employeeDTO The Data Transfer Object containing the updated details for the employee.
     * @return The EmployeeDTO of the updated employee.
     * @throws com.fincons.day5.exception.ResourceNotFoundException if no employee is found with the given ID.
     */
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    /**
     * Deletes an employee by their unique identifier.
     *
     * @param id The unique ID of the employee to delete.
     * @throws com.fincons.day5.exception.ResourceNotFoundException if no employee is found with the given ID.
     */
    void deleteEmployee(Long id);
}
