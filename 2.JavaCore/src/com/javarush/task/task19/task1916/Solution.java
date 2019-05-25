package com.javarush.task.task19.task1916;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileR1 = new FileReader(reader.readLine()); //todo reader.readLine();
        FileReader fileR2 = new FileReader(reader.readLine());
        reader.close();
        String file1Str = "", file2Str = "";

        while (fileR1.ready()) {
            file1Str += (char) fileR1.read();
        }
        while (fileR2.ready()) {
            file2Str += (char) fileR2.read();
        }
        fileR1.close();
        fileR2.close();
//*******************************************************************************************************************
        String[] file1 = file1Str.split("\\n");
        String[] file2 = file2Str.split("\\n");
        boolean isStoped = false;
        int i = 0, j = 0;
        while (!isStoped) {
            if (file1[i].equals(file2[j])){
                lines.add(new LineItem(Type.SAME,file1[i]));
                i++; j++;
            } else if (file1[i+1].equals(file2[j])){
                lines.add(new LineItem(Type.REMOVED,file1[i]));
                i++;
            } else if (file1[i].equals(file2[j+1])){
                lines.add(new LineItem(Type.ADDED,file2[j]));
                j++;
            }
            if (i>=file1.length) {
                lines.add(new LineItem(Type.ADDED,file2[j]));
                isStoped=true;}
            if (j>=file2.length) {
                lines.add(new LineItem(Type.REMOVED,file1[i]));
                isStoped=true;}
        }
        for (LineItem x:lines ) {
            System.out.println(x.type  + " : "+x.line );
        }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
