package com.javarush.task.task17.task1711;

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
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public synchronized static void main(String[] args) throws ParseException {
        Person obj = null;
        String sex;
//        args = "-i 0 1".split(" ");
        switch (args[0]) {
            case "-c":
                for (int i = 0; i < args.length - 1; i += 3) {synchronized (allPeople){
                    if (args[i + 2].equals("м")) {
                        allPeople.add(obj = Person.createMale(args[i + 1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 3])));
                        System.out.println(allPeople.indexOf(obj));
                    } else if ((args[i + 2].equals("ж"))) {
                        allPeople.add(obj = Person.createFemale(args[i + 1], new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i + 3])));
                        System.out.println(allPeople.indexOf(obj));
                    }
                }}
                break;

            case "-u":
                for (int i = 0; i < args.length - 1; i += 4) {synchronized (allPeople){
                    if (args[i + 3].equals("м")) {
                        allPeople.set(Integer.parseInt(args[i + 1]), Person.createMale(args[i + 2], new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 4])));
                    } else if (args[i + 3].equals("ж")) {
                        allPeople.set(Integer.parseInt(args[i + 1]), Person.createFemale(args[i + 2], new SimpleDateFormat("dd/MM/yyyy").parse(args[i + 4])));
                    }
                }}
                break;

            case "-d":
                for (int i = 0; i < args.length - 1; i++) {synchronized (allPeople){
                    allPeople.get(Integer.parseInt(args[i + 1])).setName(null);
                    allPeople.get(Integer.parseInt(args[i + 1])).setSex(null);
                    allPeople.get(Integer.parseInt(args[i + 1])).setBirthDate(null);
                }}
                break;

            case "-i":
                for (int i = 0; i < args.length - 1; i++) {synchronized (allPeople){
                    if (allPeople.get(Integer.parseInt(args[i + 1])).getSex().equals(Sex.MALE)) sex = " м ";
                    else sex = " ж ";
                    System.out.println(allPeople.get(Integer.parseInt(args[i + 1])).getName() + sex +
                            new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(args[i + 1])).getBirthDate()));
                }}
                break;
        }
//        for (Person x:allPeople) {
//            System.out.println(x.getName()+" "+x.getSex()+" "+new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(x.getBirthDate()));
    }
}

