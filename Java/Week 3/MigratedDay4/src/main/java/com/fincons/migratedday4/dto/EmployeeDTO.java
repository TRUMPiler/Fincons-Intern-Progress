package com.fincons.migratedday4.dto;

import jakarta.validation.constraints.*;

/**
 * Data Transfer Object for Employee entity.
 * This class is used to transfer employee data between the client and the server.
 */
public class EmployeeDTO {

    private Long id;

    /**
     * Employee's first name.
     * It cannot be blank and must be between 2 and 50 characters.
     */
    @NotBlank(message = "First name is mandatory")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    /**
     * Employee's last name.
     * It cannot be blank and must be between 2 and 50 characters.
     */
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    /**
     * Employee's email address.
     * It cannot be blank and must be a valid email format.
     */
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    /**
     * Employee's phone number.
     * It cannot be blank and must match a valid phone number pattern.
     */
    @NotBlank(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is not valid")
    private String phoneNumber;

    /**
     * Employee's salary.
     * It must be a positive value and cannot exceed 1,000,000.
     */
    @Positive(message = "Salary must be positive")
    @Min(value = 1, message = "Salary must be at least 1")
    @Max(value = 1000000, message = "Salary cannot exceed 1,000,000")
    private Double salary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String firstName, String lastName, String email, String phoneNumber, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

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
