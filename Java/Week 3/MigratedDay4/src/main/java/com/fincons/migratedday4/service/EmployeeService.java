package com.fincons.migratedday4.service;

import com.fincons.migratedday4.dto.EmployeeDTO;
import com.fincons.migratedday4.exception.DuplicateEmployeeException;
import com.fincons.migratedday4.exception.EmployeeNotFoundException;
import com.fincons.migratedday4.exception.InvalidIdException;
import com.fincons.migratedday4.mapper.EmployeeMapper;
import com.fincons.migratedday4.model.Employee;
import com.fincons.migratedday4.repository.EmployeeRepository;
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
        if (id <= 0) {
            throw new InvalidIdException("ID must be a positive value.");
        }
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
        if (employeeRepository.existsByEmail(employeeDTO.getEmail())) {
            throw new DuplicateEmployeeException("Employee with the same email already exists.");
        }
        if (employeeRepository.existsByPhoneNumber(employeeDTO.getPhoneNumber())) {
            throw new DuplicateEmployeeException("Employee with the same phone number already exists.");
        }
        Employee employee = employeeMapper.employeeDTOToEmployee(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.employeeToEmployeeDTO(savedEmployee);
    }

    /**
     * Updates an existing employee with new data from a DTO.
     * Throws InvalidIdException if the ID is not positive.
     * Throws EmployeeNotFoundException if the employee to update is not found.
     * Throws InvalidSalaryException if the new salary is not positive.
     * Throws DuplicateEmployeeException if the new email or phone number is already in use by another employee.
     * @param id The ID of the employee to update.
     * @param employeeDTO The DTO with the new employee data.
     * @return The updated EmployeeDTO.
     */
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        if (id <= 0) {
            throw new InvalidIdException("ID must be a positive value.");
        }

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

        if (employeeRepository.existsByEmail(employeeDTO.getEmail()) && !existingEmployee.getEmail().equals(employeeDTO.getEmail())) {
            throw new DuplicateEmployeeException("Employee with the same email already exists.");
        }

        if (employeeRepository.existsByPhoneNumber(employeeDTO.getPhoneNumber()) && !existingEmployee.getPhoneNumber().equals(employeeDTO.getPhoneNumber())) {
            throw new DuplicateEmployeeException("Employee with the same phone number already exists.");
        }

        existingEmployee.setFirstName(employeeDTO.getFirstName());
        existingEmployee.setLastName(employeeDTO.getLastName());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setPhoneNumber(employeeDTO.getPhoneNumber());
        existingEmployee.setSalary(employeeDTO.getSalary());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return employeeMapper.employeeToEmployeeDTO(updatedEmployee);
    }

    /**
     * Deletes an employee by their ID.
     * Throws InvalidIdException if the ID is not positive.
     * Throws EmployeeNotFoundException if the employee to delete is not found.
     * @param id The ID of the employee to delete.
     */
    public void deleteEmployee(Long id) {
        if (id <= 0) {
            throw new InvalidIdException("ID must be a positive value.");
        }
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
