package com.javarush.task.task25.task2508;

import static java.lang.Thread.sleep;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    Thread thread;


    public void run(){
            try {
                while (Thread.currentThread().isAlive()){
                System.out.println(Thread.currentThread().getName());
                Thread.currentThread().sleep(100);}
            } catch (InterruptedException e) {
//                System.out.println("x");
        }
    }

    public void start(String threadName) {
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();


//        (this.thread = new Thread(threadName)).start();

//        System.out.println("x");
    }


    public void stop() {
        thread.interrupt();
    }

}
