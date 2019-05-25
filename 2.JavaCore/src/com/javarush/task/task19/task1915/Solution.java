package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fos = new FileOutputStream(reader.readLine());
        reader.close();
        PrintStream console = System.out;
        ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
        PrintStream tempPS = new PrintStream(BAOS);
            System.setOut(tempPS);

        testString.printSomething();

            System.setOut(console);

        fos.write(BAOS.toByteArray());
        System.out.println(BAOS.toString());
        fos.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

