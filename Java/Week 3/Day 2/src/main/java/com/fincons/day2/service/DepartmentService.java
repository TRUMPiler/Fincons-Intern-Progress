
package com.fincons.day2.service;

import com.fincons.day2.entity.Department;
import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing departments.
 */
public interface DepartmentService {

    /**
     * Retrieves a department by its ID.
     *
     * @param id The ID of the department to retrieve.
     * @return The department with the specified ID, or null if not found.
     */
    Department getDepartmentById(UUID id);

    /**
     * Retrieves a list of all departments.
     *
     * @return A list of all departments.
     */
    List<Department> getAllDepartments();

    /**
     * Creates a new department.
     *
     * @param department The department to create.
     * @return The created department.
     */
    Department createDepartment(Department department);

    /**
     * Updates an existing department.
     *
     * @param id         The ID of the department to update.
     * @param department The updated department information.
     * @return The updated department, or null if the department with the specified ID is not found.
     */
    Department updateDepartment(UUID id, Department department);

    /**
     * Deletes a department by its ID.
     *
     * @param id The ID of the department to delete.
     */
    void deleteDepartment(UUID id);
}
