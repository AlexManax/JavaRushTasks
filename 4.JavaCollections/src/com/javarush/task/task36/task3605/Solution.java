package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> fileContent = new TreeSet<>();
        String sortedChars;
        try (InputStream fileReader = new FileInputStream(args[0]) {
        }) {
            while (fileReader.available() > 0) {
                fileContent.add(Character.toLowerCase((char) fileReader.read()));
            }
        }
//        fileContent.forEach(System.out::print);
//        System.out.println();

        char[] chars = new char[fileContent.size()];
        int i = 0;
        for (Character x : fileContent) {
            chars[i] = x;
            i++;
        }
        sortedChars = String.valueOf(chars);

        sortedChars = sortedChars.replaceAll("(\\W)*", "");

        try {
            System.out.println(sortedChars.substring(0, 5));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println(sortedChars);
        }
    }
}
