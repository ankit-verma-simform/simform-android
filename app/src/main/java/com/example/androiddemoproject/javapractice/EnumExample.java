package com.example.androiddemoproject.javapractice;

public class EnumExample {

    enum Direction {
        NORTH, EAST, SOUTH, WEST;

        Direction getNorth() {
            return Direction.NORTH;
        }
    }

    public static void main(String[] args) {
        Direction dir1 = Direction.EAST;
        Direction dir2 = Direction.EAST;
//        Direction dir3 = new Direction(); // can't instantiate an enum

        System.out.println(dir1.hashCode());
        System.out.println(dir2.hashCode());

        Direction dir3 = Direction.valueOf("SOUTH");

        // printing all directions
        System.out.print("All directions: ");
        for (Direction dir: Direction.values()) {
            System.out.print(dir + " ");
        }
        System.out.println();

        System.out.println("Ordinal value of East is " + dir1.ordinal());
    }
}
