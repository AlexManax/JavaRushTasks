package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        String[] str;
        String x = "";

        while (fis.available() > 0) {
            x += String.valueOf((char) fis.read());
        }
        str = x.split(" ");


        for (int i = 0; i < str.length; i++) {
            fos.write((Math.round(Double.parseDouble(str[i]))+" ").getBytes()); }
        fos.close();
        fis.close();
    }
}
