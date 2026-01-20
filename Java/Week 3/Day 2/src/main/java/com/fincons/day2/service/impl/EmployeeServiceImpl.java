
package com.fincons.day2.service.impl;

import com.fincons.day2.dto.EmployeeDto;
import com.fincons.day2.entity.Department;
import com.fincons.day2.entity.Employee;
import com.fincons.day2.exception.ResourceNotFoundException;
import com.fincons.day2.mapper.EmployeeMapper;
import com.fincons.day2.repository.DepartmentRepository;
import com.fincons.day2.repository.EmployeeRepository;
import com.fincons.day2.service.EmployeeService;
import com.fincons.day2.utils.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implements the business logic for managing employees.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;
    private final PasswordEncrypter passwordEncrypter = new PasswordEncrypter();

    /**
     * Constructor for injecting dependencies.
     * @param employeeRepository The repository for employee data.
     * @param departmentRepository The repository for department data.
     * @param employeeMapper The mapper for converting between Employee and EmployeeDto.
     */
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;
    }

    /**
     * Finds an employee by their ID.
     * @param id The ID of the employee to find.
     * @return The data transfer object for the found employee.
     * @throws ResourceNotFoundException if no employee with the given ID is found.
     */
    @Override
    public EmployeeDto getEmployeeById(UUID id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return employeeMapper.toDto(employee);
    }

    /**
     * Retrieves a list of all employees.
     * @return A list of all employee data transfer objects.
     */
    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Creates a new employee from the given data.
     * @param employeeDto The data needed to create the new employee.
     * @return The data transfer object for the newly created employee.
     */
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        if (employeeDto.getDepartmentId() != null) {
            Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + employeeDto.getDepartmentId()));
            employee.setDepartment(department);
        }
        // For new employees, we'll set a default password and encrypt it.
        employee.setPassword(passwordEncrypter.passwordEncryptor("password"));
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.toDto(savedEmployee);
    }

    /**
     * Updates an existing employee's information.
     * @param id The ID of the employee to update.
     * @param employeeDto The new data for the employee.
     * @return The data transfer object for the updated employee.
     * @throws ResourceNotFoundException if no employee with the given ID is found.
     */
    @Override
    public EmployeeDto updateEmployee(UUID id, EmployeeDto employeeDto) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        existingEmployee.setName(employeeDto.getName());
        existingEmployee.setSalary(employeeDto.getSalary());

        if (employeeDto.getDepartmentId() != null) {
            Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + employeeDto.getDepartmentId()));
            existingEmployee.setDepartment(department);
        } else {
            existingEmployee.setDepartment(null);
        }

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return employeeMapper.toDto(updatedEmployee);
    }

    /**
     * Deletes an employee from the system.
     * @param id The ID of the employee to delete.
     * @throws ResourceNotFoundException if no employee with the given ID is found.
     */
    @Override
    public void deleteEmployee(UUID id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
