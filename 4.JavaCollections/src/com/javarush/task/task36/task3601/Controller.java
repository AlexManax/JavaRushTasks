package com.javarush.task.task36.task3601;

import com.sun.javafx.scene.control.ReadOnlyUnbackedObservableList;

import java.util.List;

public class Controller {

    public List<String> onShowDataList() {
        return new Model().getStringDataList();
    }


}
