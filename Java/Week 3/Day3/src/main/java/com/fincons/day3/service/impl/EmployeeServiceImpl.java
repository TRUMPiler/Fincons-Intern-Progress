
package com.fincons.day3.service.impl;

import com.fincons.day3.dto.EmployeeDto;
import com.fincons.day3.dto.EmployeeFilterDto;
import com.fincons.day3.entity.Employee;
import com.fincons.day3.exception.ResourceNotFoundException;
import com.fincons.day3.mapper.EmployeeMapper;

import com.fincons.day3.repository.EmployeeRepository;
import com.fincons.day3.service.EmployeeService;
import com.fincons.day3.utils.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Implements the business logic for managing employees.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;
    private final PasswordEncrypter passwordEncrypter = new PasswordEncrypter();

    /**
     * Constructor for injecting dependencies.
     * @param employeeRepository The repository for employee data.

     * @param employeeMapper The mapper for converting between Employee and EmployeeDto.
     */
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;

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
        // For new employees, we'll set a default password and encrypt it.
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
    public EmployeeDto updateEmployee(UUID id, EmployeeFilterDto employeeDto) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));


        existingEmployee.setSalary(employeeDto.getSalary()>0.0?employeeDto.getSalary():existingEmployee.getSalary());

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

    @Override
    public List<EmployeeDto> getEmployeeByFilter(String department) {

        Optional<List<Employee>> emp=employeeRepository.findByDepartment(department);
        if (emp.isEmpty()) {
            throw new ResourceNotFoundException("Employee not found with department: " + department);
        }
        return emp.map(employees -> employees.stream().map(employeeMapper::toDto).collect(Collectors.toList())).orElse(null);
    }

    @Override
    public List<EmployeeDto> getEmployeeByFilter(double salary) {
        Optional<List<Employee>> emp=employeeRepository.findBySalaryGreaterThan(salary);
        if (emp.isEmpty()) { throw new ResourceNotFoundException("Employee not found with salary more than: " + salary); }
        return emp.map(employees -> employees.stream().map(employeeMapper::toDto).collect(Collectors.toList())).orElse(null);
    }

}
