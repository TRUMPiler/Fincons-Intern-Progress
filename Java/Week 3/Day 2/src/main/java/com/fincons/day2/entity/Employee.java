
package com.fincons.day2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
/**
 * Represents an Employee record in the database.
 */
@Entity
public class Employee {
//to study and implement collections.
    /**
     * The unique ID for the employee. This is generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * The employee's full name.
     */
    private String name;

    /**
     * The employee's salary.
     */
    private double salary;

    /**
     * The employee's encrypted password.
     */
    private String password;

    /**
     * The department this employee belongs to.
     */
    @ManyToOne
    private Department department;

    /**
     * Standard getters and setters for the fields.
     */
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
