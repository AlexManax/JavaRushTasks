package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];

        int filePartCount = args.length - 1;

        String[] fileNamePart = new String[filePartCount];
        for (int i = 0; i < filePartCount; i++) {
            fileNamePart[i] = args[i + 1];
        }
        Arrays.sort(fileNamePart);

        List<FileInputStream> fisList = new ArrayList<>();
        for (int i = 0; i < filePartCount; i++) {
            fisList.add(new FileInputStream(fileNamePart[i]));
        }

        SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));
        ZipInputStream zipInStream = new ZipInputStream(seqInStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);

        byte[] buf = new byte[1024 * 1024];

        while (zipInStream.getNextEntry() != null) {
            int count;
            while ((count = zipInStream.read(buf)) != -1) {
                fileOutStream.write(buf, 0, count);
            }
        }
        seqInStream.close();
        zipInStream.close();
        fileOutStream.close();
    }
}














//        Vector<ZipInputStream> vector = new Vector<>();
//        List<String> filStrings = new ArrayList<>();
//        for (int i = 1; i < args.length; i++) {
//            filStrings.add(args[i]);
//        }
//        Collections.sort(filStrings);
//
//        for (String path : filStrings) {
//            vector.add(new ZipInputStream(new FileInputStream(path)));
//        }
//
//        Enumeration en = vector.elements();
//        SequenceInputStream sequenceStream = new SequenceInputStream(en);
//
//        try (FileOutputStream fileOutputStream = new FileOutputStream(args[0])) {
//            while (sequenceStream.available() > 0) {
//                fileOutputStream.write(sequenceStream.read());
//            }
//        } catch (IOException e) {
//        }
//        sequenceStream.close();





//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//        for (int i = 1; i < args.length; i++) {
//            try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[i]))) {
//                while (zipInputStream.available() > 0)
//                    byteArrayOutputStream.write(zipInputStream.read());
//            } catch (IOException e) {
//            }
//        }
//
//        try (FileOutputStream fileOutputStream = new FileOutputStream(args[0])) {
//            fileOutputStream.write(byteArrayOutputStream.toByteArray());
//        } catch (IOException e) {
//        }
//    }

