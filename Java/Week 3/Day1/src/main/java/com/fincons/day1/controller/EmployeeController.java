package com.fincons.day1.controller;

import com.fincons.day1.dto.EmployeeCreationDto;
import com.fincons.day1.dto.EmployeeDTO;
import com.fincons.day1.service.EmployeeService;
import com.fincons.day1.utils.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * REST controller for managing employees.
 * Provides endpoints for creating, retrieving, updating, and deleting employees.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService es;

    /**
     * Retrieves an employee by their ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return A ResponseEntity containing the response with the employee data if found,
     *         or a not found response if the employee does not exist.
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<Response<EmployeeDTO>> getEmployee(@PathVariable UUID id) {
        EmployeeDTO employee = es.getEmployee(id);
        Response<EmployeeDTO> response = new Response<>();
        response.setTime(LocalDateTime.now());
        if (employee != null) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Employee found");
            response.setData(employee);
            return ResponseEntity.ok(response);
        } else {
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMessage("Employee not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves all employees.
     *
     * @return A ResponseEntity containing the response with a list of all employees.
     */
    @GetMapping("/all")
    public ResponseEntity<Response<List<EmployeeDTO>>> getAllEmployees() {
        List<EmployeeDTO> employees = es.getAllEmployees();
        Response<List<EmployeeDTO>> response = new Response<>();
        response.setTime(LocalDateTime.now());
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Employees retrieved successfully");
        response.setData(employees);
        return ResponseEntity.ok(response);
    }

    /**
     * Creates a new employee.
     *
     * @param employee The employee data for creation.
     * @return A ResponseEntity containing the response with the created employee's data.
     */
    @PostMapping("/create")
    public ResponseEntity<Response<EmployeeDTO>> createEmployee(@Valid @RequestBody EmployeeCreationDto employee) {
        EmployeeDTO createdEmployee = es.setEmployee(employee);
        Response<EmployeeDTO> response = new Response<>();
        response.setTime(LocalDateTime.now());
        if (createdEmployee != null) {
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setMessage("Employee created successfully");
            response.setData(createdEmployee);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.setStatusCode(HttpStatus.CONFLICT.value());
            response.setMessage("Employee with this email already exists");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }

    /**
     * Partially updates an existing employee.
     *
     * @param id              The ID of the employee to update.
     * @param employeeDetails The new details for the employee.
     * @return A ResponseEntity containing the response with the updated employee's data if found,
     *         or a not found response if the employee does not exist.
     */
    @PatchMapping("/update/{id}")
    public ResponseEntity<Response<EmployeeDTO>> updateEmployee(@PathVariable UUID id, @RequestBody EmployeeCreationDto employeeDetails) {
        EmployeeDTO updatedEmployee = es.updateEmployee(id, employeeDetails);
        Response<EmployeeDTO> response = new Response<>();
        response.setTime(LocalDateTime.now());
        if (updatedEmployee != null) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Employee updated successfully");
            response.setData(updatedEmployee);
            return ResponseEntity.ok(response);
        } else {
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMessage("Employee not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param id The ID of the employee to delete.
     * @return A ResponseEntity with a success or failure message.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response<Void>> deleteEmployee(@PathVariable UUID id) {
        boolean deleted = es.deleteEmployee(id);
        Response<Void> response = new Response<>();
        response.setTime(LocalDateTime.now());
        if (deleted) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Employee deleted successfully");
            return ResponseEntity.ok(response);
        } else {
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMessage("Employee not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
