package com.fincons.day7.entity;

import lombok.Builder;

/**
 * Represents an employee record.
 */
@Builder
public class Employee {

    private long id;
    private String name;
    private String department;
    private double salary;

    // Default constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(long id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and setters for the employee properties

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
