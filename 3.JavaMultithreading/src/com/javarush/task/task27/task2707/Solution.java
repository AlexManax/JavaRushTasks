package com.javarush.task.task27.task2707;

import static java.lang.Thread.sleep;

/*
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj2) {
            synchronized (obj1) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread t1 = new Thread(() -> {
synchronized (o1) {
    try {
        sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    synchronized (o2) {
    }
}
        });

        Thread t3 = new Thread(() -> solution.someMethodWithSynchronizedBlocks(o1, o2));

        t1.start();
        t3.start();


sleep(200);
        System.out.println(t1.getState());

        System.out.println(t3.getState());

        if (t3.getState() == Thread.State.BLOCKED) return false;
        else
            return true;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
