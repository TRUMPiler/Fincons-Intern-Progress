package com.fincons.day5.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

/**
 * Data Transfer Object (DTO) for Employee.
 * This class is used to transfer employee data between different layers of the application,
 * typically between the controller and the service layer, or for exposing data via REST APIs.
 * It includes validation annotations to ensure data integrity.
 */
public class EmployeeDTO {
    /**
     * The unique identifier of the employee.
     */
    private Long id;

    /**
     * The first name of the employee.
     * It must not be null or empty.
     */
    @NotEmpty(message = "First name must not be empty.")
    private String firstName;

    /**
     * The last name of the employee.
     * It must not be null or empty.
     */
    @NotEmpty(message = "Last name must not be empty.")
    private String lastName;

    /**
     * The email address of the employee.
     * It must not be null or empty and must be a well-formed email address.
     */
    @NotEmpty(message = "Email must not be empty.")
    @Email(message = "Email should be valid.")
    private String email;

    /**
     * Default constructor for EmployeeDTO.
     */
    public EmployeeDTO() {
    }

    /**
     * Constructor to create an EmployeeDTO object with all fields.
     *
     * @param id The unique identifier of the employee.
     * @param firstName The first name of the employee.
     * @param lastName The last name of the employee.
     * @param email The email address of the employee.
     */
    public EmployeeDTO(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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
}
