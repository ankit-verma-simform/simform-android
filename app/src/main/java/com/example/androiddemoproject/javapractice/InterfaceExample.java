package com.example.androiddemoproject.javapractice;


import androidx.annotation.NonNull;

import java.util.Arrays;

abstract class Fish {
    final String name;
    String[] funFacts;

    protected Fish(String name) {
        this.name = name;
    }

    void swim() {
        System.out.println(this + " is swimming!");
    }

    @NonNull
    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                (funFacts == null ? "" : ", funFacts=" + Arrays.toString(funFacts)) +
                '}';
    }

    static void whois() {
        System.out.println("I'm a fish");
    }
}

class Shark extends Fish {
    Shark(String name) {
        super(name);
        funFacts = new String[]{"Sharks are very good at adapting environments"};
    }
}

interface Flyable {
    void fly();

    // can write static methods in interface
    static boolean canFly() {
        return true;
    }
}

class FlyingFish extends Fish implements Flyable, Student {
    FlyingFish(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(this + " is flying!");
    }

    @Override
    public void study() {
        System.out.println("This fish can study");
    }
}

interface Student {
    int luckyNumber = 100;
    void study();
}

public class InterfaceExample {

    public static void main(String[] args) {
        Fish shark = new Shark("leo");
        shark.swim();

        FlyingFish flyingFish = new FlyingFish("neo");
        flyingFish.fly();

        Fish.whois();
        System.out.println("Can fish fly? " + Flyable.canFly());

        System.out.println(flyingFish.luckyNumber);
    }
}
