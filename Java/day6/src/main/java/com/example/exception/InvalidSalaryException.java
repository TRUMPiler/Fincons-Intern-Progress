package com.example.exception;

// Custom exception for when a salary is invalid, like being negative.
public class InvalidSalaryException extends RuntimeException {
    public InvalidSalaryException(String message) {
        super(message);
    }
}
