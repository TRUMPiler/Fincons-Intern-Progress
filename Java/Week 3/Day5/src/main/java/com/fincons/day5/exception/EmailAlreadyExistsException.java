package com.fincons.day5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception to indicate that an email address provided for an employee
 * already exists in the system.
 * This exception will result in an HTTP 409 Conflict status being returned to the client.
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class EmailAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new EmailAlreadyExistsException with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
