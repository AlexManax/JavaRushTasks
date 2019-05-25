package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader readFile = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = readFile.readLine();
            secondFileName = readFile.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        String fileName, fileData="", tmp;

        @Override
        public void setFileName(String fullFileName) {
            fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileData;
        }

        BufferedReader readFile;

        @Override
        public void run() {

            {
                try {

                    readFile = new BufferedReader(new FileReader(fileName));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                while ((tmp = readFile.readLine()) != null) {
                    fileData += tmp + " ";
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
