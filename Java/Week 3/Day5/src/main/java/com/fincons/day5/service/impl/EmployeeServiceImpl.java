package com.fincons.day5.service.impl;

import com.fincons.day5.dto.EmployeeDTO;
import com.fincons.day5.entity.Employee;
import com.fincons.day5.exception.EmailAlreadyExistsException; // Import the new exception
import com.fincons.day5.exception.ResourceNotFoundException;
import com.fincons.day5.mapper.EmployeeMapper;
import com.fincons.day5.repository.EmployeeRepository;
import com.fincons.day5.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional; // Import Optional
import java.util.stream.Collectors;

/**
 * Implementation of the {@link EmployeeService} interface.
 * This class provides the business logic for managing employee-related operations.
 * It interacts with the {@link EmployeeRepository} for data persistence and
 * uses {@link EmployeeMapper} for converting between entity and DTO objects.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * Autowired {@link EmployeeRepository} for database operations on Employee entities.
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Autowired {@link EmployeeMapper} for converting between Employee entity and EmployeeDTO.
     */
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * Creates a new employee in the database.
     *
     * @param employeeDTO The Data Transfer Object containing the details of the employee to be created.
     * @return The EmployeeDTO of the newly created employee, including its generated ID.
     * @throws EmailAlreadyExistsException if an employee with the given email already exists.
     */
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        // Check if an employee with the provided email already exists
        Optional<Employee> existingEmployeeByEmail = employeeRepository.findByEmail(employeeDTO.getEmail());
        if (existingEmployeeByEmail.isPresent()) {
            throw new EmailAlreadyExistsException("Employee with email " + employeeDTO.getEmail() + " already exists.");
        }

        // Convert DTO to entity
        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        // Save the entity to the database
        Employee savedEmployee = employeeRepository.save(employee);
        // Convert the saved entity back to DTO and return
        return employeeMapper.employeeToEmployeeDTO(savedEmployee);
    }

    /**
     * Retrieves an employee by their unique identifier.
     *
     * @param id The unique ID of the employee to retrieve.
     * @return The EmployeeDTO corresponding to the given ID.
     * @throws ResourceNotFoundException if no employee is found with the given ID.
     */
    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        // Find the employee by ID, or throw an exception if not found
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        // Convert the entity to DTO and return
        return employeeMapper.employeeToEmployeeDTO(employee);
    }

    /**
     * Retrieves a list of all employees.
     *
     * @return A list of EmployeeDTOs representing all employees in the system.
     */
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        // Retrieve all employees from the database, convert each to DTO, and collect into a list
        return employeeRepository.findAll().stream()
                .map(employeeMapper::employeeToEmployeeDTO)
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing employee.
     *
     * @param id The unique ID of the employee to update.
     * @param employeeDTO The Data Transfer Object containing the updated details for the employee.
     * @return The EmployeeDTO of the updated employee.
     * @throws ResourceNotFoundException if no employee is found with the given ID.
     * @throws EmailAlreadyExistsException if the updated email already belongs to another employee.
     */
    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        // Find the existing employee by ID, or throw an exception if not found
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        // Check if the updated email already exists for another employee
        Optional<Employee> employeeWithSameEmail = employeeRepository.findByEmail(employeeDTO.getEmail());
        if (employeeWithSameEmail.isPresent() && !employeeWithSameEmail.get().getId().equals(id)) {
            throw new EmailAlreadyExistsException("Employee with email " + employeeDTO.getEmail() + " already exists for another user.");
        }

        // Update the fields of the existing employee with data from the DTO
        existingEmployee.setFirstName(employeeDTO.getFirstName());
        existingEmployee.setLastName(employeeDTO.getLastName());
        existingEmployee.setEmail(employeeDTO.getEmail());


        // Save the updated employee entity
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        // Convert the updated entity to DTO and return
        return employeeMapper.employeeToEmployeeDTO(updatedEmployee);
    }

    /**
     * Deletes an employee by their unique identifier.
     *
     * @param id The unique ID of the employee to delete.
     * @throws ResourceNotFoundException if no employee is found with the given ID.
     */
    @Override
    public void deleteEmployee(Long id) {
        // Check if the employee exists before attempting to delete
        if (!employeeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Employee not found with id: " + id);
        }
        // Delete the employee by ID
        employeeRepository.deleteById(id);
    }
}
