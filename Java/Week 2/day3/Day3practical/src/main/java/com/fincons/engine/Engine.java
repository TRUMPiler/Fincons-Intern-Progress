package com.fincons.engine;

import org.springframework.stereotype.Component;

/**

 * The @Component annotation marks this class as a "Spring Bean". This tells the Spring
 * Inversion of Control (IoC) container to automatically create an instance of this class
 * (a "bean")
 */
@Component
public class Engine {
    private int id;
    private String engineType;

    /**
     * A default constructor is necessary for Spring to be able to instantiate the bean
     * when using component scanning. We can set default values here.
     */
    public Engine() {
        this.engineType = "Default V8"; // A default value for the engine type.
    }

    // Standard getters and setters to allow access and modification of the bean's properties.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
