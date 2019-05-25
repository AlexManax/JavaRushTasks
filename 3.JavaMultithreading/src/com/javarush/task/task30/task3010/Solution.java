package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        int number = -1;
        for (int i = 2; i < 37; i++) {
            try {
                new BigInteger(args[0] , i );
                if (number == -1) number = i;
            } catch (Exception e) {
            }

        }
if (number==-1) System.out.println("incorrect");
else System.out.println(number);
    }
}