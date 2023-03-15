package com.example.androiddemoproject.javapractice;

public class NestedClassesExample {
    int anInt = 11;
    static String aString = "some string";

    class normalInnerClass {
        int anotherInt = 7;
//        static boolean isThisTrue = false; // won't compile, can't have static variables in normal inner class

        void normalPrint() {
            // can access its and its parent's member variables & methods
            System.out.println(anInt);
            System.out.println(anotherInt);
            System.out.println(aString);
        }

//        static void someStaticMethod() {
//            // won't compile, can't have static methods in normal inner classes
//        }
    }

    static class staticInnerClass {
        double aDouble = 3.14;

        void normalPrint() {
//            System.out.println(anInt); // can't access instance variable of parent
            System.out.println(aString);
            System.out.println(aDouble);
        }

        static void someStaticMethod() {
            System.out.println("static methods are accessible in static inner classes");
        }
    }

    public static void main(String[] args) {
        staticInnerClass obj = new staticInnerClass();
        System.out.println("aDouble value = " + obj.aDouble);
    }
}
