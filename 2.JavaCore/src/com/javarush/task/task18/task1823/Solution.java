package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fpath = null;

        while (!(fpath = reader.readLine()).equals("exit")) {
            ReadThread x = new ReadThread(fpath);
            x.start();
//            x.join();
        }

    }

    public static class ReadThread extends Thread {
        String fpath;

        public ReadThread(String fileName) {
            //implement constructor body
            super();
            this.fpath = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {


            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fpath);

                byte[] x = new byte[fis.available()];
                fis.read(x);
                int[] bytes = new int[255];
                for (int i = 0; i < x.length; i++) {
                    bytes[x[i]]++;
                }
                int c = 0;
                for (int i = 0; i < bytes.length; i++) {
                    if (c<bytes[i]) c=bytes[i];
                }
                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i]==c) resultMap.put(fpath,i);

                }
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
