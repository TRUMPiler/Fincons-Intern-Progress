package com.fincons.day2.service.impl;

import com.fincons.day2.dto.DepartmentDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.fincons.day2.dto.DepartmentDto;
import com.fincons.day2.entity.Department;
import com.fincons.day2.exception.ResourceAlreadyExists;
import com.fincons.day2.exception.ResourceNotFoundException;
import com.fincons.day2.mapper.DepartmentMapper;
import com.fincons.day2.repository.DepartmentRepository;
import com.fincons.day2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implements the business logic for managing departments.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    /**
     * Constructor for injecting dependencies.
     *
     * @param departmentRepository The repository for department data.
     * @param departmentMapper     The mapper for converting between Department and DepartmentDto.
     */
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.departmentMapper = departmentMapper;
    }

    /**
     * Finds a department by its ID.
     *
     * @param id The ID of the department to find.
     * @return The data transfer object for the found department.
     * @throws ResourceNotFoundException if no department with the given ID is found.
     */
    @Override
    public DepartmentDto getDepartmentById(UUID id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        return departmentMapper.toDto(department);
    }

    /**
     * Retrieves a list of all departments.
     *
     * @return A list of all department data transfer objects.
     */
    @Override
    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(departmentMapper::toDto)
                .collect(Collectors.toList());
    }


    /**
     * Creates a new department from the given data.
     *
     * @param departmentDto The data needed to create the new department.
     * @return The data transfer object for the newly created department.
     **/
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = departmentMapper.toEntity(departmentDto);
        Optional<Department> optionalDepartment = departmentRepository.findByName((department.getName()));
        if (optionalDepartment.isPresent()) {
            throw new ResourceAlreadyExists("Department already exists");
        }
        Department savedDepartment = departmentRepository.save(department);
        return departmentMapper.toDto(savedDepartment);
    }
    /**
     * Updates an existing department's information.
     * @param id The ID of the department to update.
     * @param departmentDto The new data for the department.
     * @return The data transfer object for the updated department.
     */
    @Override
    public DepartmentDto updateDepartment(UUID id, DepartmentDto departmentDto) {
        Optional<Department> optionalDepartment=departmentRepository.findById(id);
        if(optionalDepartment.isPresent())
        {
            Department department=optionalDepartment.get();
            department.setName(departmentDto.getName());
            Department updatedDepartment=departmentRepository.save(department);
            return departmentMapper.toDto(updatedDepartment);
        }
        else
        {
            throw new ResourceNotFoundException("Department not found with id: "+id);
        }
    }
    /**
     * Deletes a department from the system.
     * @param id The ID of the department to delete.
     */
    @Override
    public void deleteDepartment(UUID id)
    {
            departmentRepository.deleteById(id);
    }

}



