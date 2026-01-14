package com.fincons.day4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* @SpringBootApplication annotation contains
* @ComponentScan
* @EnableAutoConfiguration
* @Configuration
 */
@SpringBootApplication
public class Day4Application {

    public static void main(String[] args) {
        SpringApplication.run(Day4Application.class, args); //method to start springboot application
    }

}
