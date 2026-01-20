
package com.fincons.day2.service;

import com.fincons.day2.dto.DepartmentDto;
import java.util.List;
import java.util.UUID;

/**
 * Defines the business logic for managing departments.
 * This interface acts as a contract for the DepartmentServiceImpl.
 */
public interface DepartmentService {

    /**
     * Finds a department by its ID.
     * @param id The ID of the department to find.
     * @return The data transfer object for the found department.
     */
    DepartmentDto getDepartmentById(UUID id);

    /**
     * Retrieves a list of all departments.
     * @return A list of all department data transfer objects.
     */
    List<DepartmentDto> getAllDepartments();

    /**
     * Creates a new department.
     * @param departmentDto The data needed to create the new department.
     * @return The data transfer object for the newly created department.
     */
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    /**
     * Updates an existing department's information.
     * @param id The ID of the department to update.
     * @param departmentDto The new data for the department.
     * @return The data transfer object for the updated department.
     */
    DepartmentDto updateDepartment(UUID id, DepartmentDto departmentDto);

    /**
     * Deletes a department from the system.
     * @param id The ID of the department to delete.
     */
    void deleteDepartment(UUID id);
}
