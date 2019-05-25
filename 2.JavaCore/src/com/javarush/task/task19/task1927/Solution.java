package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        ByteArrayOutputStream BAOS = new ByteArrayOutputStream();
        ByteArrayOutputStream BAOS2 = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(BAOS);
        System.setOut(ps);
        testString.printSomething();
        System.setOut(console);
        byte[] x = ("JavaRush - курсы Java онлайн").getBytes();
        int z = 0;

        for (int i = 0; i < BAOS.toString().length(); i++) {

            BAOS2.write(BAOS.toByteArray()[i]);
            if (BAOS.toString().charAt(i) == 10) {
                ++z;
                if (z == 2) {
                    BAOS2.write(("JavaRush - курсы Java онлайн").getBytes());
                    BAOS2.write(10);
                    z = 0;
                }
            }
        }
        System.out.println(BAOS2);
        BAOS.close();
        BAOS2.close();
        ps.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
