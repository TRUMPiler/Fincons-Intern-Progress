package com.fincons.day6.practical.model;

import lombok.Builder;
import lombok.Data;

/**
 * Represents an employee in the system.
 *
 * This class defines the structure of an employee, including their ID, name,
 * department, and salary.
 */
@Data
@Builder
public class Employee {

    /**
     * The unique identifier for the employee.
     */
    private int id;

    /**
     * The name of the employee.
     */
    private String name;

    /**
     * The department the employee belongs to.
     */
    private String department;

    /**
     * The salary of the employee.
     */
    private double salary;
}
