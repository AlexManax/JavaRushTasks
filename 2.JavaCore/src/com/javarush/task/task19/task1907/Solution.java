package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());
        String word = "word";
        reader.close();
        String data = "";
        while (fr.ready()) {
            data += (char) fr.read();
        }
        fr.close();
        data = data.replaceAll("\\p{Punct}", "").replaceAll("\n", " ");
        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher matcher = pattern.matcher(data);


        int count = 0;

        while (matcher.find()) {
//            data.replaceFirst("\\bworld\\b", "");
            count++;
        }
//        System.out.println(data);
        System.out.println(count);

    }
}

