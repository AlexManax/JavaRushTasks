//package com.javarush.task.task28.task2810;
//
//import com.javarush.task.task28.task2810.model.Model;
//import com.javarush.task.task28.task2810.model.Provider;
//import com.javarush.task.task28.task2810.vo.Vacancy;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class Controller {
//    private Model model;
//
//    public Controller(Model model) {
//        if (model==null) throw new IllegalArgumentException();
//        this.model = model;
//    }
//
//    public void onCitySelect(String cityName){
//        model.selectCity(cityName);
//    }
//
//    //    private Provider[] providers;
//
////    public Controller(Provider... providers) {
////        if (providers.length<1) throw new IllegalArgumentException();
////        this.providers = providers;
////    }
//
////    @Override
////    public String toString() {
////        return "Controller{" +
////                "providers=" + Arrays.toString(providers) +
////                '}';
////    }
//
////    public void scan() {
////        ArrayList<Vacancy> allVacancies = new ArrayList<>();
////        try {
////            for (Provider provider : providers)
////                allVacancies.addAll(provider.getJavaVacancies(""));
////        } catch (NullPointerException e) {
////
////        }
////        System.out.println(allVacancies.size());
////    }
//}
