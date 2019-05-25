package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            if (args[0]==null) {} } catch (Exception e){
            System.out.println("x");return;}
        if (args[0].equals("-d")){

            String filepath = reader.readLine();
            FileInputStream fis = new FileInputStream(filepath);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (fis.available() > 0) byteArrayOutputStream.write(fis.read());
            String[] str = byteArrayOutputStream.toString().split("\n");
            int tmp;
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < str.length; i++)
                if (Integer.parseInt(args[1].trim()) == (tmp = Integer.parseInt((str[i].substring(0, 8)).trim()))) {
                } else {list.add(str[i]);}
            fis.close();

            FileWriter fw = new FileWriter(filepath);
            BufferedWriter bf = new BufferedWriter(fw);
            for (String x:list) {

            bf.write(x);
            bf.newLine();
            }
            bf.close();

            fw.close();
            byteArrayOutputStream.close();
        }
        if (args[0].equals("-u")){

            String filepath = reader.readLine();
            FileInputStream fis = new FileInputStream(filepath);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (fis.available() > 0) byteArrayOutputStream.write(fis.read());
            String[] str = byteArrayOutputStream.toString().split("\n");
            int tmp;
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0; i < str.length; i++)
                if (Integer.parseInt(args[1].trim()) == (tmp = Integer.parseInt((str[i].substring(0, 8)).trim()))) {
                    while (args[1].length()<8) args[1] += " ";
                    while (args[2].length()<30) args[2] += " ";
                    while (args[3].length()<8) args[3] += " ";
                    while (args[4].length()<4) args[4] += " ";
                    list.add(""+args[1].substring(0,8)+ args[2].substring(0,30)+ args[3].substring(0,8)+args[4].substring(0,4));

                } else {list.add(str[i]);}
            fis.close();

            FileWriter fw = new FileWriter(filepath);
            BufferedWriter bf = new BufferedWriter(fw);
            for (String x:list) {

                bf.write(x);
                bf.newLine();
            }
            bf.close();

            fw.close();
            byteArrayOutputStream.close();
        }
    }
}
