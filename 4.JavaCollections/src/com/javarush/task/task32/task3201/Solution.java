package com.javarush.task.task32.task3201;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(args[0]), "rw");
        if (randomAccessFile.length() < Long.parseLong(args[1]) + args[2].getBytes().length)
            randomAccessFile.seek(randomAccessFile.length());
        else
            randomAccessFile.seek(Long.parseLong(args[1]));
        randomAccessFile.write(args[2].getBytes());
    }
}
