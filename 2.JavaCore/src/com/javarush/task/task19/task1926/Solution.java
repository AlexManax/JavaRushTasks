package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(consoleReader.readLine()));
        String data = "", dataInverse = "";
        while (reader.ready()){
            data = reader.readLine();
            for (int i = data.length()-1; i >= 0; i--) {
                dataInverse = dataInverse + data.charAt(i);
            }
            dataInverse += "\n";
        }
        System.out.println(dataInverse);
        consoleReader.close();
        reader.close();
    }
}
