package com.fincons.day5.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank; // Import @NotBlank
import jakarta.validation.constraints.Size;   // Import @Size

/**
 * Data Transfer Object (DTO) for Employee.
 * This class is used to transfer employee data between different layers of the application,
 * typically between the controller and the service layer, or for exposing data via REST APIs.
 */
public class EmployeeDTO {
    /**
     * The unique identifier of the employee.
     */
    private Long id;

    /**
     * The first name of the employee.
     * It must not be null or contain only whitespace.
     * The length must be between 2 and 50 characters.
     */
    @NotBlank(message = "First name must not be blank.")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters.")
    private String firstName;

    /**
     * The last name of the employee.
     * It must not be null or contain only whitespace.
     * The length must be between 2 and 50 characters.
     */
    @NotBlank(message = "Last name must not be blank.")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters.")
    private String lastName;

    /**
     * The email address of the employee.
     * It must not be null or blank, must be a well-formed email address,
     * and its length must not exceed 100 characters.
     */
    @NotBlank(message = "Email must not be blank.")
    @Email(message = "Email should be a valid email address.")
    @Size(max = 100, message = "Email must not exceed 100 characters.")
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

    // Getters and Setters remain the same

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
}
