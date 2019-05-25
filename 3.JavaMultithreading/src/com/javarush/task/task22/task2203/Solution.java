package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        if ((!string.contains("\t"))) throw new TooShortStringException();
        if (!string.replaceFirst("\t","").contains("\t")) throw new TooShortStringException();
        try {
            string = string + " ";
            String[] strArr = string.split("\t");
            return strArr[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("dbsdbdsbfsb\tbdsbsdbdsfbs\tdbsdfnsfgnsfgns"));
    }
}
