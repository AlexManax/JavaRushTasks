package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String planet = null;
        try {
            planet = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (planet) {
            case "sun" : thePlanet = Sun.getInstance();
                break;
            case "moon" : thePlanet = Moon.getInstance();
                break;
            case "earth" : thePlanet = Earth.getInstance();
                break;
            default: thePlanet = null;
        }
    }
}

