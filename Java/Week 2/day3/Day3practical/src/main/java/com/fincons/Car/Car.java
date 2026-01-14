package com.fincons.Car;

import com.fincons.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * USE CASE: To represent a complex object that depends on other components (like an Engine).
 * This class should not be responsible for creating its own dependencies. Instead, it should
 * receive them from an external source (the Spring container).
 *
 * HOW THE CODE SATISFIES IT:
 * 1. @Component: Just like the Engine, this annotation marks the Car class as a Spring Bean,
 *    allowing the Spring container to manage its lifecycle.
 * 2. @Autowired on the 'engine' field: This is the core of the dependency injection.
 *    - It tells Spring to automatically find a bean of type 'Engine' in its application context.
 *    - Spring then "injects" or "autowires" that single Engine instance into this 'engine' field.
 *    - This completely removes the need for `new Engine()` inside the Car class, decoupling the
 *      two components. The Car class no longer needs to know how to create an Engine.
 */
@Component
public class Car {
    private int id;
    private String carName, brandName, carType;



    /**
     * The @Autowired annotation on this field instructs Spring to inject an instance
     * of the Engine bean. This is known as "field injection".
     */
    @Autowired
    private Engine engine;

    // Standard getters and setters for the Car's properties.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * This getter allows us to access the injected Engine instance.
     * @return The Engine bean instance that was autowired by Spring.
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * This setter allows for optionally overriding the injected Engine instance.
     * @param engine A new Engine object.
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
