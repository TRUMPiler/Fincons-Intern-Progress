package com.fincons.day7.exception;

import com.fincons.day7.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for the application.
 * This class uses Spring's @ControllerAdvice to provide centralized exception handling
 * across all @Controller classes, ensuring a consistent response format for errors.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles {@link UserNotFoundException}.
     * This is triggered when a specific user is requested but not found in the database.
     * Logs the event and returns a 404 Not Found status with a standardized response object.
     *
     * @param ex      The UserNotFoundException that was thrown.
     * @param request The current web request, used here to get the session ID for logging.
     * @return A ResponseEntity containing the standardized error response and HTTP status NOT_FOUND.
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        log.info("{} User Not Found: \n{}", request.getSessionId(), ex.getMessage());
        Response<String> response = new Response<>(LocalDateTime.now(), ex.getLocalizedMessage(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles {@link InvalidTaskStatusException}.
     * This is triggered when an invalid or null status is provided for a task operation.
     * Logs the event and returns a 400 Bad Request status with a standardized response object.
     *
     * @param ex      The InvalidTaskStatusException that was thrown.
     * @param request The current web request.
     * @return A ResponseEntity containing the standardized error response and HTTP status BAD_REQUEST.
     */
    @ExceptionHandler(InvalidTaskStatusException.class)
    public ResponseEntity<Object> handleInvalidTaskStatusException(InvalidTaskStatusException ex, WebRequest request) {
        log.info("{} invalid task found: \n{}", request.getSessionId(), ex.getMessage());
        Response<String> response = new Response<>(LocalDateTime.now(), ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles {@link TaskNotFoundException}.
     * This is triggered when a specific task is requested but not found.
     * Logs the event and returns a 404 Not Found status with a standardized response object.
     *
     * @param ex      The TaskNotFoundException that was thrown.
     * @param request The current web request.
     * @return A ResponseEntity containing the standardized error response and HTTP status NOT_FOUND.
     */
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Object> handleTaskNotFoundException(TaskNotFoundException ex, WebRequest request) {
        log.info("{} Task not found \n{}", request.getSessionId(), ex.getMessage());
        Response<String> response = new Response<>(LocalDateTime.now(), ex.getLocalizedMessage(), HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles {@link UnauthorizedException}.
     * This is triggered when a user tries to access or modify a resource they do not own.
     * Logs the event and returns a 403 Forbidden status with a standardized response object.
     *
     * @param ex      The UnauthorizedException that was thrown.
     * @param request The current web request.
     * @return A ResponseEntity containing the standardized error response and HTTP status FORBIDDEN.
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Object> handleUnauthorizedException(UnauthorizedException ex, WebRequest request) {
        log.warn("{} Unauthorized access attempt: \n{}", request.getSessionId(), ex.getMessage());
        Response<String> response = new Response<>(LocalDateTime.now(), "Unauthorized", HttpStatus.FORBIDDEN.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    /**
     * Handles {@link IllegalArgumentException}.
     * This can be triggered by various invalid method arguments, such as a duplicate email during user creation.
     * Logs the event and returns a 400 Bad Request status with a standardized response object.
     *
     * @param ex      The IllegalArgumentException that was thrown.
     * @param request The current web request.
     * @return A ResponseEntity containing the standardized error response and HTTP status BAD_REQUEST.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        log.info("{} Illegal Argument: \n{}", request.getSessionId(), ex.getMessage());
        Response<String> response = new Response<>(LocalDateTime.now(), "Illegal Argument", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles validation exceptions for @Valid annotated request bodies (e.g., in DTOs).
     * This is triggered when the validation constraints on a DTO are violated.
     * It collects all validation errors into a map (field -> error message) and returns a 400 Bad Request.
     *
     * @param ex The MethodArgumentNotValidException that was thrown.
     * @return A ResponseEntity containing a map of validation errors within the standardized response object.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex,WebRequest request) {
        log.info("{} Validation Exception: \n{}", request.getSessionId(), ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        Response<Map<String, String>> response = new Response<>(LocalDateTime.now(), "Validation Failed", HttpStatus.BAD_REQUEST.value(), errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * A generic exception handler for any other unexpected exceptions that are not caught by more specific handlers.
     * This acts as a safety net to prevent unhandled exceptions from propagating to the client.
     * Logs the full stack trace for debugging and returns a 500 Internal Server Error.
     *
     * @param ex      The Exception that was thrown.
     * @param request The current web request.
     * @return A ResponseEntity containing a generic error message and HTTP status INTERNAL_SERVER_ERROR.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
        log.error("{} Unexpected error: \n{}", request.getSessionId(), ex.getMessage(), ex);
        Response<String> response = new Response<>(LocalDateTime.now(), "An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
