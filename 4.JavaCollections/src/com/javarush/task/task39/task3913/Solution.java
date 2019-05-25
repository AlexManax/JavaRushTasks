package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("/Users/alexp/Desktop/JavaRushTasks/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs/"));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
//        System.out.println(logParser.getNumberOfAllEvents(null, null));
//        System.out.println(logParser.getIPsForUser("Eduard Petrovich Morozko", null, null));
//        System.out.println(logParser.getIPsForEvent(Event.WRITE_MESSAGE, null, null));
//        System.out.println(logParser.getNumberOfAttemptToSolveTask(18, null, null));
//        System.out.println(logParser.getAllDoneTasksAndTheirNumber(null, null));
//        System.out.println(logParser.execute("get status"));
        System.out.println(logParser.execute("get event for date = \"30.01.2014 12:56:22\""));

//        LogParser logParser2 = new LogParser(Paths.get("/Users/alexp/Desktop/JavaRushTasks/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3913/logs/example.log"));
//        System.out.println(logParser2.getNumberOfUniqueIPs(null, null));
//        System.out.println(logParser2.getDatesWhenSomethingFailed(null, null));
//        System.out.println(logParser2.getIPsForUser("Eduard Petrovich Morozko", null, null));
//        System.out.println(logParser2.getIPsForEvent(Event.WRITE_MESSAGE, null, null));
//        System.out.println(logParser2.getNumberOfAttemptToSolveTask(18, null, null));
//        System.out.println(logParser2.getAllDoneTasksAndTheirNumber(null, null));
    }
}