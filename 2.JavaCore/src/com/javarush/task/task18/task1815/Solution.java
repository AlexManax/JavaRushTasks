package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
        ATableInterface aTI;

        public TableInterfaceWrapper(ATableInterface aTI) {
            this.aTI = aTI;

        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            aTI.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return aTI.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            aTI.setHeaderText(newHeaderText);
        }
    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}