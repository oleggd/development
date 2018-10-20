package com.dolgov.io;

import java.io.File;
import java.io.IOException;

public class FileManager {
    // public static int countFiles(String path) - принимает путь к папке,
    // возвращает количество файлов в папке и всех подпапках по пути
    public static int countFiles(String path) {
        File newPath = new File(path);
        // check path, if exists then process
        if ( !newPath.exists()) {
            return 0;
        }
        int fileCount = 0;
        for (File innerPath : newPath.listFiles()) {

            if (innerPath.isDirectory()) {
                fileCount +=countFiles(innerPath.toString());
            } else {
                fileCount += innerPath.isFile() ? 1 : 0;
            }
        }
        return fileCount;

    }

    // public static int countDirs(String path) - принимает путь к папке,
    // возвращает количество папок в папке и всех подпапках по пути
    public static int countDirs(String path) {
        File newPath = new File(path);
        // check path, if exists then process
        if ( !newPath.exists()) {
            return 0;
        }
        int dirCount = 0;
        for (File innerPath : newPath.listFiles()) {

            if (innerPath.isDirectory()) {
                dirCount +=countDirs(innerPath.toString());
                dirCount += innerPath.isFile() ? 0 : 1;
            } /*else {

            }*/
        }
        return dirCount;
    }
}
