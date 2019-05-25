package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    final int number;

    public Tablet(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Order createOrder() {
        Order order;
        try {
            order = new Order(this);
            if (!order.isEmpty()) {
                ConsoleHelper.writeMessage(order.toString());
                try {
                    new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
                }catch (NoVideoAvailableException e){
                    logger.log(Level.INFO, "No video is available for the order " + order);
                }
            }
        } catch (IOException e) { //??
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        }
        return order;
    }

    public void createTestOrder() {
        TestOrder order = null;
        try {
            order = new TestOrder(this);
            processOrder(order);

        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

    }
    private void processOrder(Order order) {
        if (!order.isEmpty()) {
            ConsoleHelper.writeMessage(order.toString());
            //setChanged();
            //this.notifyObservers(order);
            try {
                queue.put(order);
            } catch (InterruptedException e) {

            }


            new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
        }
    }

        public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + '}';
    }
}

//package com.javarush.task.task27.task2712;
//
//import com.javarush.task.task27.task2712.ad.AdvertisementManager;
//import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
//import com.javarush.task.task27.task2712.kitchen.Order;
//import javafx.beans.InvalidationListener;
//import javafx.beans.Observable;
//
//
//import java.io.IOException;
//import java.util.Observer;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class Tablet implements Observable {
//    private final int number;
//    private static Logger logger = Logger.getLogger(Tablet.class.getName());
//    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();
//
//    public Tablet(int number) {
//        this.number = number;
//    }
//
//    public void setQueue(LinkedBlockingQueue<Order> queue) {
//        this.queue = queue;
//    }
//
//    public Order createOrder() {
//        Order order = null;
//        try {
//            order = new Order(this);
//            processOrder(order);
//            return order;
//        } catch (NoVideoAvailableException e) {
//            logger.log(Level.INFO, "No video is available for the order " + order);
//        } catch (IOException e) {
//            logger.log(Level.SEVERE, "Console is unavailable.");
//        }
//        return null;
//    }
//
//
////    public void createTestOrder() {
////        TestOrder order = null;
////        try {
////            order = new TestOrder(this);
////            processOrder(order);
////
////        } catch (NoVideoAvailableException e) {
////            logger.log(Level.INFO, "No video is available for the order " + order);
////        } catch (IOException e) {
////            logger.log(Level.SEVERE, "Console is unavailable.");
////        }
////
////    }
//
//    private void processOrder(Order order) {
//        if (!order.isEmpty()) {
//            ConsoleHelper.writeMessage(order.toString());
//            //setChanged();
//            //this.notifyObservers(order);
//
//            try {
//                queue.put(order);
//            } catch (InterruptedException e) {
//
//            }
//
//
//            new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "Tablet{" +
//                "number=" + number +
//                '}';
//    }
//
//    @Override
//    public void addListener(InvalidationListener listener) {
//
//    }
//
//    @Override
//    public void removeListener(InvalidationListener listener) {
//
//    }
//}