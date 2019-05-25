package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fw = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();
        String data = "";
        while (fr.ready()){
            data += fr.readLine()+" ";
        }
        fr.close();
        data = data.replaceAll("\\.","!");
        fw.write(data);
        fw.close();



    }
}
