package com.javarush.task.task27.task2712.kitchen;


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.Thread.sleep;


public class Cook extends Observable implements Runnable{
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public Cook(String name) {
        this.name = name;
        ConsoleHelper.writeMessage(toString());
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isBusy() {
        return busy;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order.toString());
        setChanged();
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),
                name, order.getTotalCookingTime(), order.getDishes()));
        try {
            sleep(order.getTotalCookingTime()*10);
        } catch (InterruptedException e) {
        }
        busy = false;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                startCookingOrder(queue.take());
                Thread.sleep(10);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
