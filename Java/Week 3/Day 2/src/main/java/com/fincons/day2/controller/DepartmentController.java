
package com.fincons.day2.controller;

import com.fincons.day2.dto.DepartmentDto;
import com.fincons.day2.service.DepartmentService;
import com.fincons.day2.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * REST controller for handling department-related web requests.
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    /**
     * Injects the DepartmentService to handle business logic.
     * @param departmentService The service for department operations.
     */
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * Handles GET requests to fetch a department by its ID.
     * @param id The UUID of the department to retrieve.
     * @return A ResponseEntity containing the response.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Response<DepartmentDto>> getDepartmentById(@PathVariable UUID id) {
        DepartmentDto departmentDto = departmentService.getDepartmentById(id);
        Response<DepartmentDto> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Department found", departmentDto);
        return ResponseEntity.ok(response);
    }

    /**
     * Handles GET requests to fetch all departments.
     * @return A ResponseEntity containing the list of all departments.
     */
    @GetMapping
    public ResponseEntity<Response<List<DepartmentDto>>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        Response<List<DepartmentDto>> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Departments retrieved successfully", departments);
        return ResponseEntity.ok(response);
    }

    /**
     * Handles POST requests to create a new department.
     * @param departmentDto The data for the new department.
     * @return A ResponseEntity containing the newly created department.
     */
    @PostMapping
    public ResponseEntity<Response<DepartmentDto>> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto createdDepartment = departmentService.createDepartment(departmentDto);
        Response<DepartmentDto> response = new Response<>(LocalDateTime.now(), HttpStatus.CREATED.value(), "Department created successfully", createdDepartment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Handles PUT requests to update an existing department.
     * @param id The UUID of the department to update.
     * @param departmentDto The new data for the department.
     * @return A ResponseEntity containing the updated department.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Response<DepartmentDto>> updateDepartment(@PathVariable UUID id, @RequestBody DepartmentDto departmentDto) {
        DepartmentDto updatedDepartment = departmentService.updateDepartment(id, departmentDto);
        Response<DepartmentDto> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Department updated successfully", updatedDepartment);
        return ResponseEntity.ok(response);
    }

    /**
     * Handles DELETE requests to remove a department.
     * @param id The UUID of the department to delete.
     * @return A ResponseEntity indicating the outcome.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Void>> deleteDepartment(@PathVariable UUID id) {
        departmentService.deleteDepartment(id);
        Response<Void> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Department deleted successfully", null);
        return ResponseEntity.ok(response);
    }
}
