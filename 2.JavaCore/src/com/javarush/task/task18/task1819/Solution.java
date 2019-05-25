package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine(); //todo
        String f2 = reader.readLine();
        reader.close();


        FileInputStream fis1 = new FileInputStream(f1);
        FileInputStream fis2 = new FileInputStream(f2);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        while (fis2.available() > 0) baos.write(fis2.read());
        while (fis1.available() > 0) baos.write(fis1.read());

        fis1.close();
        fis2.close();

        FileOutputStream fos = new FileOutputStream(f1);
        fos.write(baos.toByteArray());

        fis1.close();
        fis2.close();
        baos.close();
        fos.close();
    }
}
