
package com.fincons.day3.entity;



import jakarta.persistence.*;

import java.util.UUID;

/**
 * Represents an Employee record in the database.
 */
@Entity
@Table(name="Employee_Day3")
public class Employee {

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


    /**
     * The department this employee belongs to.
     */

    private String department;

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


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
