package com.fincons.day5.hands_on.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is my first REST controller.
 */
@RestController
@RequestMapping("/api")
public class HelloController
{
    /**
     * This is my first GET API, which I've exposed at /api/hello.
     * @return A plain text response.
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
