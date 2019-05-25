package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }
    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static class Thread3 extends Thread {
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static class Thread4 extends Thread implements Message {

        @Override
        public void showWarning() {
            threads.get(3).interrupt();
        }

        @Override
        public void run() {
            super.run();
            while (!isInterrupted()) {
            }
        }
    }

    public static class Thread5 extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int sum;

        public void run() {
            try {
                while (!(input = reader.readLine()).equals("N")) {
                    sum += Integer.parseInt(input);
                }
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}