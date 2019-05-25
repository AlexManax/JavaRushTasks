package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String, ByteArrayOutputStream> filesToZip = new HashMap<>();
        Path pathToFile = Paths.get(args[0]);
        Path pathToZip = Paths.get(args[1]);

//        System.out.println(pathToFile.getFileName());
//        System.out.println(args[1]);

        byte[] buffer = new byte[2048];
        ZipEntry entry;

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]))) {
            while ((entry = zipInputStream.getNextEntry()) != null) {
                try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
//                    System.out.println(entry.getSize());
                    int len = 0;
                    while ((len = zipInputStream.read(buffer)) > 0) {
                        byteArrayOutputStream.write(buffer, 0, len);

                    }
                    filesToZip.put(entry.getName(), byteArrayOutputStream);
                }
            }

            File file = new File(args[0]);

            try (ZipOutputStream zipWriter = new ZipOutputStream(new FileOutputStream(args[1]))) {
                for (Map.Entry<String, ByteArrayOutputStream> pair : filesToZip.entrySet()) {
                    if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(file.getName())) continue;
                    zipWriter.putNextEntry(new ZipEntry(pair.getKey()));
                    zipWriter.write(pair.getValue().toByteArray());
                }

                ZipEntry zipEntry = new ZipEntry("new/" + file.getName());
                zipWriter.putNextEntry(zipEntry);
                Files.copy(file.toPath(), zipWriter);
            }


//            Path pathToZipFile = Paths.get("/new/" + pathToFile.getFileName().toString());
//            ZipEntry file = new ZipEntry(pathToZipFile.toString());
//            try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]))) {
//                try (FileInputStream fis = new FileInputStream(args[0])) {
//                    if (!filesToZip.containsKey(file.getName())) {
//
//                        Files.copy(fis,zipOutputStream);
//
//                        zipOutputStream.putNextEntry(file);
//                        zipOutputStream.write(readAll(fis).toByteArray());
//                    }
//
//
//                        for (Map.Entry<String, ByteArrayOutputStream> set : filesToZip.entrySet()) {
//
//
//                            zipOutputStream.putNextEntry(new ZipEntry(set.getKey()));
//                            zipOutputStream.write(set.getValue().toByteArray());
//                        }
//                    }
//                }
//            }

//        }


//    public static ByteArrayOutputStream readAll(FileInputStream fis) throws IOException {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        while (fis.available() > 0) {
//            byteArrayOutputStream.write(fis.read());
//        }
//        return byteArrayOutputStream;
//    }
        }
    }
}
