package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();

        Runnable r = new Runnable() {
            @Override
            public void run() {
//
                System.out.println(String.format(Thread.currentThread().getName()));
//
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        static AtomicInteger atomicPool = new AtomicInteger(1);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        String poolName = atomicPool.getAndAdd(1) + "-thread-";

        @Override
        public Thread newThread(Runnable r) {
            Thread x = new Thread(r);
            x.setName(Thread.currentThread().getThreadGroup().getName() + "-pool-" + poolName + atomicInteger.getAndAdd(1));
            x.setDaemon(false);
            x.setPriority(Thread.NORM_PRIORITY);
            return x;
        }
    }
}

