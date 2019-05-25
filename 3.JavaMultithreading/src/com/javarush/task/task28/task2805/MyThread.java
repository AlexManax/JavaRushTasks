package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public MyThread() {
        this.setPriority(atomicInteger.getAndAdd(1));
        if (atomicInteger.get() == 11) atomicInteger.set(1);
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority(atomicInteger.getAndAdd(1));
        if (atomicInteger.get() == 11) atomicInteger.set(1);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority(atomicInteger.getAndAdd(1));
        if (atomicInteger.get() == 11) atomicInteger.set(1);

    }

    public MyThread(String name) {
        super(name);
        this.setPriority(atomicInteger.getAndAdd(1));
        if (atomicInteger.get() == 11) atomicInteger.set(1);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority(atomicInteger.getAndAdd(1));
        if (atomicInteger.get() == 11) atomicInteger.set(1);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority(atomicInteger.getAndAdd(1));
        if (atomicInteger.get() == 11) atomicInteger.set(1);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority(atomicInteger.getAndAdd(1));
        if (atomicInteger.get() == 11) atomicInteger.set(1);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority(atomicInteger.getAndAdd(1));
        if (atomicInteger.get() == 11) atomicInteger.set(1);
    }
}
