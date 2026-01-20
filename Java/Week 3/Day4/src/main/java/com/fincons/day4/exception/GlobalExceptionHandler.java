package com.fincons.day4.exception;

import com.fincons.day4.utils.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Global exception handler for the application.
 * This class uses @ControllerAdvice to handle exceptions across all controllers.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles EmployeeNotFoundException.
     * Returns a 404 Not Found response with a custom error message using the Response class.
     * @param ex The exception that was thrown.
     * @return A ResponseEntity with the error details and HTTP status.
     */
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Response<Object>> handleEmployeeNotFoundException(
            EmployeeNotFoundException ex) {

        Response<Object> response = new Response<>(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                null
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles InvalidSalaryException.
     * Returns a 400 Bad Request response with a custom error message using the Response class.
     * @param ex The exception that was thrown.
     * @return A ResponseEntity with the error details and HTTP status.
     */
    @ExceptionHandler(InvalidSalaryException.class)
    public ResponseEntity<Response<Object>> handleInvalidSalaryException(
            InvalidSalaryException ex) {

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
     * @param headers The HTTP headers.
     * @param status The HTTP status.
     * @param request The current web request.
     * @return A ResponseEntity with a list of validation errors and HTTP status.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        Response<Object> response = new Response<>(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Validation failed",
                errors
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
