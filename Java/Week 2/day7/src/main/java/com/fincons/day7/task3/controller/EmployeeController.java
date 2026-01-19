package com.fincons.day7.task3.controller;

import com.fincons.day7.EmployeeFilterDto;
import com.fincons.day7.entity.Employee;
import com.fincons.day7.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for handling requests to retrieve and filter employees.
 */
@RestController("task3EmployeeController")
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Retrieves a list of employees, optionally filtered by criteria in the DTO.
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@ModelAttribute EmployeeFilterDto filterDto) {
        List<Employee> employees = employeeService.getEmployeesByDepartment(filterDto);
        return ResponseEntity.ok(employees);
    }
}
