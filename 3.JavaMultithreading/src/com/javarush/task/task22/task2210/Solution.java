package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
//        System.out.println(getTokens("sdfgsdf asdfg", " ")[0]);
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] x = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens()) {
            x[i] = st.nextToken();
            i++;
        }
        return x;
    }
}
