package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

import static java.lang.Thread.sleep;

public class Producer implements Runnable {
    TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.format("Элемент 'ShareItem-%s' добавлен\n", i);
            queue.offer(new ShareItem(i));
            try {
                sleep(100);
            } catch (InterruptedException e) {

            }
            if (queue.hasWaitingConsumer())
                System.out.format("Consumer в ожидании!\n");

        }
    }
}
