package com.javarush.task.task29.task2912;

public class ConsoleLogger extends AbstractLogger implements Logger {

    public ConsoleLogger(int level) {
        super(level);
    }

    @Override
    public void info(String message) {
        System.out.println("Logging to console: " + message);
    }

}
//          Logging to file: All OK
//        Logging to console: We find a bug
//        Logging to file: We find a bug
//        Send sms to CEO: Database connection error
//        Logging to console: Database connection error
//        Logging to file: Database connection error
//        Call to director: System shut down
//        Send sms to CEO: System shut down
//        Logging to console: System shut down
//        Logging to file: System shut down