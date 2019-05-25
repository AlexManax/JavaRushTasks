package com.javarush.task.task31.task3113;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


import static java.nio.file.FileVisitResult.CONTINUE;

/* 
Что внутри папки?
*/
public class Solution {

    static long totalFolders = 0;
    static long totalFiles = 0;
    static long totalSize = 0;

    public static void main(String[] args) throws IOException {

//        long numOfDirs = 0;
//        long numOfFiles = 0;
//        long sizeOfFiles = 0;

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String stringPath = consoleReader.readLine();

//        stringPath = "/Users/alexp/Desktop/MyDownloads";
        Path path = Paths.get(stringPath);

        if (!Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath().toString() + " - не папка");
            return;
//            System.exit(0);
        }

        File rootDir = new File(path.toString());
//        List<String> result = new ArrayList<>();
//        Queue<File> fileTree = new PriorityQueue<>();
//        Collections.addAll(fileTree, rootDir.listFiles());
//
//
//        while (!fileTree.isEmpty()) {
//            File currentFile = fileTree.remove();
//            if (currentFile.isDirectory()) {
//                Collections.addAll(fileTree, currentFile.listFiles());
//                numOfDirs++;
//            } else if (currentFile.isFile()) {
//                numOfFiles++;
//                sizeOfFiles += Files.size(Paths.get(currentFile.getPath()));
//            }
//        }



        Files.walkFileTree(path, new Visitior());

        System.out.println("Всего папок - " + (totalFolders-1));
        System.out.println("Всего файлов - " + totalFiles);
        System.out.println("Общий размер - " + totalSize);
    }


    private static class Visitior extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            totalFolders += 1;
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            totalFiles += 1;
            totalSize = totalSize + attrs.size();
            return CONTINUE;
        }
    }
}
