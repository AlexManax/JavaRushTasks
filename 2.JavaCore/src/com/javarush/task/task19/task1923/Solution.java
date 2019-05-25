package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String data = "";
        while (reader.ready()){
            data += reader.readLine()+" ";
        }
//        System.out.println(data);
        Pattern pattern = Pattern.compile("\\b[\\S]*[\\d]+[\\S]*\\b"); //(\b\w+\d+(\w+)?(\d+)?\b)|(\b(\w+)?(\d+)?\d+\w+\b)
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()){
            writer.write(matcher.group()+" ");
            System.out.println(matcher.group());
        }

        reader.close();
        writer.close();
    }
}
