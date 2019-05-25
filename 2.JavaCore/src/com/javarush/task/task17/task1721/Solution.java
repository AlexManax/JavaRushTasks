package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine(), //"/Users/alexp/Desktop/JavaRushTasks/file1.txt", // readLine here
               file2 = reader.readLine(); //"/Users/alexp/Desktop/JavaRushTasks/file2.txt";
        BufferedReader fileInputStream1 = new BufferedReader(new FileReader(file1));
        BufferedReader fileInputStream2 = new BufferedReader(new FileReader(file2));
        while (fileInputStream1.ready()) allLines.add(fileInputStream1.readLine());
        while (fileInputStream2.ready()) forRemoveLines.add(fileInputStream2.readLine());
//        Thread.currentThread().sleep(2000);
//        for (String x:allLines)       {System.out.println(x);}
//        for (String x:forRemoveLines) {System.out.println(x);}

        Solution x = new Solution();
        try {
            x.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines); else {allLines.clear(); throw new CorruptedDataException();}
//        for (String x:allLines)       {System.out.println(x);}
    }
}
