package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
        randomAccessFile.seek(Long.parseLong(args[1]));
        byte[] bytes = new byte[args[2].getBytes().length];
        randomAccessFile.read(bytes, 0, bytes.length);
        randomAccessFile.seek(randomAccessFile.length());
        if (new String(bytes).equals(args[2])) {
            randomAccessFile.write("true".getBytes());
        } else {
            randomAccessFile.write("false".getBytes());
        }
        randomAccessFile.close();

    }
}
