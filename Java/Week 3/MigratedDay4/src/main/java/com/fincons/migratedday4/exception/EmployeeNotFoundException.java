package com.fincons.migratedday4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception thrown when an employee is not found.
 * The @ResponseStatus annotation marks this exception to return a 404 Not Found status.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

    /**
     * Constructor for EmployeeNotFoundException.
     * @param message The detail message.
     */
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
