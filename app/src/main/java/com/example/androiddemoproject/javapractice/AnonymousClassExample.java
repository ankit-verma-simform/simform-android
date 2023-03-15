package com.example.androiddemoproject.javapractice;

/**
 * {@link AnonymousClassExample} demonstrates Anonymous Inner Class when we only need one object
 * for given class or that implements the interface!
 */
public class AnonymousClassExample {
    static class Shape {
        void draw() {
            System.out.println("drawing shape!");
        }
    }

    interface Paintable {
        void paint();
    }

    public static void main(String[] args) {
        // this will create an anonymous subclass of class Shape for 1 time use
         Shape square = new Shape() {
             @Override
             void draw() {
                 System.out.println("drawing square!");
             }
         };

         square.draw();

         // usually we need to implement interface in a class and then only objects are created
         // as we need only 1 instance of that implementation, we can do it using anonymous class
         Paintable circlePainting = new Paintable() {
             @Override
             public void paint() {
                 System.out.println("painting a circle!");
             }
         };
         circlePainting.paint();

         // we can write it in shorthand using lambda notation
        Paintable rectanglePainting = () -> System.out.println("painting a rectangle!");
        rectanglePainting.paint();
    }
}
