package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        testStrategy(new OurHashBiMapStorageStrategy(), 1000000);
        testStrategy(new OurHashBiMapStorageStrategy(), 1000000);
        testStrategy(new DualHashBidiMapStorageStrategy(), 1000000);
        testStrategy(new HashMapStorageStrategy(), 10000);

 }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> iDs = new HashSet<>();
        for (String string : strings) {
            iDs.add(shortener.getId(string));
        }
        return iDs;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> stringSet = new HashSet<>();
        for (Long iD : keys) {
            stringSet.add(shortener.getString(iD));
        }
//        System.out.println("K : " + keys.size());
//        System.out.println("S : " + stringSet.size());
        return stringSet;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Shortener shortener = new Shortener(strategy);
        Set<String> strings = new HashSet<>();
        Set<Long> iDs = new HashSet<>();
        Set<String> retStrings;
        long proccessTime;

        Helper.printMessage(strategy.getClass().getSimpleName());

        for (long i = 0; i < elementsNumber; i++) {
            String randomString = Helper.generateRandomString();
            strategy.put(i, randomString);
            strings.add(randomString);
            iDs.add(i);
        }

        Date start = new Date();
        getIds(shortener, strings);
        Date stop = new Date();
        Helper.printMessage(String.valueOf(proccessTime = stop.getTime() - start.getTime()));

        Date start2 = new Date();
        retStrings = getStrings(shortener, iDs);
        Date stop2 = new Date();
        Helper.printMessage(String.valueOf((stop2.getTime() - start2.getTime())+proccessTime));

        for (String str:strings) {
            if (!retStrings.contains(str)){
                Helper.printMessage("Тест не пройден.");
                return;
            }
        }
        Helper.printMessage("Тест пройден.");
    }

}


