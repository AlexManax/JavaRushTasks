package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {
        String st = "Иванов Иван Иванович 31 12 1950" +
                "\nПетров Петр Петрович 31 12 1957";
        Scanner scanner = new Scanner(st);
new PersonScannerAdapter(scanner).read();

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() {
            String[] str = fileScanner.nextLine().split(" ");
String birthDateString = (str[3] + " " + str[4] + " " + str[5] + " ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = null;
            try {
                birthDate = sdf.parse(birthDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
//            System.out.println(new Person(str[1], str[2], str[0], birthDate));
            return new Person(str[1], str[2], str[0], birthDate);

        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
