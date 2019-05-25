package com.javarush.task.task39.task3913.logsObj;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.Status;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Log {
    public String ip;
    public String user;
    public Date date;
    public Event event;
    private int taskNuber = 0;
    public Status status;

    public Log() {
        this.taskNuber = 0;
    }

    public Log(String logLine)  {
        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(logLine.split("\\t")));

        this.ip = arrayList.get(0);
        this.user = arrayList.get(1);
        try {
            this.date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(arrayList.get(2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.event = Event.valueOf(arrayList.get(3).split(" ")[0]);
        if (this.event == Event.SOLVE_TASK|| this.event == Event.DONE_TASK)
        taskNuber = Integer.parseInt(arrayList.get(3).split(" ")[1]);
        this.status = Status.valueOf(arrayList.get(4));
    }

    public String getIp() {
        return ip;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public int getTaskNuber() {
        return taskNuber;
    }

    public Status getStatus() {
        return status;
    }
}
