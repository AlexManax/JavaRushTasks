package com.javarush.task.task36.task3602;

import com.google.common.reflect.ClassPath;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws ClassNotFoundException {

        Class[] clazz = Collections.class.getDeclaredClasses();

        for (Class clazz1 : clazz) {
//            System.out.println(Arrays.asList(clazz1.getGenericInterfaces()));
            if (clazz1.getSimpleName().equals("EmptyList")) return clazz1;
        }
        return null;
    }
}
