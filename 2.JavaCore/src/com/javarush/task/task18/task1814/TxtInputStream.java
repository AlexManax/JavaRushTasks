package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        String[] str = fileName.split("/");
        String[] str2 = str[str.length - 1].split("\\.");
        if (!str2[str2.length - 1].equals("txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
//        new TxtInputStream("/Users/alexp/Desktop/JavaRushTasks/480P_542K_11398451z.mp4");
    }
}

