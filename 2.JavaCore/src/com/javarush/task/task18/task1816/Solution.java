package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        byte[] bytes = new byte[inputStream.available()];
        int count = inputStream.read(bytes);
        inputStream.close();
        int counter = 0;
        for (byte a : bytes) {
            if ((a >= 65 && a <= 90) || (a >= 97 && a <= 122)) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}