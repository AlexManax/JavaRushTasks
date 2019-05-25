package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;

        while (true) {
            str = reader.readLine();
            try {
                FileInputStream fis = new FileInputStream(str);
                fis.close();
            } catch (FileNotFoundException e) {
                System.out.println(str);
                break;
            }
        }
    }
}
