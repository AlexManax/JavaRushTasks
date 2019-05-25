package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import com.google.common.io.Files;

import java.io.IOException;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Exception e = (Exception) new Object();
    }

    public void methodThrowsNullPointerException() throws IOException {
        Files.readLines(null,null);
    }

    public static void main(String[] args) {

    }
}
