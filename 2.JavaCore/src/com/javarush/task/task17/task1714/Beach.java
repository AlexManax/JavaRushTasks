package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable <Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
//Beach beach = new Beach("a",12,1);
//Beach beach2= new Beach("b",10,2);
//        System.out.println(beach2.compareTo(beach));
    }

    @Override
    public synchronized int compareTo(Beach o) {
        return (int)(distance-o.distance)-(quality-o.quality);
    }
}
