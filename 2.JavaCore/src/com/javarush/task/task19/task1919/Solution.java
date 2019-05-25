package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> treeMap = new TreeMap<>();
        String[] tmp = new String[1];
        while (reader.ready()){
            tmp = reader.readLine().split(" ");
            if (treeMap.containsKey(tmp[0])){
                treeMap.replace(tmp[0],treeMap.get(tmp[0])+Double.parseDouble(tmp[1]));
            } else {
                treeMap.put(tmp[0],Double.parseDouble(tmp[1]));
            }
        }
        reader.close();
        for (HashMap.Entry pair:treeMap.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
