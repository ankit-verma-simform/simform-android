package com.example.androiddemoproject.javapractice;

class Animal {
    void eat() {
        System.out.println("Animal eating food");
    }
}

class Cow extends Animal {
    @Override
    void eat() {
        System.out.println("Cow eating grass");
    }
}

class Lion extends Animal {
    @Override
    void eat() {
        System.out.println("Lion eating meat");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal cow = new Cow();
        cow.eat();
        Animal[] animals = { new Cow(), new Lion() };
        for (Animal animal: animals) {
            animal.eat();
        }
    }
}
