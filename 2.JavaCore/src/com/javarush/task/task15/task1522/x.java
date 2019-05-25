package com.javarush.task.task15.task1522;

public class x {
    private static x ourInstance = new x();

    public static x getInstance() {
        return ourInstance;
    }

    private x() {
    }
}
