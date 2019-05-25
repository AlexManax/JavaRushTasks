package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()){
            String[] temp = reader.readLine().replaceAll("\\s+"," ").trim().split(" ");
            Date date = new Date(Integer.parseInt(temp[temp.length-1])-1900, Integer.parseInt(temp[temp.length-2])-1, Integer.parseInt(temp[temp.length-3]));
            String name = "";
            for (int i = 0; i < temp.length-3; i++) {
                name += temp[i]+" ";
            }
            name = name.trim();
            PEOPLE.add(new Person(name,date));
        }
        reader.close();
        for (Person p:PEOPLE) {
            System.out.println(p.getName()+ " " + p.getBirthDate());
        }

    }
}
