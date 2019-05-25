package com.javarush.task.task39.task3908;

import java.util.*;

/*

*/
public class Solution {
    public static void main(String[] args) {
    }

    public static boolean isPalindromePermutation(String s) {
        s = s.toLowerCase();
        HashMap<Character, Integer> hMap = new HashMap<>();
        int counterOdd = 0;
        for (Character ch:s.toCharArray()) {
            if (hMap.containsKey(ch)) hMap.replace(ch,hMap.get(ch)+1);
            else hMap.put(ch,1);
        }
        for (Map.Entry pair:hMap.entrySet()) {
            if ((int) pair.getValue()%2!=0) counterOdd++;
        }
        return counterOdd <= 1;
    }
}
