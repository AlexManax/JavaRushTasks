package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fw = new BufferedWriter(new FileWriter(reader.readLine()));
//        fr.lines().forEach(Integer::parseInt);
        reader.close();
        String data = "";
        while (fr.ready()){
            data += fr.readLine()+" ";
        }
        fr.close();
//        System.out.println(data);
        String str = "";
        Pattern pattern = Pattern.compile("(\\G|\\s)\\d+\\s");
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()) {
            str = str + matcher.group().trim() + " ";
        }
        fw.write(str);
        fw.close();
    }
}
