package com.javarush.task.task18.task1826;

/* 
Шифровка
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {


        if (args[0].equals("-e")) {
            new Encoding(args[1], args[2]);
        }
        if (args[0].equals("-d")) {
            new Decoding(args[1], args[2]);
        }

    }

    public static class Encoding {
        String filename, fileout;

        public Encoding(String filename, String fileout) throws IOException {
            this.filename = filename;
            this.fileout = fileout;
            FileInputStream fis = new FileInputStream(filename);
            FileOutputStream fos = new FileOutputStream(fileout);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (fis.available() > 0) {
                baos.write(fis.read());
            }
            int x = baos.size();
            for (int i = x - 1; i >= 0; i--) {
                fos.write(baos.toByteArray()[i]);
            }
            fis.close();
            fos.close();
            baos.close();
        }
    }

    public static class Decoding {
        String filename, fileout;

        public Decoding(String filename, String fileout) throws IOException {
            this.filename = filename;
            this.fileout = fileout;
            FileInputStream fis = new FileInputStream(filename);
            FileOutputStream fos = new FileOutputStream(fileout);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (fis.available() > 0) {
                baos.write(fis.read());
            }
            int x = baos.size();
            for (int i = x - 1; i >= 0; i--) {
                fos.write(baos.toByteArray()[i]);
            }
            fis.close();
            fos.close();
            baos.close();
        }
    }
}
