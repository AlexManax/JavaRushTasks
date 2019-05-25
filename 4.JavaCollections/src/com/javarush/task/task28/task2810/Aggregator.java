package com.javarush.task.task28.task2810;


import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.view.HtmlView;


public class Aggregator {
    public static void main(String[] args) {
//        Provider provider = new Provider(new HHStrategy());
//        Provider provider2 = new Provider(new MoikrugStrategy());
        Provider dice = new Provider(new DiceStrategy());

        HtmlView view = new HtmlView();
        Model model = new Model(view, dice);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();

//        Controller controller = new Controller(provider);
//            controller.scan();

//            new HHStrategy().getVacancies("");

//        Provider provider2 = new Provider(new DiceStrategy());
//        Controller controller2 = new Controller(provider2);
//        controller2.scan();
    }
}
