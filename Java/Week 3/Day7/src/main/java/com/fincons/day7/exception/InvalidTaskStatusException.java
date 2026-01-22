package com.fincons.day7.exception;

/**
 * Custom exception thrown when an invalid task status is provided.
 * This extends RuntimeException, making it an unchecked exception.
 */
public class InvalidTaskStatusException extends RuntimeException {
    /**
     * Constructs a new InvalidTaskStatusException with the specified detail message.
     *
     * @param message The detail message.
     */
    public InvalidTaskStatusException(String message) {
        super(message);
    }
}
