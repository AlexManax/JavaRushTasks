package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        byte[] input = new byte[fis.available()];
        fis.read(input);
        Arrays.sort(input);
        fis.close();


//        for (int i = 0; i < input.length; i++) {
//            System.out.print(input[i] + " ");
//        }
//        System.out.println();

        int count = 1;
        for (int i = 0; i < input.length-1; i++) {
            if (input[i] == input[i+1]) {
                count++;
//                System.out.println(count);
            } else {
                System.out.println((char) input[i] + " " + count);
                count=1;
            }
        }
        try {
            System.out.println((char) input[input.length - 1] + " " + count);
        }catch (ArrayIndexOutOfBoundsException e){}
    }
}
