package com.fincons.migratedday4.controller;

import com.fincons.migratedday4.dto.EmployeeDTO;
import com.fincons.migratedday4.service.EmployeeService;
import com.fincons.migratedday4.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * REST controller for managing employee-related operations.
 * Handles HTTP requests and delegates to EmployeeService for business logic.
 */
@RestController
@RequestMapping("/employees") // Base URL for all employee endpoints
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Constructor for EmployeeController, using constructor injection.
     * @param employeeService The service to be injected.
     */
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Retrieves a list of all employees.
     * GET /employees
     * @return A ResponseEntity containing a Response object with the list of employee DTOs.
     */
    @GetMapping
    public ResponseEntity<Response<List<EmployeeDTO>>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        Response<List<EmployeeDTO>> response = new Response<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Successfully retrieved all employees",
                employees
        );
        return ResponseEntity.ok(response);
    }

    /**
     * Retrieves a single employee by their ID.
     * GET /employees/{id}
     * @param id The ID of the employee to retrieve.
     * @return A ResponseEntity containing a Response object with the employee DTO.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Response<EmployeeDTO>> getEmployeeById(@PathVariable Long id) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        Response<EmployeeDTO> response = new Response<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Successfully retrieved employee with id: " + id,
                employee
        );
        return ResponseEntity.ok(response);
    }

    /**
     * Creates a new employee.
     * POST /employees
     * @param employeeDTO The EmployeeDTO to create, validated using @Valid.
     * @return A ResponseEntity containing a Response object with the created employee DTO.
     */
    @PostMapping
    public ResponseEntity<Response<EmployeeDTO>> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO createdEmployee = employeeService.createEmployee(employeeDTO);
        Response<EmployeeDTO> response = new Response<>(
                LocalDateTime.now(),
                HttpStatus.CREATED.value(),
                "Successfully created employee",
                createdEmployee
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Updates an existing employee.
     * PUT /employees/{id}
     * @param id The ID of the employee to update.
     * @param employeeDTO The updated employee data, validated using @Valid.
     * @return A ResponseEntity containing a Response object with the updated employee DTO.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Response<EmployeeDTO>> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        Response<EmployeeDTO> response = new Response<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Successfully updated employee with id: " + id,
                updatedEmployee
        );
        return ResponseEntity.ok(response);
    }

    /**
     * Deletes an employee by their ID.
     * DELETE /employees/{id}
     * @param id The ID of the employee to delete.
     * @return A ResponseEntity with a success message.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        Response<Void> response = new Response<>(
                LocalDateTime.now(),
                HttpStatus.NO_CONTENT.value(),
                "Successfully deleted employee with id: " + id,
                null
        );
        return ResponseEntity.ok(response);
    }
}
