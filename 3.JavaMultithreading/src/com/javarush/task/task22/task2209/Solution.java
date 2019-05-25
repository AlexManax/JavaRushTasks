package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader rfile = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String line;
        StringBuilder stb = new StringBuilder();
        try {
            while ((line=rfile.readLine())!=null) {
                stb.append(line+" ");
            }
        } finally {
            rfile.close();
        }
        StringBuilder result = getLine(stb.toString().trim().split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words==null||words.length==0){return new StringBuilder();}
        StringBuilder stb = new StringBuilder();
        ArrayList<StringBuilder> listBld = new ArrayList<>();
        String[] words2 = words.clone();
        TreeSet<String> set = new TreeSet<>();
        for (int i=0; i<words.length;i++){
            set.add(words[i]);}
        for (String wrs :set){
            for (int i=0; i<words.length;i++){words2[i]=words[i];}
            StringBuilder tmp =new StringBuilder();
            String first = wrs;
            tmp.append(first+" ");
            for (int i =0; i<words.length; i++){
                for (int j=0; j<words.length; j++){
                    String second = words2[j];
                    if (!first.equals("+")&&!second.equals("+")){
                        char[] f = first.toLowerCase().toCharArray();
                        char[] s = second.toLowerCase().toCharArray();
                        if (f[f.length-1]==s[0]){
                            tmp.append(second+" ");
                            for (int r=0;r<words.length;r++){
                                if(first.equals(words2[r])){
                                    words2[r]="+";
                                }
                            }
                            for (int r=0;r<words.length;r++){
                                if(second.equals(words2[r])){
                                    words2[r]="+";
                                }
                            }
                            first=second;

                        }
                    }
                }
            }
            listBld.add(tmp);
        }
        stb=listBld.get(0);
        for (StringBuilder stbl : listBld){
            if (stb.length()<stbl.length()){
                stb=stbl;
            }
        }
        return stb;
    }
}