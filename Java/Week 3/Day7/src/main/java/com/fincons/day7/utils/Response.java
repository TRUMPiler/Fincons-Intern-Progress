package com.fincons.day7.utils;

import java.time.LocalDateTime;

public class Response<T> {
    private LocalDateTime time;
    private String message;
    private int statusCode;
    private T data;

    public Response(LocalDateTime time, String message, int statusCode, T data) {
        this.time = time;
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
