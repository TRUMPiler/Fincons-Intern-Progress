package com.fincons.day5.exception;

import com.fincons.day5.utils.Response; // Import the generic Response class from utils
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * Global exception handler to centralize the handling of exceptions across all @Controller classes.
 * This class provides a consistent way to return error responses to the client using a standardized Response object.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles {@link ResourceNotFoundException}, which is thrown when a requested resource is not found.
     *
     * @param ex The ResourceNotFoundException instance.
     * @param request The current web request, providing access to request details.
     * @return A {@link ResponseEntity} containing a standardized error {@link Response} object and HTTP status NOT_FOUND.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response<Object>> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        // Create a standardized error response using the utils.Response class
        Response<Object> errorResponse = new Response<>(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                null // No data payload for error responses
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles {@link EmailAlreadyExistsException}, which is thrown when an attempt is made to create
     * or update an employee with an email that already exists in the system.
     *
     * @param ex The EmailAlreadyExistsException instance.
     * @param request The current web request, providing access to request details.
     * @return A {@link ResponseEntity} containing a standardized error {@link Response} object and HTTP status CONFLICT.
     */
    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Response<Object>> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex, WebRequest request) {
        // Create a standardized error response for email conflict using the utils.Response class
        Response<Object> errorResponse = new Response<>(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                null // No data payload for error responses
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    /**
     * Handles all other unhandled {@link Exception}s. This serves as a fallback mechanism for any unexpected errors
     * that are not specifically caught by other exception handlers.
     *
     * @param ex The Exception instance.
     * @param request The current web request, providing access to request details.
     * @return A {@link ResponseEntity} containing a standardized error {@link Response} object and HTTP status INTERNAL_SERVER_ERROR.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Object>> handleGlobalException(Exception ex, WebRequest request) {
        // Create a standardized error response for generic exceptions using the utils.Response class
        Response<Object> errorResponse = new Response<>(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred: " + ex.getMessage(),
                null // No data payload for error responses
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
