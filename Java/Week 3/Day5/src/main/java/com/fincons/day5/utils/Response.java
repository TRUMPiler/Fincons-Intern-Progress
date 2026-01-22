package com.fincons.day5.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * A generic class for creating standardized API responses.
 * This class is used to wrap the data payload and provide additional context,
 * such as a timestamp, HTTP status code, and a message.
 *
 * @param <T> The type of the data payload to be included in the response.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Excludes fields with null values from the JSON output.
public class Response<T> {

    /**
     * The timestamp indicating when the response was generated.
     */
    private LocalDateTime date;

    /**
     * The HTTP status code for the response (e.g., 200 for OK, 404 for Not Found).
     */
    private int statusCode;

    /**
     * A descriptive message providing more information about the response,
     * such as "Success" or a specific error message.
     */
    private String message;

    /**
     * The actual data payload of the response.
     * This can be any type of object, such as a single DTO or a list of DTOs.
     */
    private T data;
}
