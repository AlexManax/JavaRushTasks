package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine(); //file = "/Users/alexp/Desktop/JavaRushTasks/file1.txt";//,
        long[] x = new long[255];
        FileInputStream fileIS = new FileInputStream(file);

        while (fileIS.available() > 0) {
            x[fileIS.read()] += 1;
        }
        fileIS.close();
        long y = 0;
        for (int i = 1; i < x.length; i++) {
            if (y < x[i]) y = x[i];
        }

        for (int i = 0; i < x.length; i++) {
            if (x[i] == y) System.out.print(i + " ");
        }

    }
}
