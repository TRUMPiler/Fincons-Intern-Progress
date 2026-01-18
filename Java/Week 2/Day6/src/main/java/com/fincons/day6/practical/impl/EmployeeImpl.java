package com.fincons.day6.practical.impl;

import com.fincons.day6.practical.model.Employee;
import com.fincons.day6.practical.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of the {@link EmployeeService} interface (Version 2).
 *
 * This class provides an in-memory implementation for managing employees.
 */
@Service("employeeServiceV2")
public final class EmployeeImpl implements EmployeeService {


    List<Employee> employees=new ArrayList<>();

    /**
     * Initializes the employee repository with some default data.
     */
    EmployeeImpl()
    {
        System.out.println("EmployeeImpl");
        employees.add(Employee.builder()
                .id(1)
                .name("Naisal")
                .department("IT")
                .salary(40000.0).build());
        employees.add(Employee.builder()
                .id(2)
                .name("Riya Jain")
                .department("IT")
                .salary(90000.0).build());
        employees.add(Employee.builder()
                .id(3)
                .name("Deven Hirlekar")
                .department("Finance")
                .salary(40000.0).build());
        employees.add(Employee.builder()
                .id(4)
                .name("Harshita")
                .department("Finance")
                .salary(40000.0).build());

    }




    /**
     * {@inheritDoc}
     */
    @Override
    public boolean setEmployee(Employee employee) {
       return this.employees.add(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee getEmployees(int id) {
        return this.employees.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean updateEmployee(int id, double salary) {
      return this.employees.stream().filter(employee -> employee.getId() == id).peek(employee -> employee.setSalary(salary)).anyMatch(employee -> employee.getSalary() == salary);
    }


}
