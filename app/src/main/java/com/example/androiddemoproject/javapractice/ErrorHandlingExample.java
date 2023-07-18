package com.example.androiddemoproject.javapractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ErrorHandlingExample {

    static class NullClass {
        String noName;
    }

    static void throwFileNotFoundException() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("no-such-file.txt");
    }

    static void throwDivisionBy0Exception() {
        int dividedBy0 = 50 / 0;
    }

    static void throwsNPE() throws NullPointerException {
        NullClass nullClass = null;
        nullClass.noName = "some new name";
    }

    static void throwOutOfMemoryError() throws OutOfMemoryError {
        throw new OutOfMemoryError();
    }

    public static void main(String[] args) {

        try {
            throwDivisionBy0Exception();
            throwFileNotFoundException();
        }
        // catch arithmetic exception such as division by 0
        catch (ArithmeticException ae) {
            ae.printStackTrace();
        }
        // as throwDivisionBy0Exception() throws ArithmeticException,
        // throwFileNotFoundException() is not called and so FileNotFoundException
        // won't be thrown
        catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }
        // catching any exception
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            // this will always run!
            System.out.println("use finally block to free up resources, or do clean ups!");
        }

        // nested try practice
        try {
            try {
                throw new ArrayIndexOutOfBoundsException(15);
            } catch (ArithmeticException ae) {
                System.out.println("some arithmetic operation exception occurred!");
            } finally {
                System.out.println("Inner finally!");
            }
        } catch (Exception e) {
            // we will catch array of index exception here!
            System.out.println("Some Error occurred! " + e.getLocalizedMessage());
        } finally {
            System.out.println("Outer finally!");
        }

        try {
            throw new MyCustomException("My custom error!");
        } catch (MyCustomException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    static class MyCustomException extends Exception {
        MyCustomException(String message) {
            super(message);
        }
    }
}
