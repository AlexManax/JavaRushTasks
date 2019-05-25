package com.javarush.task.task38.task3804;

public class ExceptionFactory {

    public static Throwable getException(Enum enumer){
        if (enumer instanceof ApplicationExceptionMessage ){
            return new Exception((Character.toUpperCase(enumer.name().charAt(0))+(enumer.name().substring(1)).replace("_", " ").toLowerCase()));
        } else if (enumer instanceof DatabaseExceptionMessage){
            return new RuntimeException((Character.toUpperCase(enumer.name().charAt(0))+(enumer.name().substring(1)).replace("_", " ").toLowerCase()));
        } else if (enumer instanceof UserExceptionMessage){
            return new Error((Character.toUpperCase(enumer.name().charAt(0))+(enumer.name().substring(1)).replace("_", " ").toLowerCase()));
        } else return new IllegalArgumentException();

    }
}
