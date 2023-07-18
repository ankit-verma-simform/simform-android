package com.example.androiddemoproject.javapractice;

import androidx.annotation.NonNull;

abstract class Vehicle {
    String model;
    String color;
    FuelType fuelType;

    enum  FuelType {
        petrol, diesel
    }

    abstract void startEngine();

    @NonNull
    @Override
    final public String toString() {
        return color + " " + model + " runs on " + fuelType;
    }
}

class BMW extends Vehicle {
    BMW(String model, String color, FuelType fuelType) {
        this.model = model;
        this.color = color;
        this.fuelType = fuelType;
    }

    @Override
    void startEngine() {
        System.out.println(this + " starts engine");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        BMW bmw = new BMW("bmw", "red", Vehicle.FuelType.diesel);
        bmw.startEngine();
    }
}
