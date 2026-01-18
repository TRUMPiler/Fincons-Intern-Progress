package com.fincons.day6.handsOn.controller;

import com.fincons.day6.handsOn.model.Employee;
import com.fincons.day6.handsOn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling employee-related requests (Version 1).
 *
 * This controller provides endpoints for searching and retrieving employees.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeControllerV1 {

    @Autowired
    EmployeeService employeeService;


    /**
     * Searches for employees based on department and salary.
     *
     * @param department The department to filter by (optional).
     * @param salary The minimum salary to filter by (optional).
     * @return A list of employees matching the criteria.
     */
    @GetMapping("/search")
    public List<Employee> searchEmployee(@RequestParam(required = false) String department, @RequestParam(required = false, defaultValue = "-1") double salary)
    {
        return employeeService.getEmployees(department,salary);
    }
}
