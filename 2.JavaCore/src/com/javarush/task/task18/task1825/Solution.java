package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
public ByteArrayOutputStream baos = new ByteArrayOutputStream();
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Thread> threads = new ArrayList<>();
        String str;

        HashMap<String, String> hashMap = new HashMap<>();
        while (!(str = reader.readLine()).equals("end")) {
            if (str.equals("end")) return;
            hashMap.put(str.substring(str.indexOf(".part") + 5, str.length()), str);


//        System.out.println(str.substring(str.indexOf(".part") + 5, str.length()));
//        System.out.println(str.substring(0, str.indexOf(".part")));
//        System.out.println( hashMap.get("1").substring(0, hashMap.get("1").indexOf(".part"))   );

        }
        String path;
        Solution x = new Solution();
        for (HashMap.Entry<String, String> pair : hashMap.entrySet()) {
            String key = pair.getKey();
            String val = pair.getValue();
            path = val;
//            System.out.println(key + " " + val);
//            threads.add(new FileThread(key,val));

            Thread t = x.new FileThread(key, val);
            t.start();
            t.join();
        }
//        System.out.println(hashMap.get("2").substring(0, hashMap.get("1").indexOf(".part")));

        FileOutputStream fos = new FileOutputStream(hashMap.get("1").substring(0, hashMap.get("1").indexOf(".part")));
        fos.write(x.baos.toByteArray());
        fos.close();
        x.baos.close();
        reader.close();
    }

    public class FileThread extends Thread {
        String filePath;
        String tnumber;

        public FileThread(String tnumber, String filePath) {
            this.filePath = filePath;
            this.tnumber = tnumber;
        }

        @Override
        public void run() {
            super.run();
            try {
                FileInputStream fis = new FileInputStream(filePath);
                byte[] buffer = new byte[1000];
                while (fis.available() > 0) {
                    int count = fis.read(buffer);
                    baos.write(buffer, 0, count);
                }
                fis.close();

//                System.out.println("Thread" + tnumber + " " + getId() + filePath);
            } catch (Exception e) {
            }
        }
    }
}
