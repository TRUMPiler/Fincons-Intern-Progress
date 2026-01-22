package com.fincons.day5.response;

import org.springframework.http.HttpStatus;

/**
 * Generic API Response class to standardize the output for all API endpoints.
 * It includes a status code, a message, and the actual data payload.
 *
 * @param <T> The type of the data payload.
 */
public class Response<T> {
    private int status;
    private String message;
    private T data;

    /**
     * Default constructor.
     */
    public Response() {
    }

    /**
     * Constructor to create a successful response.
     *
     * @param status The HTTP status code.
     * @param message A descriptive message for the response.
     * @param data The actual data payload.
     */
    public Response(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * Static factory method to create a success response.
     *
     * @param data The data payload.
     * @param <T> The type of the data payload.
     * @return A Response object indicating success.
     */
    public static <T> Response<T> success(T data) {
        return new Response<>(HttpStatus.OK.value(), "Success", data);
    }

    /**
     * Static factory method to create a success response with a custom message.
     *
     * @param data The data payload.
     * @param message A custom success message.
     * @param <T> The type of the data payload.
     * @return A Response object indicating success.
     */
    public static <T> Response<T> success(T data, String message) {
        return new Response<>(HttpStatus.OK.value(), message, data);
    }

    /**
     * Static factory method to create an error response.
     *
     * @param status The HTTP status code for the error.
     * @param message A descriptive error message.
     * @param <T> The type of the data payload (can be null for errors).
     * @return A Response object indicating an error.
     */
    public static <T> Response<T> error(HttpStatus status, String message) {
        return new Response<>(status.value(), message, null);
    }

    // Getters and Setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
