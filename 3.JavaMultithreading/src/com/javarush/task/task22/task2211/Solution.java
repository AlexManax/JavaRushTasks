package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream reader = new FileInputStream(args[0]);
        FileOutputStream writer = new FileOutputStream(args[1]);

        Charset UTF8 = Charset.forName("UTF-8");
        Charset Win1251 = Charset.forName("Windows-1251");
        String tmp = "";
        byte[] buffer = new byte[1000];
        while (reader.available()>0) {
            reader.read(buffer);
            tmp = new String(buffer,Win1251);
            writer.write(tmp.getBytes(UTF8));
        }
        reader.close();
        writer.close();
    }
}
