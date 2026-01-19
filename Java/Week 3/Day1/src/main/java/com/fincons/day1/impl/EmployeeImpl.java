package com.fincons.day1.impl;

import com.fincons.day1.dto.EmployeeCreationDto;
import com.fincons.day1.dto.EmployeeDTO;
import com.fincons.day1.entity.Employee;
import com.fincons.day1.repository.EmployeeRepository;
import com.fincons.day1.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implementation of the EmployeeService interface.
 * Handles business logic for employee operations.
 */
@Slf4j
@Service
public class EmployeeImpl implements EmployeeService {

    private final EmployeeRepository er;

    /**
     * Constructs an EmployeeImpl with the given EmployeeRepository.
     *
     * @param employeeRepository The repository for employee data access.
     */
    public EmployeeImpl(EmployeeRepository employeeRepository) {
        this.er = employeeRepository;
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return The employee DTO if found, otherwise null.
     */
    @Override
    public EmployeeDTO getEmployee(UUID id) {
        Optional<Employee> getEmployee = er.findById(id);
        if (getEmployee.isPresent()) {
            return mapToDto(getEmployee.get());
        } else {
            log.error("Employee not found: {}", id);
            return null;
        }
    }

    /**
     * Retrieves all employees.
     *
     * @return A list of all employee DTOs.
     */
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return er.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    /**
     * Creates a new employee.
     *
     * @param employeecr The DTO for creating the employee.
     * @return The DTO of the newly created employee.
     */
    @Override
    public EmployeeDTO setEmployee(EmployeeCreationDto employeecr) {
        if (er.existsByEmail(employeecr.getEmail())) {
            log.error("Employee with email {} already exists.", employeecr.getEmail());
            return null;
        }
        Employee employee = new Employee();
        employee.setName(employeecr.getName());
        employee.setEmail(employeecr.getEmail());
        employee.setPhone(employeecr.getPhone());
        employee.setAddress(employeecr.getAddress());
        Employee savedEmployee = er.save(employee);
        return mapToDto(savedEmployee);
    }

    /**
     * Updates an existing employee.
     *
     * @param id              The ID of the employee to update.
     * @param employeeDetails The DTO with the new employee details.
     * @return The DTO of the updated employee, or null if the employee was not found.
     */
    @Override
    public EmployeeDTO updateEmployee(UUID id, EmployeeCreationDto employeeDetails) {
        Optional<Employee> employeeOptional = er.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            if (employeeDetails.getName() != null) {
                employee.setName(employeeDetails.getName());
            }
            if (employeeDetails.getEmail() != null) {
                employee.setEmail(employeeDetails.getEmail());
            }
            if (employeeDetails.getPhone() != null) {
                employee.setPhone(employeeDetails.getPhone());
            }
            if (employeeDetails.getAddress() != null) {
                employee.setAddress(employeeDetails.getAddress());
            }
            Employee updatedEmployee = er.save(employee);
            return mapToDto(updatedEmployee);
        } else {
            log.error("Employee not found for update: {}", id);
            return null;
        }
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param id The ID of the employee to delete.
     * @return true if the employee was deleted, false otherwise.
     */
    @Override
    public boolean deleteEmployee(UUID id) {
        if (er.existsById(id)) {
            er.deleteById(id);
            return true;
        } else {
            log.error("Employee not found for deletion: {}", id);
            return false;
        }
    }

    /**
     * Maps an Employee entity to an EmployeeDTO.
     *
     * @param employee The employee entity to map.
     * @return The resulting employee DTO.
     */
    private EmployeeDTO mapToDto(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId().toString())
                .name(employee.getName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .address(employee.getAddress())
                .build();
    }
}
