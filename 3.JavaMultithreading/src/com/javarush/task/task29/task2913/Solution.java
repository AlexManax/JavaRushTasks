package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {

        if (a > b) {
            String temp = String.valueOf(a);
            for (int i = a-1; i >= b; i--) {
                temp = temp + " " + i;
            }
            return temp;
//            return a + " " + getAllNumbersBetween(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            String temp = String.valueOf(a);
            for (int i = a+1; i <= b; i++) {
                temp = temp + " " + i;
            }
            return temp;


//            return a + " " + getAllNumbersBetween(a + 1, b);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(100);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}