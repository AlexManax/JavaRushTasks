package com.javarush.task.task21.task2113;

import static java.lang.Math.floor;

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move() {
        setDistance(getDistance() + getSpeed() * Math.random());
    }

    public void print() {
//        System.out.println(getDistance());
        for (int i = 0; i < floor(getDistance()); i++) {
            System.out.print(".");
        }
        System.out.print(getName());
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
