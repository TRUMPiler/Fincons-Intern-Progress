package com.fincons.day7.exception;

/**
 * Custom exception thrown when a requested Task is not found.
 * This extends RuntimeException, making it an unchecked exception.
 */
public class TaskNotFoundException extends RuntimeException {
    /**
     * Constructs a new TaskNotFoundException with the specified detail message.
     *
     * @param message The detail message.
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}
