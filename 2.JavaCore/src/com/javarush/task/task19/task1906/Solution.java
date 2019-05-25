package com.javarush.task.task19.task1906;

/* /Users/alexp/Desktop/JavaRushTasks/file1.txt
Четные символы
*/

import java.io.*;
import java.nio.Buffer;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fr = new FileReader(reader.readLine());
        FileWriter fw = new FileWriter(reader.readLine());
        reader.close();
        String data = "";
        while (fr.ready()) {
            fr.skip(1);
            data += (char)fr.read();

        }
        fr.close();
        fw.write(data);
        fw.close();
    }
}
