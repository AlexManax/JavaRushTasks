package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.nio.CharBuffer;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
        if (args[0]==null) ;} catch (Exception e){return;}
        if (args[0].equals("-c")){
        String filepath = reader.readLine();
        FileInputStream fis = new FileInputStream(filepath);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (fis.available() > 0) byteArrayOutputStream.write(fis.read());
        String[] str = byteArrayOutputStream.toString().split("\n");
        int tmp;
        int max = 0;
        for (int i = 0; i < str.length; i++) {
            if (max < (tmp = Integer.parseInt((str[i].substring(0, 8)).trim()))) max = tmp;
        }

        fis.close();
        FileWriter fw = new FileWriter(filepath);
        BufferedWriter bf = new BufferedWriter(fw);

        bf.write(byteArrayOutputStream.toString());
        bf.newLine();
        String maxs;
            while ((maxs=String.valueOf(++max)).length()<8) maxs += " ";
            while (args[1].length()<30) args[1] += " ";
            while (args[2].length()<8) args[2] += " ";
            while (args[3].length()<4) args[3] += " ";
        bf.write(maxs.substring(0,8)+args[1].substring(0,30)+args[2].substring(0,8)+args[3].substring(0,4));



        bf.close();

        fw.close();
        byteArrayOutputStream.close();
        }
    }
}
