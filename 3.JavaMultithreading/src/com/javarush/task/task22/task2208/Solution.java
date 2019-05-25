package com.javarush.task.task22.task2208;

import java.util.*;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> xxx = new HashMap<>();
        xxx.put(null, null);
        xxx.put(null, "aa");
//        xxx.put("x", "xxx");
//        xxx.put("x2", null);
//        xxx.put("x3", null);

        System.out.println(getQuery(xxx));
    }

    public static String getQuery(Map<String, String> params) {
        if (params == null) return "";
        Map<String, String> parameters = params;
        ArrayList<String> alist = new ArrayList<>();
        params.remove(null);
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() == null) {
                alist.add(pair.getKey());
            }
        }
        for (String x:alist) {
            parameters.remove(x);
        }
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> pair : parameters.entrySet()) {
            result.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");
        }
        if (result.toString().equals("")) return "";
        result.delete(result.lastIndexOf(" and "),result.capacity());

        return result.toString();
    }
}
