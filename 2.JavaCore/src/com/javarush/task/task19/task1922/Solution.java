package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        Matcher matcher;
        Pattern pattern;
        String filename = null;

        try(BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in))) {
            filename = reader1.readLine();
        }catch (IOException e){e.printStackTrace();}

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String string = null;
            while ((string = reader.readLine())!= null){
                int count = 0;

                for(String word: words){
                    pattern = Pattern.compile("\\b" + word + "\\b");
                    matcher = pattern.matcher(string);
                    while (matcher.find()){
                        count++;
                    }
                }

                if (count == 2){System.out.println(string);}
            }
        } catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}

    }}