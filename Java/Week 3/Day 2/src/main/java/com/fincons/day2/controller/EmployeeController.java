
package com.fincons.day2.controller;

import com.fincons.day2.dto.EmployeeDto;
import com.fincons.day2.service.EmployeeService;
import com.fincons.day2.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * REST controller for handling employee-related web requests.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Injects the EmployeeService to handle business logic.
     * @param employeeService The service for employee operations.
     */
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Handles GET requests to fetch an employee by their ID.
     * @param id The UUID of the employee to retrieve.
     * @return A ResponseEntity containing the response.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Response<EmployeeDto>> getEmployeeById(@PathVariable UUID id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        Response<EmployeeDto> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Employee found", employeeDto);
        return ResponseEntity.ok(response);
    }

    /**
     * Handles GET requests to fetch all employees.
     * @return A ResponseEntity containing the list of all employees.
     */
    @GetMapping
    public ResponseEntity<Response<List<EmployeeDto>>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        Response<List<EmployeeDto>> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Employees retrieved successfully", employees);
        return ResponseEntity.ok(response);
    }

    /**
     * Handles POST requests to create a new employee.
     * @param employeeDto The data for the new employee.
     * @return A ResponseEntity containing the newly created employee.
     */
    @PostMapping
    public ResponseEntity<Response<EmployeeDto>> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto);
        Response<EmployeeDto> response = new Response<>(LocalDateTime.now(), HttpStatus.CREATED.value(), "Employee created successfully", createdEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Handles PUT requests to update an existing employee.
     * @param id The UUID of the employee to update.
     * @param employeeDto The new data for the employee.
     * @return A ResponseEntity containing the updated employee.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Response<EmployeeDto>> updateEmployee(@PathVariable UUID id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto);
        Response<EmployeeDto> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Employee updated successfully", updatedEmployee);
        return ResponseEntity.ok(response);
    }

    /**
     * Handles DELETE requests to remove an employee.
     * @param id The UUID of the employee to delete.
     * @return A ResponseEntity indicating the outcome.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
        Response<Void> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Employee deleted successfully", null);
        return ResponseEntity.ok(response);
    }
}
