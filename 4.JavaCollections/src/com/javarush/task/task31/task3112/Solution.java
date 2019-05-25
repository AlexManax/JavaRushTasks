package com.javarush.task.task31.task3112;

import com.sun.jndi.toolkit.url.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("/Users/alexp/Desktop/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        Path urlPath = Paths.get(urlString);

        Path tempFile = Files.createTempFile(urlPath.getFileName().toString(), ".tmp");

        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();

        Path resultFile = downloadDirectory.resolve(urlPath.getFileName());

//        System.out.println(resultFile);

        Files.move(tempFile, resultFile, StandardCopyOption.REPLACE_EXISTING);
        return resultFile;
    }
}
