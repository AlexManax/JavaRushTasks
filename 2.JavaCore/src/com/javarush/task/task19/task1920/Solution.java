package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
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
        String[] names = new String[treeMap.size()];
        double max=0.0;
        Object vin = "";
        for (HashMap.Entry pair:treeMap.entrySet()) {
            if (max < (double)pair.getValue()) {max = (double)pair.getValue();
            vin = pair.getKey();}
//            System.out.println(pair.getKey() + " " + pair.getValue());
        }
//        System.out.println(i);
//        for ( i = i-1 ; i >= 0; i--) {
//            System.out.println(vin+""+max);
//        }
        for (HashMap.Entry pair:treeMap.entrySet()) {
            if (pair.getValue().equals(max)) {;
                System.out.println(pair.getKey());}
//            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
