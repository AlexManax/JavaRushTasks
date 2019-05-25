package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> x;

    public Generator(Class<T> x) {
        this.x = x;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return x.newInstance();
    }
}
