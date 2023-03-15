package com.example.androiddemoproject.javapractice;

public class DecisionsExample {
    public static void main(String[] args) {
        String keyPass = "some secret key right here ...";
        if (keyPass.contains("key")) {
            System.out.println("Key pass contains `key`");
        } else if (keyPass.startsWith("secret")) {
            System.out.println("Key pass starts with `secret`");
        } else {
            System.out.println("Failed cases!");
        }

        String day = "Sunday";
        // can use char, byte, short, int, Character, Byte, Short, Integer, String, or an enum
        switch (day) {
            case "Sunday":
                System.out.println("Holiday!");
                // need break to exit switch
            case "Monday":
                System.out.println("Do work!");
            default: // default is optional!
                // some default statements
        }
    }
}
