package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread target;

    public void run() {

        String stateTarget = "";
        while (true) {
            if (!(stateTarget.equals(target.getState().name()))) {
                stateTarget = target.getState().name();
                System.out.println(stateTarget);
                if (stateTarget.equals("TERMINATED")) {
                    break;
                }
            }
        }
    }

    public LoggingStateThread(Thread target) {
        this.target = target;
    }
}