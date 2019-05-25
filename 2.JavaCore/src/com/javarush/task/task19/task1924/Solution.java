package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        String s = "";

        while(fileReader.ready()){
            s=fileReader.readLine();
            for(Map.Entry<Integer,String> pair : map.entrySet())
                s=s.replaceAll("\\b"+pair.getKey()+"\\b",pair.getValue());
            System.out.println(s);
        }





//        while (readF.ready()) {
//            data += readF.readLine() + "\n";
//        }
////        System.out.println(data);
//
//        Pattern pattern = Pattern.compile("\\b[0-9]\\b|\\b1[0-2]\\b");
//        Matcher matcher = pattern.matcher(data);
//        while (matcher.find()){
////            System.out.println(matcher.group());
//            if (map.get(Integer.parseInt(matcher.group()))!=null){
//                data = data.replaceFirst(matcher.group(),map.get(Integer.parseInt(matcher.group())));
//            }
//        }
//        System.out.println(data);




        reader.close();
        fileReader.close();
    }
}
//\\b\\d+\\b