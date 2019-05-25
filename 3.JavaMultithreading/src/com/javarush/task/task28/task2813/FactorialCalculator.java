package com.javarush.task.task28.task2813;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable {
    private final int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public BigInteger call() throws InterruptedException {
        return factorial(number);
    }

    public BigInteger factorial(int number) throws InterruptedException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        BigInteger result = new BigInteger("1");
        while (number > 1) {
//            Thread.sleep(0);
            result = result.multiply(BigInteger.valueOf(number));
            number--;
        }
        return result;
    }
}
