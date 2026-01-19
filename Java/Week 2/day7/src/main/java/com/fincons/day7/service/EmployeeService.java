package com.fincons.day7.service;

import com.fincons.day7.EmployeeDto;
import com.fincons.day7.EmployeeFilterDto;
import com.fincons.day7.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Service class for creating, retrieving, and filtering employee data.
 */
@Service
public class EmployeeService {

    private final AtomicLong counter = new AtomicLong();
    private final Map<Long, Employee> employees = new ConcurrentHashMap<>();

    /**
     * Creates a new employee from a DTO after validating their details.
     */
    public Employee createEmployee(EmployeeDto employeeDto) {
        if (employeeDto.getName() == null || employeeDto.getName().isEmpty()) {
            throw new IllegalArgumentException("Employee name must not be empty.");
        }

        if (employeeDto.getSalary() <= 0) {
            throw new IllegalArgumentException("Employee salary must be a positive value.");
        }

        long id = counter.incrementAndGet();
        Employee emp = new Employee(id, employeeDto.getName(), employeeDto.getDepartment(), employeeDto.getSalary());

        employees.put(id, emp);
        return emp;
    }

    /**
     * Retrieves an employee by their unique ID.
     */
    public Employee getEmployeeById(long id) {
        return employees.get(id);
    }

    /**
     * Retrieves a list of employees, filtered by department if provided in the DTO.
     */
    public List<Employee> getEmployeesByDepartment(EmployeeFilterDto filterDto) {
        String department = filterDto.getDepartment();
        if (department == null) {
            return List.copyOf(employees.values());
        }
        return employees.values().stream()
                .filter(employee -> department.equalsIgnoreCase(employee.getDepartment()))
                .collect(Collectors.toList());
    }
}
