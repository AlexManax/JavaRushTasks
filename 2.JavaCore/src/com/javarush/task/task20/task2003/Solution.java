package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fpth = br.readLine();
        br.close();
        InputStream is = new FileInputStream(fpth);
        load(is);
        is.close();
        OutputStream os = new FileOutputStream(fpth);
//        save(os);
//        os.close();
        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.store(outputStream, "d");
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        properties.putAll((Map)prop);
//        System.out.println(prop.values());
    }

    public static void main(String[] args) throws Exception {
//        new Solution().fillInPropertiesMap();

    }
}
