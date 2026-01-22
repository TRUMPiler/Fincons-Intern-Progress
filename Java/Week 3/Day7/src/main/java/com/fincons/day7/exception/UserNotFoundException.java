package com.fincons.day7.exception;

/**
 * Custom exception thrown when a requested User is not found.
 * This extends RuntimeException, making it an unchecked exception.
 */
public class UserNotFoundException extends RuntimeException {
    /**
     * Constructs a new UserNotFoundException with the specified detail message.
     *
     * @param message The detail message.
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}
