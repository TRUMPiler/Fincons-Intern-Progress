package com.example.exception;

// Custom exception to indicate that an employee could not be found.
public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
