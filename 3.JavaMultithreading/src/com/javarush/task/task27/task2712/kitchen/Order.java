//package com.javarush.task.task27.task2712.kitchen;
//
//import com.javarush.task.task27.task2712.ConsoleHelper;
//import com.javarush.task.task27.task2712.Tablet;
//
//import java.io.IOException;
//import java.util.List;
//
//public class Order {
//    private final Tablet tablet;
//    protected List<Dish> dishes;
//
//    public Order(Tablet tablet) throws IOException {
//        this.tablet = tablet;
//        this.dishes = ConsoleHelper.getAllDishesForOrder();
//    }
//
//    @Override
//    public String toString() {
//        if (dishes.size()==0) return ("");
//        return "Your order: " + dishes + " of " + tablet.toString();
//    }
//
//    public boolean isEmpty(){
//        if (dishes.size()==0) return true;
//        else return false;
//    }
//
//    public int getTotalCookingTime(){
//        int totalTime=0;
//        for (Dish dish:dishes) {
//            totalTime += dish.getDuration();
//        }
//        return totalTime;
//    }
//
//    public List<Dish> getDishes() {
//        return dishes;
//    }
//
//    public Tablet getTablet() {
//        return tablet;
//    }
//}
package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    protected List<Dish> dishes = new ArrayList<>();
    private final Tablet tablet;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    public Tablet getTablet() {
        return tablet;
    }

    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime() {
        int totalDuration = 0;
        for (Dish d : dishes) {
            totalDuration += d.getDuration();
        }
        return totalDuration;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        if (dishes == null || dishes.isEmpty()) {
            return "";
        }
        return "Your order: " + dishes + " of " + tablet + ", cooking time " + getTotalCookingTime() + "min";
    }
}
