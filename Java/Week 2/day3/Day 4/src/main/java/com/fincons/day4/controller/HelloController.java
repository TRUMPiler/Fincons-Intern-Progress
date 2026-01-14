package com.fincons.day4.controller;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/")
    private String helloWorld()
    {
        return "Hello World";
    }
}
