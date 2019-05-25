package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        BufferedReader reader1 = new BufferedReader(new FileReader(file));
        String s;
        while (reader1.ready()){
        if ((s = reader1.readLine()).startsWith(args[0]+" ")) System.out.println(s);}
reader.close();
reader1.close();
    }
}
