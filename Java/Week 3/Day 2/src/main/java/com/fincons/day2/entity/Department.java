
package com.fincons.day2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

/**
 * Represents a Department record in the database.
 */
@Entity
public class Department {

    /**
     * The unique ID for the department. This is generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * The name of the department (e.g., "Human Resources", "Engineering").
     */
    private String name;

    /**
     * The list of employees who are part of this department.
     */
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    /**
     * Standard getters and setters.
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
