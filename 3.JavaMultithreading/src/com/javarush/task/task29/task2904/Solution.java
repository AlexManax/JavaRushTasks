package com.javarush.task.task29.task2904;

import java.lang.reflect.Array;
import java.util.*;

/*
Особенности автобоксинга
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(twoStrings("hackerrankcommunity", "cdecdecdecde"));
    }


    static String twoStrings(String s1, String s2) {
        HashSet treeSet = new HashSet(Collections.singletonList(s1));
treeSet.
        for (int i = 0; i < treeSet.size(); i++) {
            if (s2.contains(treeSet.)) {
                return "YES";
            }
        }
        return "NO";
    }

}
