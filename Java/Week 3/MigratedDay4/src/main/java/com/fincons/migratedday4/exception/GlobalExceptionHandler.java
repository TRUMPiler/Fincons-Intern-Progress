package com.fincons.migratedday4.exception;

import com.fincons.migratedday4.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Global exception handler for the application.
 * This class uses @ControllerAdvice to handle exceptions across all controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles EmployeeNotFoundException.
     * Returns a 404 Not Found response with a custom error message using the Response class.
     * @param ex The exception that was thrown.
     * @param request The current web request.
     * @return A ResponseEntity with the error details and HTTP status.
     */
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Response<Object>> handleEmployeeNotFoundException(
            EmployeeNotFoundException ex, WebRequest request) {

        String sessionId = request.getSessionId();
        logger.error("Session ID: {} - Error: {}", sessionId, ex.getMessage());

        Response<Object> response = new Response<>(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                null
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles DuplicateEmployeeException.
     * Returns a 409 Conflict response with a custom error message using the Response class.
     * @param ex The exception that was thrown.
     * @param request The current web request.
     * @return A ResponseEntity with the error details and HTTP status.
     */
    @ExceptionHandler(DuplicateEmployeeException.class)
    public ResponseEntity<Response<Object>> handleDuplicateEmployeeException(
            DuplicateEmployeeException ex, WebRequest request) {

        String sessionId = request.getSessionId();
        logger.error("Session ID: {} - Error: {}", sessionId, ex.getMessage());

        Response<Object> response = new Response<>(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                null
        );

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    /**
     * Handles InvalidIdException.
     * Returns a 400 Bad Request response with a custom error message using the Response class.
     * @param ex The exception that was thrown.
     * @param request The current web request.
     * @return A ResponseEntity with the error details and HTTP status.
     */
    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<Response<Object>> handleInvalidIdException(
            InvalidIdException ex, WebRequest request) {

        String sessionId = request.getSessionId();
        logger.error("Session ID: {} - Error: {}", sessionId, ex.getMessage());

        Response<Object> response = new Response<>(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles MethodArgumentNotValidException, which is thrown when bean validation fails.
     * Returns a 400 Bad Request response with a list of all validation errors using the Response class.
     * @param ex The exception containing validation errors.
     * @param request The current web request.
     * @return A ResponseEntity with a list of validation errors and HTTP status.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, WebRequest request) {
        logger.info("{} Validation Exception: \n{}", request.getSessionId(), ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        Response<Map<String, String>> response = new Response<>(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Validation Errors", errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}
