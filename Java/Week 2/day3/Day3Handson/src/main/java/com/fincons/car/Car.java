package com.fincons.car;

import com.fincons.engine.Engine;

public class Car {
    private int id;
    private String type;
    private String brand;
    private String model;
    private Engine engine;

    public Car(int id, String type, String brand, String model) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.model = model;


        // The Car is making its own Engine. This is called "tight coupling".
        // Think of it like this: if you want to change the engine, you have to
        // open up the car's hood and mess with its wiring.

        // For instance, a sports car needs a powerful V10 engine, but a family sedan
        // is better off with a more economical V6. With the current setup, every
        // car gets the same V8 engine, because it's hardcoded right here.

        // This also makes testing difficult, and we can't test the Car on its own
        // without also starting up a real Engine. It's like trying to test a light switch
        // without being able to use a dummy bulb.


        this.engine = new Engine(1, "V8 Engine");
    }

    public void start()
    {
        System.out.println("Starting Car: " + brand + " " + model);
        engine.start();
        System.out.println("Car started.");
    }
}
