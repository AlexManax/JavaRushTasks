package com.javarush.task.task22.task2212;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if ((telNumber==null)||(telNumber.equals(""))) return false;
        Pattern x = Pattern.compile( "(\\+\\d{12})||(\\(\\d{10})||(\\d{10})||" +
                "(\\+?\\d+-\\d+-?\\d+)||(\\+?\\d+?(\\(\\d\\d\\d\\)?))\\d+-?\\d+-?\\d+" );
        Matcher match = x.matcher(telNumber);
        return match.matches();
    }

    public static void main(String[] args) {
//        ArrayList<String> arr = new ArrayList<>();
//        arr.add("+380501234567");
//        arr.add("+38(050)1234567");
//        arr.add("+38050123-45-67");
//        arr.add("050123-4567");
//        arr.add("+38)050(1234567");
//        arr.add("+38(050)1-23-45-6-7");
//        arr.add("050ххх4567");
//        arr.add("050123456");
//        arr.add("(0)501234567");
//        arr.add(null);
//        for (String x:arr ) {
//            System.out.println(checkTelNumber(x));
//        }
    }
}
