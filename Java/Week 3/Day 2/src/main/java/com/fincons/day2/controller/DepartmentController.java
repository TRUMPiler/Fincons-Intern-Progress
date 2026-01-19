
package com.fincons.day2.controller;

import com.fincons.day2.entity.Department;
import com.fincons.day2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

/**
 * REST controller for managing departments.
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * Retrieves a department by its ID.
     *
     * @param id The ID of the department to retrieve.
     * @return The department with the specified ID.
     */
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable UUID id) {
        return departmentService.getDepartmentById(id);
    }

    /**
     * Retrieves a list of all departments.
     *
     * @return A list of all departments.
     */
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    /**
     * Creates a new department.
     *
     * @param department The department to create.
     * @return The created department.
     */
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    /**
     * Updates an existing department.
     *
     * @param id         The ID of the department to update.
     * @param department The updated department information.
     * @return The updated department.
     */
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable UUID id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    /**
     * Deletes a department by its ID.
     *
     * @param id The ID of the department to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable UUID id) {
        departmentService.deleteDepartment(id);
    }
}
