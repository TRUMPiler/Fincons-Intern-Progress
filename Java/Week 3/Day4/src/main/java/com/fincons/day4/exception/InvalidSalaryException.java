package com.fincons.day4.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception thrown when an invalid salary is provided.
 * The @ResponseStatus annotation marks this exception to return a 400 Bad Request status.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidSalaryException extends RuntimeException {

    /**
     * Constructor for InvalidSalaryException.
     * @param message The detail message.
     */
    public InvalidSalaryException(String message) {
        super(message);
    }
}
