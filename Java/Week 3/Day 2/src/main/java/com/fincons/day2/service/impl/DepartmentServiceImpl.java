
package com.fincons.day2.service.impl;

import com.fincons.day2.entity.Department;
import com.fincons.day2.repository.DepartmentRepository;
import com.fincons.day2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of the DepartmentService interface.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /**
     * Retrieves a department by its ID.
     *
     * @param id The ID of the department to retrieve.
     * @return The department with the specified ID, or null if not found.
     */
    @Override
    public Department getDepartmentById(UUID id) {
        return departmentRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves a list of all departments.
     *
     * @return A list of all departments.
     */
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    /**
     * Creates a new department.
     *
     * @param department The department to create.
     * @return The created department.
     */
    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    /**
     * Updates an existing department.
     *
     * @param id         The ID of the department to update.
     * @param department The updated department information.
     * @return The updated department, or null if the department with the specified ID is not found.
     */
    @Override
    public Department updateDepartment(UUID id, Department department) {
        if (departmentRepository.existsById(id)) {
            department.setId(id);
            return departmentRepository.save(department);
        }
        return null;
    }

    /**
     * Deletes a department by its ID.
     *
     * @param id The ID of the department to delete.
     */
    @Override
    public void deleteDepartment(UUID id) {
        departmentRepository.deleteById(id);
    }
}
