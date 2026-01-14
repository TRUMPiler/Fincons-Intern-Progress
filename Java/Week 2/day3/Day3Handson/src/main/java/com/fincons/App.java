package com.fincons;

import com.fincons.car.Car;

public class App 
{
    public static void main( String[] args )
    {
       // Even though we are creating a "Sedan", it will have a "V8 Engine"
       // because the Engine is hardcoded in the Car's constructor.
       Car sedan = new Car(1, "Sedan", "Toyota", "Camry");
       sedan.start();

       System.out.println("\n");

       // If we create another car, it will also have the exact same engine.
       Car sportsCar = new Car(2, "Sports", "Porsche", "911");
       sportsCar.start();
    }
}
