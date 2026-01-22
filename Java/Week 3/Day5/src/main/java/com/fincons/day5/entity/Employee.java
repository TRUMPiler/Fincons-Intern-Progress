package com.fincons.day5.entity;

import jakarta.persistence.*;

/**
 * Represents an Employee entity in the system.
 * This class is mapped to the "employeeDay5W3" table in the database.
 */
@Entity
@Table
public class Employee {

    /**
     * Unique identifier for the employee.
     * It is the primary key and is auto-generated using identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the employee.
     */
    private String firstName;

    /**
     * The last name of the employee.
     */
    private String lastName;

    /**
     * The email address of the employee.
     * This should be unique for each employee.
     */
    private String email;

    /**
     * The password for the employee's account.
     * This should ideally be stored as a hashed value.
     */
    private String password;

    /**
     * Default constructor.
     */
    public Employee() {
    }

    /**
     * Constructor to create an Employee object with all fields.
     *
     * @param id The unique identifier of the employee.
     * @param firstName The first name of the employee.
     * @param lastName The last name of the employee.
     * @param email The email address of the employee.
     * @param password The password for the employee's account.
     */
    public Employee(Long id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    /**
     * Retrieves the unique identifier of the employee.
     *
     * @return The employee's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the employee.
     *
     * @param id The employee's ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the first name of the employee.
     *
     * @return The employee's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee.
     *
     * @param firstName The employee's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the employee.
     *
     * @return The employee's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the employee.
     *
     * @param lastName The employee's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the email address of the employee.
     *
     * @return The employee's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the employee.
     *
     * @param email The employee's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the password of the employee.
     *
     * @return The employee's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the employee.
     *
     * @param password The employee's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
