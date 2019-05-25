package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
//        args[0]="/Users/alexp/Desktop/JavaRushTasks/file2.txt"; //todo
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        int count=0;
        for (byte x:bytes) {
            if (x == 32) {
                count++;

            }
        }
        double z = 1.00*count/bytes.length*100;
        fileInputStream.close();

        System.out.println(String.format("%.2f", z));
    }
}
