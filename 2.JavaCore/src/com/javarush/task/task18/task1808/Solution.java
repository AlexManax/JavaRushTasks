package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine(), file2 = reader.readLine(), file3 = reader.readLine();
        FileInputStream fileIS = new FileInputStream(file1);
        FileOutputStream fileOS1 = new FileOutputStream(file2);
        FileOutputStream fileOS2 = new FileOutputStream(file3);
        int x = fileIS.available();
        if (x%2!=0) {
            for (int i = 0; i < (x+1)/2; i++) {
                fileOS1.write(fileIS.read());
            }
            for (int i = 0; i < (x+1)/2-1; i++) {
                fileOS2.write(fileIS.read());
            }
        } else {
            for (int i = 0; i < x/2; i++) {
                fileOS1.write(fileIS.read());
            }
            for (int i = 0; i < x/2; i++) {
                fileOS2.write(fileIS.read());
            }
        }

        fileIS.close();
        fileOS1.close();
        fileOS2.close();
    }
}
