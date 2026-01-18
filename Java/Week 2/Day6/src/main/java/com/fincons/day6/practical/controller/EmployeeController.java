package com.fincons.day6.practical.controller;

import com.fincons.day6.practical.model.Employee;
import com.fincons.day6.practical.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling employee-related requests (Version 2).
 *
 * This controller provides endpoints for retrieving and updating employees.
 */
@RestController
@RequestMapping("/v2/employees")
public class EmployeeController {

    @Autowired
    @Qualifier("employeeServiceV2")
    EmployeeService employeeService;


    /**
     * Retrieves an employee by their ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return The employee with the specified ID.
     */
    @GetMapping("/{id}")
    public Employee searchEmployee(@PathVariable int id)
    {
        return employeeService.getEmployees(id);
    }

    /**
     * Updates the salary of an employee.
     *
     * @param id The ID of the employee to update.
     * @param salary The new salary to set.
     * @return {@code true} if the update was successful, {@code false} otherwise.
     */
    @PutMapping("/{id}")
    public boolean updateEmployee(@PathVariable int id, @RequestParam double salary)
    {
        return employeeService.updateEmployee(id,salary);
    }
}
