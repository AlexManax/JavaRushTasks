package com.javarush.task.task39.task3913.logsObj;

import java.util.ArrayList;
import java.util.List;

public class LogsToArray {

    private List<Log> arrayLogs = new ArrayList<>();

    public void addLog (String logString){
        arrayLogs.add(new Log(logString));
    }

    public List<Log> getArrayLogs() {
        return arrayLogs;
    }
}
