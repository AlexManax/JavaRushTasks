package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");

    }

    public static void main(String[] args) {
//todo main class implementation here

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter (IncomeData data){
            this.data=data;
        }


        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.entrySet().stream().filter(key->key.getKey().equals(data.getCountryCode())).findFirst().get().getValue();
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", "+data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String sti = String.valueOf(data.getPhoneNumber());

            while (sti.length() < 10){
                sti = "0" + sti;
            }
            return "+" + data.getCountryPhoneCode() + "(" + sti.substring(0, 3) + ")" +
                    sti.substring(3, 6) + "-" + sti.substring(6, 8) + "-" + sti.substring(8, 10);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}