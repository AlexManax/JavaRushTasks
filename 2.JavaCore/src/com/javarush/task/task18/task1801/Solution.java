package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file = "/Users/alexp/Desktop/JavaRushTasks/file1.txt";
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);
        int x = 0, y=0;
        while (fileInputStream.available() > 0) {
            if (x < (y = fileInputStream.read())) { x = y; }
        }
        fileInputStream.close();
        System.out.println(x);
    }
}

