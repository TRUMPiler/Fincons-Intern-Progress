package com.fincons.migratedday4.model;

import jakarta.persistence.*;


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

    // Employee's first name
    private String firstName;

    // Employee's last name
    private String lastName;

    // Employee's email
    private String email;

    // Employee's phone number
    private String phoneNumber;

    // Employee's salary
    private double salary;

    // Default constructor
    public Employee() {
    }

    // Constructor with all fields
    public Employee(Long id, String firstName, String lastName, String email, String phoneNumber, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
