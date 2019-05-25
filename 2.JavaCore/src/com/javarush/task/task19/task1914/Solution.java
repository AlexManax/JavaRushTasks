package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream bA = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bA);
        System.setOut(ps);

        testString.printSomething();

        System.setOut(console);
        String[] x = bA.toString().split(" ");
        System.out.print((x[0]+" "+x[1]+ " " + x[2] + " " + x[3]+ " ") + (x[1].equals("+") ? Integer.parseInt(x[0])+Integer.parseInt(x[2]) : x[1].equals("-") ?  Integer.parseInt(x[0])-Integer.parseInt(x[2]) : Integer.parseInt(x[0])*Integer.parseInt(x[2])));

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

