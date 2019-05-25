package com.javarush.task.task39.task3913;


import com.javarush.task.task39.task3913.logsObj.Log;
import com.javarush.task.task39.task3913.logsObj.LogsToArray;
import com.javarush.task.task39.task3913.query.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LogParser extends LogsToArray implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {

    private LogsToArray logsToArray = new LogsToArray();

    public LogParser(Path logDir) {
        initArrayReader(logDir);
    }

    public void initArrayReader(Path logDir){
        if (!Files.isDirectory(logDir)) {
            if (logDir.toString().endsWith(".log"))
                try (Stream<String> stream = Files.lines(logDir)) {
                    List<String> logList = stream.collect(Collectors.toList());

                    for (String str : logList) {
                        logsToArray.addLog(str);
                    }

//                    stream.forEach(this.logsToArray::addLog);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        } else {
            File[] files = new File(logDir.toString()).listFiles((dir, name) -> name.endsWith(".log"));
            for (File file : files)
                initArrayReader(file.toPath());
        }
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {

        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    userSet.add(log.getIp());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    userSet.add(log.getIp());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    userSet.add(log.getIp());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                userSet.add(log.getIp());
            }
        }

        return userSet.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> iPsSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    iPsSet.add(log.getIp());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    iPsSet.add(log.getIp());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    iPsSet.add(log.getIp());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                iPsSet.add(log.getIp());
            }
        }

        return iPsSet;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getUser().equals(user))
                        userSet.add(log.getIp());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getUser().equals(user))
                        userSet.add(log.getIp());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getUser().equals(user))
                        userSet.add(log.getIp());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getUser().equals(user))
                    userSet.add(log.getIp());
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getEvent() == event)
                        userSet.add(log.getIp());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getEvent() == event)
                        userSet.add(log.getIp());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getEvent() == event)
                        userSet.add(log.getIp());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getEvent() == event)
                    userSet.add(log.getIp());
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getStatus() == status)
                        userSet.add(log.getIp());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getStatus() == status)
                        userSet.add(log.getIp());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getStatus() == status)
                        userSet.add(log.getIp());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getStatus() == status)
                    userSet.add(log.getIp());
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> userSet = new HashSet<>();
        for (Log log : logsToArray.getArrayLogs()) {
            userSet.add(log.getUser());
        }
        return userSet;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    userSet.add(log.getUser());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    userSet.add(log.getUser());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    userSet.add(log.getUser());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                userSet.add(log.getUser());
            }
        }

        return userSet.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getUser().equals(user))
                        userSet.add(log.getEvent());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getUser().equals(user))
                        userSet.add(log.getEvent());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getUser().equals(user))
                        userSet.add(log.getEvent());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getUser().equals(user))
                    userSet.add(log.getEvent());
            }
        }

        return userSet.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getIp().equals(ip))
                        userSet.add(log.getUser());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getIp().equals(ip))
                        userSet.add(log.getUser());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getIp().equals(ip))
                        userSet.add(log.getUser());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getIp().equals(ip))
                    userSet.add(log.getUser());
            }
        }

        return userSet;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getEvent() == Event.LOGIN)
                        userSet.add(log.getUser());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getEvent() == Event.LOGIN)
                        userSet.add(log.getUser());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getEvent() == Event.LOGIN)
                        userSet.add(log.getUser());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getEvent() == Event.LOGIN)
                    userSet.add(log.getUser());
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getEvent() == Event.DOWNLOAD_PLUGIN)
                        userSet.add(log.getUser());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getEvent() == Event.DOWNLOAD_PLUGIN)
                        userSet.add(log.getUser());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getEvent() == Event.DOWNLOAD_PLUGIN)
                        userSet.add(log.getUser());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getEvent() == Event.DOWNLOAD_PLUGIN)
                    userSet.add(log.getUser());
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getEvent() == Event.WRITE_MESSAGE)
                        userSet.add(log.getUser());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getEvent() == Event.WRITE_MESSAGE)
                        userSet.add(log.getUser());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getEvent() == Event.WRITE_MESSAGE)
                        userSet.add(log.getUser());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getEvent() == Event.WRITE_MESSAGE)
                    userSet.add(log.getUser());
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getEvent() == Event.SOLVE_TASK)
                        userSet.add(log.getUser());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getEvent() == Event.SOLVE_TASK)
                        userSet.add(log.getUser());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getEvent() == Event.SOLVE_TASK)
                        userSet.add(log.getUser());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getEvent() == Event.SOLVE_TASK)
                    userSet.add(log.getUser());
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getEvent() == Event.SOLVE_TASK)
                        if (log.getTaskNuber() == task)
                            userSet.add(log.getUser());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getEvent() == Event.SOLVE_TASK)
                        if (log.getTaskNuber() == task)
                            userSet.add(log.getUser());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getEvent() == Event.SOLVE_TASK)
                        if (log.getTaskNuber() == task)
                            userSet.add(log.getUser());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getEvent() == Event.SOLVE_TASK)
                    if (log.getTaskNuber() == task)
                        userSet.add(log.getUser());
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getEvent() == Event.DONE_TASK)
                        userSet.add(log.getUser());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getEvent() == Event.DONE_TASK)
                        userSet.add(log.getUser());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getEvent() == Event.DONE_TASK)
                        userSet.add(log.getUser());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getEvent() == Event.DONE_TASK)
                    userSet.add(log.getUser());
            }
        }
        return userSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getEvent() == Event.DONE_TASK)
                        if (log.getTaskNuber() == task)
                            userSet.add(log.getUser());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getEvent() == Event.DONE_TASK)
                        if (log.getTaskNuber() == task)
                            userSet.add(log.getUser());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getEvent() == Event.DONE_TASK)
                        if (log.getTaskNuber() == task)
                            userSet.add(log.getUser());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getEvent() == Event.DONE_TASK)
                    if (log.getTaskNuber() == task)
                        userSet.add(log.getUser());
            }
        }
        return userSet;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getUser().equals(user))
                        if (log.getEvent() == event)
                            userSet.add(log.getDate());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getUser().equals(user))
                        if (log.getEvent() == event)
                            userSet.add(log.getDate());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getUser().equals(user))
                        if (log.getEvent() == event)
                            userSet.add(log.getDate());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getUser().equals(user))
                    if (log.getEvent() == event)
                        userSet.add(log.getDate());
            }
        }
        return userSet;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getStatus() == Status.FAILED)
                        userSet.add(log.getDate());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getStatus() == Status.FAILED)
                        userSet.add(log.getDate());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getStatus() == Status.FAILED)
                        userSet.add(log.getDate());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getStatus() == Status.FAILED)
                    userSet.add(log.getDate());
            }
        }
        return userSet;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> userSet = new HashSet<>();

        if (after != null && before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after) && log.getDate().before(before))
                    if (log.getStatus() == Status.ERROR)
                        userSet.add(log.getDate());
            }
        } else if (after != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().after(after))
                    if (log.getStatus() == Status.ERROR)
                        userSet.add(log.getDate());
            }
        } else if (before != null) {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getDate().before(before))
                    if (log.getStatus() == Status.ERROR)
                        userSet.add(log.getDate());
            }
        } else {
            for (Log log : logsToArray.getArrayLogs()) {
                if (log.getStatus() == Status.ERROR)
                    userSet.add(log.getDate());
            }
        }
        return userSet;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        if (after != null && before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before) && r.getEvent() == Event.LOGIN && r.getUser().equals(user))
                    .map(Log::getDate)
                    .sorted()
                    .findFirst()
                    .orElse(null);
        } else if (after != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getEvent() == Event.LOGIN && r.getUser().equals(user))
                    .map(Log::getDate)
                    .sorted()
                    .findFirst()
                    .orElse(null);
        } else if (before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before) && r.getEvent() == Event.LOGIN && r.getUser().equals(user))
                    .map(Log::getDate)
                    .sorted()
                    .findFirst()
                    .orElse(null);
        } else {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getEvent() == Event.LOGIN && r.getUser().equals(user))
                    .map(Log::getDate)
                    .sorted()
                    .findFirst()
                    .orElse(null);
        }
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        if (after != null && before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before) && r.getTaskNuber() == task && r.getUser().equals(user) && r.getEvent() == Event.SOLVE_TASK)
                    .map(Log::getDate)
                    .sorted()
                    .findFirst()
                    .orElse(null);
        } else if (after != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getTaskNuber() == task && r.getUser().equals(user) && r.getEvent() == Event.SOLVE_TASK)
                    .map(Log::getDate)
                    .sorted()
                    .findFirst()
                    .orElse(null);
        } else if (before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before) && r.getTaskNuber() == task && r.getUser().equals(user) && r.getEvent() == Event.SOLVE_TASK)
                    .map(Log::getDate)
                    .sorted()
                    .findFirst()
                    .orElse(null);
        } else {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getTaskNuber() == task && r.getUser().equals(user) && r.getEvent() == Event.SOLVE_TASK)
                    .map(Log::getDate)
                    .sorted()
                    .findFirst()
                    .orElse(null);
        }
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        if (after != null && before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before) && r.getTaskNuber() == task && r.getUser().equals(user) && r.getEvent() == Event.DONE_TASK)
                    .map(Log::getDate)
                    .sorted()
                    .findFirst()
                    .orElse(null);
        } else if (after != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getTaskNuber() == task && r.getUser().equals(user) && r.getEvent() == Event.DONE_TASK)
                    .map(Log::getDate)
                    .sorted()
                    .findFirst()
                    .orElse(null);
        } else if (before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before) && r.getTaskNuber() == task && r.getUser().equals(user) && r.getEvent() == Event.DONE_TASK)
                    .map(Log::getDate)
                    .sorted()
                    .findFirst()
                    .orElse(null);
        } else {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getTaskNuber() == task && r.getUser().equals(user) && r.getEvent() == Event.DONE_TASK)
                    .map(Log::getDate)
                    .sorted()
                    .findFirst()
                    .orElse(null);
        }
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        if (after != null && before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before) && r.getUser().equals(user) && r.getEvent() == Event.WRITE_MESSAGE)
                    .map(Log::getDate)
                    .collect(Collectors.toSet());
        } else if (after != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getUser().equals(user) && r.getEvent() == Event.WRITE_MESSAGE)
                    .map(Log::getDate)
                    .collect(Collectors.toSet());
        } else if (before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before) && r.getUser().equals(user) && r.getEvent() == Event.WRITE_MESSAGE)
                    .map(Log::getDate)
                    .collect(Collectors.toSet());
        } else {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getUser().equals(user) && r.getEvent() == Event.WRITE_MESSAGE)
                    .map(Log::getDate)
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        if (after != null && before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before) && r.getUser().equals(user) && r.getEvent() == Event.DOWNLOAD_PLUGIN)
                    .map(Log::getDate)
                    .collect(Collectors.toSet());
        } else if (after != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getUser().equals(user) && r.getEvent() == Event.DOWNLOAD_PLUGIN)
                    .map(Log::getDate)
                    .collect(Collectors.toSet());
        } else if (before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before) && r.getUser().equals(user) && r.getEvent() == Event.DOWNLOAD_PLUGIN)
                    .map(Log::getDate)
                    .collect(Collectors.toSet());
        } else {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getUser().equals(user) && r.getEvent() == Event.DOWNLOAD_PLUGIN)
                    .map(Log::getDate)
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        if (after != null && before != null) {
            return (int) logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before))
                    .map(Log::getEvent).collect(Collectors.toSet()).size();
        } else if (after != null) {
            return (int) logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after))
                    .map(Log::getEvent).collect(Collectors.toSet()).size();
        } else if (before != null) {
            return (int) logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before))
                    .map(Log::getEvent).collect(Collectors.toSet()).size();
        } else {
            return (int) logsToArray.getArrayLogs().stream()
                    .map(Log::getEvent).collect(Collectors.toSet()).size();        }
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        if (after != null && before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before))
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else if (after != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after))
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else if (before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before))
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else {
            return logsToArray.getArrayLogs().stream()
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        if (after != null && before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before) && r.getIp().equals(ip))
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else if (after != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getIp().equals(ip))
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else if (before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before) && r.getIp().equals(ip))
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getIp().equals(ip))
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        if (after != null && before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before) && r.getUser().equals(user))
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else if (after != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getUser().equals(user))
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else if (before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before) && r.getUser().equals(user))
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getUser().equals(user))
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        if (after != null && before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before) && r.getStatus() == Status.FAILED)
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else if (after != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getStatus() == Status.FAILED)
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else if (before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before) && r.getStatus() == Status.FAILED)
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getStatus() == Status.FAILED)
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        if (after != null && before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before) && r.getStatus() == Status.ERROR)
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else if (after != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getStatus() == Status.ERROR)
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else if (before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before) && r.getStatus() == Status.ERROR)
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        } else {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getStatus() == Status.ERROR)
                    .map(Log::getEvent)
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        if (after != null && before != null) {
            return (int) logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before) &&  r.getEvent() == Event.SOLVE_TASK && r.getTaskNuber() == task)
                    .map(Log::getEvent).count();
        } else if (after != null) {
            return (int) logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getEvent() == Event.SOLVE_TASK && r.getTaskNuber() == task)
                    .map(Log::getEvent).count();
        } else if (before != null) {
            return (int) logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before) && r.getEvent() == Event.SOLVE_TASK && r.getTaskNuber() == task)
                    .map(Log::getEvent).count();
        } else {
            return (int) logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getEvent() == Event.SOLVE_TASK &&  r.getTaskNuber() == task)
                    .map(Log::getEvent).count();
        }
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        if (after != null && before != null) {
            return (int) logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before) && r.getEvent() == Event.DONE_TASK  && r.getTaskNuber() == task)
                    .map(Log::getEvent).count();
        } else if (after != null) {
            return (int) logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getEvent() == Event.DONE_TASK && r.getTaskNuber() == task)
                    .map(Log::getEvent).count();
        } else if (before != null) {
            return (int) logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before) && r.getEvent() == Event.DONE_TASK && r.getTaskNuber() == task)
                    .map(Log::getEvent).count();
        } else {
            return (int) logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getEvent() == Event.DONE_TASK &&  r.getTaskNuber() == task)
                    .map(Log::getEvent).count();
        }
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list;
        if (after != null && before != null) {
            list =
                    logsToArray.getArrayLogs().stream()
                            .filter(r -> r.getDate().after(after) && r.getDate().before(before)  && r.getEvent() == Event.SOLVE_TASK && r.getTaskNuber() >0 )
                            .map(Log::getTaskNuber)
                            .collect(Collectors.toList());
        } else if (after != null) {
            list =
                    logsToArray.getArrayLogs().stream()
                            .filter(r -> r.getDate().after(after) && r.getEvent() == Event.SOLVE_TASK && r.getTaskNuber() >0 )
                            .map(Log::getTaskNuber)
                            .collect(Collectors.toList());
        } else if (before != null) {
            list =
                    logsToArray.getArrayLogs().stream()
                            .filter(r -> r.getDate().before(before) && r.getEvent() == Event.SOLVE_TASK && r.getTaskNuber() >0 )
                            .map(Log::getTaskNuber)
                            .collect(Collectors.toList());
        } else {
            list =
                    logsToArray.getArrayLogs().stream()
                            .filter(r -> r.getEvent() == Event.SOLVE_TASK && r.getTaskNuber() >0 )
                            .map(Log::getTaskNuber)
                            .collect(Collectors.toList());
        }
        for (Integer taskN : list) {
            map.put(taskN, getNumberOfAttemptToSolveTask(taskN, after, before));
        }
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list;
        if (after != null && before != null) {
            list =
                    logsToArray.getArrayLogs().stream()
                            .filter(r -> r.getDate().after(after) && r.getDate().before(before) && r.getEvent() == Event.DONE_TASK  && r.getTaskNuber() >0 )
                            .map(Log::getTaskNuber)
                            .collect(Collectors.toList());
        } else if (after != null) {
            list =
                    logsToArray.getArrayLogs().stream()
                            .filter(r -> r.getDate().after(after) && r.getEvent() == Event.DONE_TASK  && r.getTaskNuber() >0 )
                            .map(Log::getTaskNuber)
                            .collect(Collectors.toList());
        } else if (before != null) {
            list =
                    logsToArray.getArrayLogs().stream()
                            .filter(r -> r.getDate().before(before) && r.getEvent() == Event.DONE_TASK  && r.getTaskNuber() >0 )
                            .map(Log::getTaskNuber)
                            .collect(Collectors.toList());
        } else {
            list =
                    logsToArray.getArrayLogs().stream()
                            .filter(r -> r.getEvent() == Event.DONE_TASK && r.getTaskNuber() >0 )
                            .map(Log::getTaskNuber)
                            .collect(Collectors.toList());
        }
        for (Integer taskN : list) {
            map.put(taskN, getNumberOfSuccessfulAttemptToSolveTask(taskN, after, before));
        }
        return map;
    }


    public Set<Date> getAllDates(Date after, Date before) {
        if (after != null && before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before))
                    .map(Log::getDate)
                    .collect(Collectors.toSet());
        } else if (after != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after))
                    .map(Log::getDate)
                    .collect(Collectors.toSet());
        } else if (before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before))
                    .map(Log::getDate)
                    .collect(Collectors.toSet());
        } else {
            return logsToArray.getArrayLogs().stream()
                    .map(Log::getDate)
                    .collect(Collectors.toSet());
        }
    }

    public Set<Status> getAllStatus(Date after, Date before) {
        if (after != null && before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after) && r.getDate().before(before))
                    .map(Log::getStatus)
                    .collect(Collectors.toSet());
        } else if (after != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().after(after))
                    .map(Log::getStatus)
                    .collect(Collectors.toSet());
        } else if (before != null) {
            return logsToArray.getArrayLogs().stream()
                    .filter(r -> r.getDate().before(before))
                    .map(Log::getStatus)
                    .collect(Collectors.toSet());
        } else {
            return logsToArray.getArrayLogs().stream()
                    .map(Log::getStatus)
                    .collect(Collectors.toSet());
        }
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> resultSet = new HashSet<>();
        List<String> parseStr = new ArrayList<>();
        Date date = new Date();
        switch (query){
            case "get ip" : resultSet.addAll(getUniqueIPs(null,null)); break;
            case "get user" : resultSet.addAll(getAllUsers()); break;
            case "get date" : resultSet.addAll(getAllDates(null,null)); break;
            case "get event" : resultSet.addAll(getAllEvents(null,null)); break;
            case "get status" : resultSet.addAll(getAllStatus(null,null)); break;
            default : {
                parseStr = Arrays.asList(query.split("\""));

                try {
                    date = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(parseStr.get(1));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                parseStr = Arrays.asList(parseStr.get(0).replace(" = ","").split(" "));
                System.out.println(parseStr);
//                System.out.println(date);
                resultSet.addAll(getAllEvents(new Date(date.getTime()-1),new Date(date.getTime()+1)));

            }




        }

        return resultSet;
    }
}