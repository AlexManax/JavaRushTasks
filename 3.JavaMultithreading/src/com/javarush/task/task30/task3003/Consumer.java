package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            sleep(450);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            try {

                System.out.format("Processing %s\n",queue.take().toString());
            } catch (InterruptedException e) {

            }
        }
    }
}
