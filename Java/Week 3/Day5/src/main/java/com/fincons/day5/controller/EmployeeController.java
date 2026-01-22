package com.fincons.day5.controller;

import com.fincons.day5.dto.EmployeeDTO;
import com.fincons.day5.service.EmployeeService;
import com.fincons.day5.utils.Response; // Correct import for the generic Response class from utils
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime; // Import LocalDateTime
import java.util.List;

/**
 * REST controller for managing Employee resources.
 * Provides endpoints for CRUD operations on employees.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    /**
     * Autowired EmployeeService to handle business logic related to employees.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * Handles HTTP POST requests to create a new employee.
     *
     * @param employeeDTO The EmployeeDTO object containing employee details to be created.
     * @return A ResponseEntity containing a Response object with the created EmployeeDTO and HTTP status CREATED.
     */
    @PostMapping
    public ResponseEntity<Response<EmployeeDTO>> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        // Call service to create the employee
        EmployeeDTO createdEmployee = employeeService.createEmployee(employeeDTO);
        // Create a standardized success response using the utils.Response class
        Response<EmployeeDTO> response = new Response<>(LocalDateTime.now(), HttpStatus.CREATED.value(), "Employee created successfully", createdEmployee);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Handles HTTP GET requests to retrieve an employee by their ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return A ResponseEntity containing a Response object with the EmployeeDTO if found, and HTTP status OK.
     *         Throws ResourceNotFoundException if no employee is found with the given ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Response<EmployeeDTO>> getEmployeeById(@PathVariable Long id) {
        // Call service to get the employee by ID
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        // Create a standardized success response using the utils.Response class
        Response<EmployeeDTO> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Employee fetched successfully", employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles HTTP GET requests to retrieve all employees.
     *
     * @return A ResponseEntity containing a Response object with a list of all EmployeeDTOs and HTTP status OK.
     */
    @GetMapping
    public ResponseEntity<Response<List<EmployeeDTO>>> getAllEmployees() {
        // Call service to get all employees
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        // Create a standardized success response using the utils.Response class
        Response<List<EmployeeDTO>> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "All employees details fetched successfully", employees);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles HTTP PUT requests to update an existing employee.
     *
     * @param id The ID of the employee to update.
     * @param employeeDTO The EmployeeDTO object containing updated employee details.
     * @return A ResponseEntity containing a Response object with the updated EmployeeDTO and HTTP status OK.
     *         Throws ResourceNotFoundException if no employee is found with the given ID.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Response<EmployeeDTO>> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        // Call service to update the employee
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        // Create a standardized success response using the utils.Response class
        Response<EmployeeDTO> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Employee updated successfully", updatedEmployee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Handles HTTP DELETE requests to delete an employee by their ID.
     *
     * @param id The ID of the employee to delete.
     * @return A ResponseEntity containing a Response object with a success message and HTTP status NO_CONTENT.
     *         Throws ResourceNotFoundException if no employee is found with the given ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteEmployee(@PathVariable Long id) {
        // Call service to delete the employee
        employeeService.deleteEmployee(id);
        // Create a standardized success response using the utils.Response class
        Response<Void> response = new Response<>(LocalDateTime.now(), HttpStatus.NO_CONTENT.value(), "Employee deleted successfully", null);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}
