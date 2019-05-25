package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileIS = new FileInputStream(file);
        int x=0;
        while (fileIS.available()>0){

            if (fileIS.read()==44)  x++;
        }
        fileIS.close();
        System.out.println(x);
    }
}
