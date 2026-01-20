
package com.fincons.day3.exception;

import com.fincons.day3.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * Global exception handler for the application.
 * This class uses @ControllerAdvice to handle exceptions across the whole application in one global handling component.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles ResourceNotFoundException.
     * This method is called when a ResourceNotFoundException is thrown from any controller.
     *
     * @param ex      the exception that was thrown.
     * @param request the current web request.
     * printing the session id of the request for better tracing.
     * @return a ResponseEntity with a custom error response.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Response<Object>> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        log.info(request.getSessionId());
        Response<Object> response = new Response<>(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<Response<Object>> handleResourceAlreadyExists(ResourceAlreadyExists ex, WebRequest request) {
        log.info(request.getSessionId()+" resource already exists for: "+ex.getMessage());
        Response<Object> response = new Response<>(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    /**
     * Handles all other exceptions.
     * This method is a fallback for any other exception that is not specifically handled.
     *
     * @param ex      the exception that was thrown.
     * @param request the current web request.
     * @return a ResponseEntity with a generic internal server error response.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<Object>> handleGlobalException(Exception ex, WebRequest request) {
        log.info(request.getSessionId()+" is facing issue with:\n "+ex.getMessage());
        Response<Object> response = new Response<>(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
