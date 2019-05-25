package com.javarush.task.task31.task3101;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileUtils {

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void renameFile(File source, File destination) {
        if (!source.renameTo(destination)) System.out.println("Can not rename file with name " + source.getName());
    }

    public static boolean isExist(File file) {
        return file.exists();
    }



    public static List<File> getFilesFromSubDir(File path, List<File> pList) {
        List<File> pathList = new ArrayList<>();
        for (File file : path.listFiles()) {
            if (file.isFile())
                pathList.add(file);
            if (file.isDirectory())
                getFilesFromSubDir(file, pathList);
        }
        pList.addAll(pathList);
        return pathList;
    }
}
