package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        Person obj=null;
        String sex;
        switch (args[0]) {
            case "-c": if (args[2].equals("м")) {
                        allPeople.add(obj=Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
                        System.out.println(allPeople.indexOf(obj)); }
                else   if ((args[2].equals("ж"))){  allPeople.add(obj=Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
                        System.out.println(allPeople.indexOf(obj)); }  break;

            case "-u": if (args[3].equals("м")) {allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], new SimpleDateFormat("dd/MM/yyyy").parse(args[4])));}
                else   if (args[3].equals("ж")) {allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], new SimpleDateFormat("dd/MM/yyyy").parse(args[4])));} break;

            case "-d": allPeople.get(Integer.parseInt(args[1])).setName(null); allPeople.get(Integer.parseInt(args[1])).setSex(null); allPeople.get(Integer.parseInt(args[1])).setBirthDate(null); break;

            case "-i": if(allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE)) sex = " м "; else sex = " ж ";
                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + sex + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(args[1])).getBirthDate())); break;
        }
    }
}

