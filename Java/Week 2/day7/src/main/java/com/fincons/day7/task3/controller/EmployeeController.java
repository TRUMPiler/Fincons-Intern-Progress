package com.fincons.day7.task3.controller;

import com.fincons.day7.entity.Employee;
import com.fincons.day7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for handling requests to retrieve and filter employees.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * Handles the HTTP GET request to retrieve a list of employees.
     * The list can be filtered by department using the 'department' request parameter.
     * If the parameter is not provided, all employees are returned.
     *
     * @param department The department to filter by (optional).
     * @return A ResponseEntity containing a list of employees and a 200 OK status.
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@RequestParam(required = false) String department) {
        List<Employee> employees = employeeService.getEmployeesByDepartment(department);
        return ResponseEntity.ok(employees);
    }
}
