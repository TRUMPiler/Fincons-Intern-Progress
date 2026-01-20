package com.fincons.day3.controller;

import com.fincons.day3.dto.EmployeeDto;
import com.fincons.day3.dto.EmployeeFilterDto;
import com.fincons.day3.entity.Employee;
import com.fincons.day3.service.EmployeeService;
import com.fincons.day3.utils.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    private final EmployeeService employeeService;

    /**
     * Injects the EmployeeService to handle business logic.
     * @param employeeService The service for employee operations.
     */
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /**
     *  Filter to fetch Employees based on Department and Salary
     * @param employeeFilterDto
     * @return ResponseEntity Response with filtered list
     */
    @GetMapping("/getByFilter")
    public ResponseEntity<Response<List<EmployeeDto>>> getByFilter(
            @ModelAttribute EmployeeFilterDto employeeFilterDto) {
        List<EmployeeDto> finalList=new ArrayList<>();
        if(employeeFilterDto.getDepartment()!=null&&employeeFilterDto.getSalary()<=0.0){
            finalList=employeeService.getEmployeeByFilter(employeeFilterDto.getDepartment());
        }
        else if(employeeFilterDto.getSalary()>0.0&&employeeFilterDto.getDepartment()==null)
        {
            finalList=employeeService.getEmployeeByFilter(employeeFilterDto.getSalary());
        }
        else if(employeeFilterDto.getSalary()>0.0&&employeeFilterDto.getDepartment()!=null)
        {
            List<EmployeeDto> salaryList =
                    employeeService.getEmployeeByFilter(employeeFilterDto.getSalary());

            List<EmployeeDto> departmentList =
                    employeeService.getEmployeeByFilter(employeeFilterDto.getDepartment());

            finalList = salaryList.stream()
                    .filter(departmentList::contains)
                    .toList();
        }


        Response<List<EmployeeDto>> res =
                new Response<>(
                        LocalDateTime.now(),
                        HttpStatus.OK.value(),
                        "Filtered List Successfully",
                        finalList
                );

        return ResponseEntity.ok(res);
    }

    /**
            *
            * Handles GET requests to fetch an employee by their ID.
            * @param id The UUID of the employee to retrieve.
            * @return A ResponseEntity containing the response.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Response<EmployeeDto>> getEmployeeById(@PathVariable UUID id) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        Response<EmployeeDto> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Employee found", employeeDto);
        return ResponseEntity.ok(response);
    }

    /**
     * Handles GET requests to fetch all employees.
     * @return A ResponseEntity containing the list of all employees.
     */
    @GetMapping
    public ResponseEntity<Response<List<EmployeeDto>>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        Response<List<EmployeeDto>> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Employees retrieved successfully", employees);
        return ResponseEntity.ok(response);
    }

    /**
     * Handles POST requests to create a new employee.
     * @param employeeDto The data for the new employee.
     * @return A ResponseEntity containing the newly created employee.
     */
    @PostMapping
    public ResponseEntity<Response<EmployeeDto>> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        EmployeeDto createdEmployee = employeeService.createEmployee(employeeDto);
        Response<EmployeeDto> response = new Response<>(LocalDateTime.now(), HttpStatus.CREATED.value(), "Employee created successfully", createdEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Handles PUT requests to update salary of an existing employee.
     * @param id The UUID of the employee to update.
     * @param employeeDto The new data for the employee.
     * @return A ResponseEntity containing the updated employee.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Response<EmployeeDto>> updateEmployee(@PathVariable UUID id,@Valid @RequestBody EmployeeFilterDto employeeDto) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employeeDto);
        Response<EmployeeDto> response = new Response<>(LocalDateTime.now(), HttpStatus.OK.value(), "Employee updated successfully", updatedEmployee);
        return ResponseEntity.ok(response);
    }


}
