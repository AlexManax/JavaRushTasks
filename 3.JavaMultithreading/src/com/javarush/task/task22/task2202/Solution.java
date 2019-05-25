package com.javarush.task.task22.task2202;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string==null) throw new TooShortStringException();
        try {
            string = string + " ";
            String[] str = string.split(" ");
            if (str.length<5) throw new Exception();
            return String.format("%s %s %s %s",str[1], str[2], str[3], str[4] );
        } catch (Exception e){
            throw new TooShortStringException();
        }
//return "";

    }

    public static class TooShortStringException extends RuntimeException {
    }
}
