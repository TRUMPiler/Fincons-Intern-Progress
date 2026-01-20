package com.fincons.day1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Represents an Employee entity in the database.
 * This class is mapped to the "Employee" table.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EmployeeDay1")
public class Employee {

    /**
     * The unique identifier for the employee.
     * It is generated automatically as a UUID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    /**
     * The name of the employee.
     */
    @Column(name = "name")
    private String name;

    /**
     * The employee's password.
     * Note: Storing passwords in plain text is a security risk.
     * This should be handled with a secure hashing mechanism.
     */
    @Column(name = "password")
    private String password;

    /**
     * The email address of the employee.
     * This field must be unique.
     */
    @Column(name = "email", unique = true)
    private String email;

    /**
     * The phone number of the employee.
     */
    @Column(name = "phone")
    private String phone;

    /**
     * The physical address of the employee.
     */
    @Column(name = "address")
    private String address;
}
