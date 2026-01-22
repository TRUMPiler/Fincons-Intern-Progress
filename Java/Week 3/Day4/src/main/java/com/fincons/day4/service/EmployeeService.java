package com.fincons.day4.service;

import com.fincons.day4.dto.EmployeeDTO;
import com.fincons.day4.exception.EmployeeNotFoundException;
import com.fincons.day4.exception.InvalidSalaryException;
import com.fincons.day4.mapper.EmployeeMapper;
import com.fincons.day4.model.Employee;
import com.fincons.day4.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing employee data and business logic.
 * This class uses an EmployeeRepository to interact with the database and an EmployeeMapper to convert between entities and DTOs.
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    /**
     * Constructor for EmployeeService, using constructor injection.
     * @param employeeRepository The repository to be injected.
     * @param employeeMapper The mapper to be injected.
     */
    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    /**
     * Retrieves all employees from the database and converts them to DTOs.
     * @return A list of all employee DTOs.
     */
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employeeMapper::employeeToEmployeeDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a single employee by their ID from the database and converts it to a DTO.
     * Throws EmployeeNotFoundException if no employee is found.
     * @param id The ID of the employee to retrieve.
     * @return The EmployeeDTO with the specified ID.
     */
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
        return employeeMapper.employeeToEmployeeDTO(employee);
    }

    /**
     * Creates a new employee from a DTO and saves it to the database.
     * Throws InvalidSalaryException if the employee's salary is not positive.
     * @param employeeDTO The EmployeeDTO to create.
     * @return The newly created EmployeeDTO with a generated ID.
     */
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        // Validate that the salary is positive
        if (employeeDTO.getSalary() <= 0) {
            throw new InvalidSalaryException("Salary must be positive");
        }
        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeDTO(savedEmployee);
    }
}
