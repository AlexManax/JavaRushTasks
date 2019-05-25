package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String data = "";
        while (reader.ready()) {
            data += reader.readLine() + " ";
        }
        String[] dataArr = data.replaceAll("\\s+", " ").trim().split(" ");
        data = "";
        for (int i = 0; i < dataArr.length; i++) {
//            System.out.println(dataArr[i]);
            if (dataArr[i].length() > 6) data += dataArr[i] + ",";
        }
        if (data.length()>1) data = data.substring(0,data.length()-1);

        writer.write(data);
//        System.out.println(data);

        reader.close();
        writer.close();
    }
}
