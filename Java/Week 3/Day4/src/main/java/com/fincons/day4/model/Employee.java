package com.fincons.day4.model;

import javax.persistence.*;

/**
 * Represents an Employee entity.
 * This class is mapped to the "employee" table in the database.
 */
@Entity
@Table(name = "EmployeeDay4")
public class Employee {

    // Unique identifier for the employee, generated automatically
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Employee's name
    private String name;

    // Employee's email
    private String email;

    // Employee's salary
    private double salary;

    // Default constructor
    public Employee() {
    }

    // Constructor with all fields
    public Employee(Long id, String name, String email, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
