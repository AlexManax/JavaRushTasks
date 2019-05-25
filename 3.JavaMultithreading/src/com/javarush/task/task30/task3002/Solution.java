package com.javarush.task.task30.task3002;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/*
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        File folder = new File("/Users/alexp/Desktop/JavaRushTasks");
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            System.out.println(file.toPath());
        }
    }
}
