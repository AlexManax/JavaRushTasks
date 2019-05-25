package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine(), file2 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        int[] data = new int[fileInputStream.available()];
        for (int i = 0; i < data.length; i++) {
        data[i]=fileInputStream.read();}

        for (int i = data.length-1; i >= 0; i--) {
            fileOutputStream.write(data[i]);
        }
        reader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
