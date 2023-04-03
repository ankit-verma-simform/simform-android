package com.example.androiddemoproject.revision.misc;

public class DefaultInterfaceMethodsExample {
    public static void main(String[] args) {
        new Implementer().print();
    }
}

interface InterfaceA {
    int a = 100;
    default void print() {
        System.out.println("Hi from interface A!");
    }
}

interface InterfaceB {
    default void print() {
        System.out.println("Hi from interface B!");
    }
}

class Implementer implements InterfaceA, InterfaceB {

    @Override
    public void print() {
        InterfaceA.super.print();
        InterfaceB.super.print();
    }
}
