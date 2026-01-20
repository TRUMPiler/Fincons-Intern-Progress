package com.fincons.day2.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 *
 * Custom Response set class for sending proper parameters of result
 * @JsonInclude(JsonInclude.Include.NON_NULL) specifies that if any field is null then don't
 * include it in final response
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    private LocalDateTime time;
    private int statusCode;
    private String message;
    private T data;
}
