package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        for (Thread thrd : threads) {
            switch (thrd.getState()) {
                case NEW:
                    thrd.start();
                    break;
                case RUNNABLE:
                    thrd.isInterrupted();
                    break;
                case BLOCKED:
                case WAITING:
                case TIMED_WAITING:
                    thrd.interrupt();
                    break;
                case TERMINATED:
                    System.out.println(thrd.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}
