package com.javarush.task.task18.task1805;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine(); //file = "/Users/alexp/Desktop/JavaRushTasks/file1.txt"; //
        FileInputStream fileIS = new FileInputStream(file);
        long[] x = new long[255];
        ArrayList<Integer> y = new ArrayList<>();
        while (fileIS.available()>0){
            x[fileIS.read()] = 1;
        }
        fileIS.close();
        for (int i = 0; i < x.length; i++) {
            if (x[i]==1) {
                 y.add(i);
            }
        }
        Collections.sort(y);
        for (Integer z:y) {
            System.out.print(z+" ");
        }
    }
}
