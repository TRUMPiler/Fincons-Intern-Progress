
package com.fincons.day2.service.impl;

import com.fincons.day2.entity.Employee;
import com.fincons.day2.repository.EmployeeRepository;
import com.fincons.day2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of the EmployeeService interface.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return The employee with the specified ID, or null if not found.
     */
    @Override
    public Employee getEmployeeById(UUID id) {
        return employeeRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves a list of all employees.
     *
     * @return A list of all employees.
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Creates a new employee.
     *
     * @param employee The employee to create.
     * @return The created employee.
     */
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Updates an existing employee.
     *
     * @param id       The ID of the employee to update.
     * @param employee The updated employee information.
     * @return The updated employee, or null if the employee with the specified ID is not found.
     */
    @Override
    public Employee updateEmployee(UUID id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param id The ID of the employee to delete.
     */
    @Override
    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }
}
