package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        //Подменяем in на stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        //Вызываем функцию
        testString.printSomething();

        //Собираем строку из перехваченных байтов
        String result = outputStream.toString();

        //Возвращаем in на место
        System.setOut(consoleStream);

        //Обработка строки согласно заданию и вывод на экран
        String total = result.replaceAll("te", "??");
        System.out.print(total);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
