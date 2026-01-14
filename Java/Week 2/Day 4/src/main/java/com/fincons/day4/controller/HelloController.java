package com.fincons.day4.controller;

import org.springframework.web.bind.annotation.*;
/**
 * @RestController will make HelloController a Rest Api Handler class
 * @RequestMapping will tell springboot to map all request coming to http://localhost:8080/api
 * will be handled by HelloController.
 **/
@RestController
@RequestMapping("/api")
public class HelloController
{

    /**
     * @GetMapping will map the get request from 'localhost:8080/api/' to helloWorld()
     * and this method will returns a string as a response
     **/
    @GetMapping("/")
    private String helloWorld()
    {
        return "Hello World";
    }
}
