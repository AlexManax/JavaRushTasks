package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

import static com.javarush.task.task38.task3804.ExceptionFactory.getException;

public class Solution {
    public static Class getFactoryClass() {

//        System.out.println(getException(DatabaseExceptionMessage.NO_RESULT_DUE_TO_TIMEOUT).getMessage());

        return ExceptionFactory.class;
    }

    public static void main(String[] args) {
//        System.out.println(getFactoryClass());
    }
}