package com.fincons;

import com.fincons.Car.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Main entry point for the Spring Boot application.
 */
@SpringBootApplication
public class App {
    public static void main(String[] args)
    {
        // Launch the Spring application and get the application context.
        ApplicationContext context = SpringApplication.run(App.class, args);

        // Retrieve the Car bean managed by Spring.
        Car car = context.getBean(Car.class);

        // Set properties on the Car bean.
        car.setId(1);
        car.setCarName("Mustang");
        car.setBrandName("Ford");
        car.setCarType("Sports Car");

        // Print the car's details, including the engine type from the injected Engine bean.
        System.out.println("Car ID: " + car.getId());
        System.out.println("Car Name: " + car.getCarName());
        System.out.println("Brand Name: " + car.getBrandName());
        System.out.println("Car Type: " + car.getCarType());
        System.out.println("Car's engine type: " + car.getEngine().getEngineType());
    }
}
