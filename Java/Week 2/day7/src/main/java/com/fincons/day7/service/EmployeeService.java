package com.fincons.day7.service;

import com.fincons.day7.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Service class for managing employees.
 * This class provides methods for creating, retrieving, and filtering employee data.
 */
@Service
public class EmployeeService {

    private final AtomicLong counter = new AtomicLong();
    private final Map<Long, Employee> employees = new ConcurrentHashMap<>();

    /**
     * Creates a new employee after validating their details.
     *
     * <p>
     * Note on validation:
     * For projects with numerous validation rules, consider using a dedicated
     * validation framework such as Jakarta Bean Validation. This allows for
     * cleaner, more maintainable code by using annotations directly on the model.
     * </p>
     *
     * @param employee The employee object to be created.
     * @return The newly created employee with a generated ID.
     * @throws IllegalArgumentException if the employee's name is null/empty or the salary is not positive.
     */
    public Employee createEmployee(Employee employee) {
        if (employee.getName() == null || employee.getName().isEmpty()) {
            throw new IllegalArgumentException("Employee name must not be empty.");
        }

        if (employee.getSalary() <= 0) {
            throw new IllegalArgumentException("Employee salary must be a positive value.");
        }

        long id = counter.incrementAndGet();
        employee.setId(id);
        employees.put(id, employee);
        return employee;
    }

    /**
     * Retrieves an employee by their unique ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return The employee corresponding to the given ID, or {@code null} if not found.
     */
    public Employee getEmployeeById(long id) {
        return employees.get(id);
    }

    /**
     * Retrieves a list of all employees or filters them by department.
     *
     * If a department is provided, this method returns a list of employees
     * belonging to that department (case-insensitive). If the department is
     * {@code null}, it returns a list of all employees.
     *
     * @param department The department name to filter by. Can be {@code null}.
     * @return A list of {@link Employee} objects.
     */
    public List<Employee> getEmployeesByDepartment(String department) {
        if (department == null) {
            return List.copyOf(employees.values());
        }
        return employees.values().stream()
                .filter(employee -> department.equalsIgnoreCase(employee.getDepartment()))
                .collect(Collectors.toList());
    }
}
