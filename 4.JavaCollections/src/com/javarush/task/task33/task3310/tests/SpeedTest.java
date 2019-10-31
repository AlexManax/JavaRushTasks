//package com.javarush.task.task33.task3310.tests;
//
//import com.javarush.task.task33.task3310.Helper;
//import com.javarush.task.task33.task3310.Shortener;
//import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
//import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//import static com.javarush.task.task33.task3310.Solution.getIds;
//import static com.javarush.task.task33.task3310.Solution.getStrings;
//
//
//public class SpeedTest {
//
//    @Test
//    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
//        Date start = new Date();
//        ids = getIds(shortener, strings);
//        Date stop = new Date();
//        return stop.getTime() - start.getTime();
//    }
//    @Test
//    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
//        Date start = new Date();
//        strings = getStrings(shortener, ids);
//        Date stop = new Date();
//        return stop.getTime() - start.getTime();
//    }
//
//    @Test
//    public void testHashMapStorage(){
//        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
//        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
//        long a, b;
//        Set<String> origStrings = new HashSet<>();
//
//        for (int i = 0; i < 10000; i++) {
//            origStrings.add(Helper.generateRandomString());
//        }
//        a=getTimeToGetIds(shortener1, origStrings, new HashSet<>());
//        b=getTimeToGetIds(shortener2, origStrings, new HashSet<>());
//
//        assertNotEquals(a, b);
//
//        a=getTimeToGetStrings(shortener1, new HashSet<>(), origStrings);
//        b=getTimeToGetStrings(shortener2, new HashSet<>(), origStrings);
//
//        assertEquals(a, b, 30);
//
//    }
//}
