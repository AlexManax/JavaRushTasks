package com.javarush.task.task35.task3507;


import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Set<? extends Animal> classesSet = new HashSet<>();


        ClassLoader classLoader;

        classLoader = new ClassLoader() {

            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                return super.findClass(name);
            }

        };

//        classLoader.findClass();


        return null;
    }

}
