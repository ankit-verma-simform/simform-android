package com.example.androiddemoproject.javapractice;

public class OperatorsExample {
    public static void main(String[] args) {
        // arithmetic operators
        System.out.println("Add 1+2=" + (1 + 2));
        System.out.println("Sub 1-2=" + (1 - 2));
        System.out.println("Multiply 1x2=" + (1 * 2));
        System.out.println("Divide 1/2=" + (1 / 2.0));

        // relational operators
        System.out.println("Less than 1<4=" + (1 < 4));
        System.out.println("Greater than 1>4=" + (1 > 4));
        System.out.println("Equal 1==4=" + (1 == 4));
        System.out.println("Not Equal 1!=4=" + (1 != 4));

        // bitwise operators
        System.out.println("bitwise and 5&1=" + (5 & 1));
        System.out.println("bitwise or 5|1=" + (5 | 1));
        System.out.println("bitwise xor 5^1=" + (5 ^ 1));
        System.out.println("bitwise not ~5=" + (~5));
        // ~5 = ~(00000101)base-2 = (11111010)base-2 = -6 (2's complement)

        // printing number in binary
        short five = 5;
        String fiveInBinary = "";
        while (five != 0) {
            fiveInBinary += five & 1;
            five >>= 1;
        }
        System.out.println("5 in binary =" + fiveInBinary);

        // logical operators
        System.out.println("logical and false and true=" + (false && true));
        System.out.println("logical and false or true=" + (false || true));
        System.out.println("logical not true=" + (!true));

        // ternary operator
        boolean isSayingTheTruth = true;
        String judgement = isSayingTheTruth ? "free him" : "lifetime sentence!";
        System.out.println("saying the truth: => judgement = " + judgement);
    }
}
