package com.example.androiddemoproject.javapractice;

class Employee {
    private float salary;

    Employee(float salary) {
        System.out.println("emp created!");
        this.salary = salary;
    }


    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}

class Programmer extends Employee {
    int bonus;

    Programmer(float salary) {
        super(salary);
        this.bonus = 100_000;
        System.out.println("programmer created!");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        final Programmer ankit = new Programmer(150_000);
        System.out.println(ankit.bonus);
    }
}
