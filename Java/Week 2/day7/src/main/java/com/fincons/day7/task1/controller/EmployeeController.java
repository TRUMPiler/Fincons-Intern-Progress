package com.fincons.day7.task1.controller;

import com.fincons.day7.EmployeeDto;
import com.fincons.day7.entity.Employee;
import com.fincons.day7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for handling employee creation requests.
 */
@RestController("task1EmployeeController")
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    //constructor injection
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Handles the HTTP POST request to create a new employee.
     *
     * @param employeeDto The employee data sent in the request body.
     * @return A ResponseEntity containing the created employee and a 200 OK status.
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee createdEmployee = employeeService.createEmployee(employeeDto);
        return ResponseEntity.ok(createdEmployee);
    }
}
