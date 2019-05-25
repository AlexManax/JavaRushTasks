//package com.javarush.task.task27.task2712;
//
//import com.javarush.task.task27.task2712.kitchen.Dish;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ConsoleHelper {
//
//
//    public static void writeMessage(String message) {
//        System.out.println(message.toString());
//    }
//
//    public static String readString() throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
//        return reader.readLine();
//    }
//
//    public static List<Dish> getAllDishesForOrder() throws IOException {
//        ConsoleHelper.writeMessage(Dish.allDishesToString());
//        List<Dish> dishes = new ArrayList<>();
//        String strDishToOrder;
//        Dish dish;
//        while (!(strDishToOrder = readString()).equals("exit")) {
//            try {
//                dish = Dish.valueOf(strDishToOrder);
//                dishes.add(dish);
//            } catch (IllegalArgumentException ex) {
//                writeMessage("The dish isn't present in the restaurant.");
//            }
//
//        }
//        return dishes;
//    }
//
//}
package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {

        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishesForOrder = new ArrayList<>();
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        ConsoleHelper.writeMessage("Введите выбранное блюдо");
        String enter = null;
        while (!(enter = readString()).equals("exit")) {
            try {
                dishesForOrder.add(Dish.valueOf(enter));
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("Такого блюда нет");
            }
        }
        return dishesForOrder;
    }
}