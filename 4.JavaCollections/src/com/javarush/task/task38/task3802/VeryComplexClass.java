//package com.javarush.task.task38.task3802;
//
///*
//Проверяемые исключения (checked exception)
//*/
//
//import com.google.common.io.Files;
//
//import java.io.File;
//import java.nio.charset.Charset;
//
//public class VeryComplexClass {
//    public void veryComplexMethod() throws Exception {
//        Files.readLines(new File(""), Charset.defaultCharset());
//    }
//
//    public static void main(String[] args) {
//        try {
//            new VeryComplexClass().veryComplexMethod();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
