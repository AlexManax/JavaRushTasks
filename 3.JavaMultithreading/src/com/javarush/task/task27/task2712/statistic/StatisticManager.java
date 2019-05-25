//package com.javarush.task.task27.task2712.statistic;
//
//import com.javarush.task.task27.task2712.kitchen.Cook;
//import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
//import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
//import com.javarush.task.task27.task2712.statistic.event.EventType;
//import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;
//
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class StatisticManager {
//    private StatisticStorage statisticStorage = new StatisticStorage();
//    private Set<Cook> cooks = new HashSet<>();
//
//    private static StatisticManager ourInstance = new StatisticManager();
//
//    public static StatisticManager getInstance() {
//        return ourInstance;
//    }
//
//    private StatisticManager() {
//    }
//
//    public void register(EventDataRow data) {
//        statisticStorage.put(data);
//    }
//
//    public void register(Cook cook){
//        cooks.add(cook);
//    }
//
//    public Map<String, Double> reklama() {
//        Map<String, Double> result = new TreeMap<>(Collections.reverseOrder());
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//        for (EventDataRow video : statisticStorage.getStorage(EventType.SELECTED_VIDEOS)) {
//            VideoSelectedEventDataRow videoRow = (VideoSelectedEventDataRow) video;
//            double allMoney = videoRow.getAmount();
//            String data = sdf.format(videoRow.getDate());
//            if (result.containsKey(data)) {
//                result.put(data, result.get(data) + allMoney / 100.00);
//            }
//            else {
//                result.put(data, allMoney / 100.00);
//            }
//        }
//        return result;
//    }
//
//    public Map<String, Map<String, Integer>> povar() {
//        Map<String, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//        for (EventDataRow event : statisticStorage.getStorage(EventType.COOKED_ORDER)) {
//            CookedOrderEventDataRow cookRow = (CookedOrderEventDataRow) event;
//            String data = sdf.format(cookRow.getDate());
//            String name = cookRow.getCookName();
//            Integer time = (int) Math.ceil(cookRow.getTime() / 60.00);
//            if (time > 0) {
//                if (!result.containsKey(data)) {
//                    Map<String, Integer> inner = new TreeMap<>();
//                    inner.put(name, time);
//                    result.put(data, inner);
//                } else {
//                    Map<String, Integer> inner = result.get(data);
//                    if (!inner.containsKey(name)) {
//                        inner.put(name, time);
//                    } else {
//                        inner.put(name, inner.get(name) + time);
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    private class StatisticStorage {
//        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();
//
//        private StatisticStorage() {
//            for (EventType eventType : EventType.values()) {
//                storage.put(eventType, new ArrayList<EventDataRow>());
//            }
//        }
//
//        private List<EventDataRow> getStorage(EventType type) {
//            return storage.get(type);
//        }
//
//        private void put(EventDataRow data) {
//            storage.get(data.getType()).add(data);
//        }
//    }
//
//
//}
package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();
//    private Set<Cook> cooks = new HashSet<>();

    private StatisticManager() {

    }

    public static StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

//    public Set<Cook> getCooks() {
//        return cooks;
//    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

//    public void register(Cook cook) {
//        cooks.add(cook);
//    }

    public Map<Date, Double> calculateProfit() {
        Map<Date, Double> calc = new TreeMap<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });
        Map<EventType, List<EventDataRow>> strg = statisticStorage.getStorage();
        List<EventDataRow> dataRowList = strg.get(EventType.SELECTED_VIDEOS);
        for (EventDataRow e : dataRowList) {

            Date currentDate = e.getDate();
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            calendar.setTime(currentDate);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            double currentAmount = ((VideoSelectedEventDataRow) e).getAmount() / 100.00;
            if (calc.containsKey(calendar.getTime())) {
                currentAmount += calc.get(calendar.getTime());
            }
            calc.put(calendar.getTime(), currentAmount);
        }
        return calc;
    }

    public Map<Date, TreeMap<String, Integer>> calculateTimeOfWork() {
        Map<Date, TreeMap<String, Integer>> calc = new TreeMap<>(new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                return o2.compareTo(o1);
            }
        });
        Map<EventType, List<EventDataRow>> strg = statisticStorage.getStorage();
        List<EventDataRow> dataRowList = strg.get(EventType.COOKED_ORDER);
        for (EventDataRow e : dataRowList) {

            Date currentDate = e.getDate();
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            calendar.setTime(currentDate);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) e;
            String cookName = cookedOrderEventDataRow.getCookName();


            TreeMap<String, Integer> cookedForThisDay = calc.get(calendar.getTime());
            if (cookedForThisDay == null) {
                cookedForThisDay = new TreeMap<>();
                calc.put(calendar.getTime(), cookedForThisDay);
            }
            Integer timeCooked = cookedForThisDay.get(cookName);
            if (timeCooked == null) {
                timeCooked = e.getTime();
            } else {
                timeCooked += e.getTime();
            }
            cookedForThisDay.put(cookName, timeCooked);
//            System.out.println(timeCooked);

        }
        return calc;

    }


    private static class StatisticStorage {
        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<EventDataRow>());
            }
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

    }
}