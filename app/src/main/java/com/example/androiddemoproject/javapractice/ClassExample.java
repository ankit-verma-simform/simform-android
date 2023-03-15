package com.example.androiddemoproject.javapractice;

/**
 * {@link ClassExample} is an example class to demonstrate various java concepts
 * related to Class
 */
public class ClassExample {
    // types in java are initialized with default value at initialization
    int intValue; // defaults to 0
    String stringValue; // defaults to null
    double decimalValue = 3.14159; // defaults to 0.0 if 3.14159 was not given

    class InnerClass {
        boolean isTrue; // default to false
        String label;

        // constructor is defined by Classname with parameters in parenthesis
        InnerClass(String label) {
            this.label = label; // use of this to refer to current object
            System.out.println("inner class: " + label + " created!"); // string concatenation with '+'
        }

//        static void innerClassStaticMethod() {
//            System.out.println("need to make inner class static to have static methods");
//        }
    }

    // in java, classes are provided with default constructor if no constructor is defined
    //    ClassExample() {
    //        System.out.println("Class example object created!");
    //    }

    /** @return {@link InnerClass} */
    InnerClass returnInnerClassObject() {
        return new InnerClass("method"); // new keyword creates an object!
    }

    // class can have nested classes as member variables
    InnerClass innerClass = new InnerClass("class");

    public static void main(String[] args) {
        // different ways to create class obj

        ClassExample example = new ClassExample(); // #1 use new to create obj
        System.out.println(example.intValue);
        System.out.println(example.stringValue);
        System.out.println(example.decimalValue);
        System.out.println(example.returnInnerClassObject().isTrue);

        try {
            ClassExample example2 = (ClassExample) Class
                    .forName("com.example.androiddemoproject.javapractice.ClassExample")
                    .newInstance(); // #2 using Class.forName().newInstance()
            System.out.println(example2 + " created!");
        } catch (Exception e) {
            System.out.println("Unable to create instance!");
        }

        try {
            ClassExample example3 = (ClassExample) example.clone();
            System.out.println(example3 + " created!"); // #3 using clone
        } catch (CloneNotSupportedException e) {
            System.out.println("Class can't be cloned!");
        }
    }
}

