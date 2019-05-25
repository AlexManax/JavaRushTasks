package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horse) {
        this.horses = horse;
    }

    public static Hippodrome game;


    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }
    }

    public void print() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse horse = null;
        for (int i = 1; i < horses.size(); i++) {
            if (horses.get(i - 1).getDistance() >= horses.get(i).getDistance()) {
                horse = horses.get(i - 1);
            } else {
                horse = horses.get(i);
            }
        }
        return horse;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses2 = new ArrayList<>();
        horses2.add(new Horse("Alex's", 3, 0));
        horses2.add(new Horse("2", 3, 0));
        horses2.add(new Horse("Ira's", 3, 0));
        game = new Hippodrome(horses2);
        game.run();
        game.printWinner();
    }
}
