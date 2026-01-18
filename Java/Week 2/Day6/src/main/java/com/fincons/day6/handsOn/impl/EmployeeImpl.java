package com.fincons.day6.handsOn.impl;

import com.fincons.day6.handsOn.model.Employee;
import com.fincons.day6.handsOn.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Implementation of the {@link EmployeeService} interface.
 *
 * This class provides an in-memory implementation for managing employees.
 */
@Service
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
    public List<Employee> getEmployees(String department, double salary)
    {
        System.out.println(employees);
        System.out.println(department);
        if(this.employees.isEmpty()) {return null;}
        if(department == null && salary < 0) {return this.employees;}
        Stream<Employee> employeeStream = this.employees.stream();
        if (salary > 0) {
            employeeStream = employeeStream.filter(e -> e.getSalary() > salary);
        }
        if (department != null) {
            employeeStream = employeeStream.filter(e -> e.getDepartment().equals(department));
        }
        return employeeStream.toList();
    }
}
