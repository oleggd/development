package com.dolgov.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

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
    /***
     * @implNote    - метод по копированию папок и файлов
     * @param       - from - путь к файлу или папке, to - путь к папке куда будет производиться копирование
     *
     */
    public static void copy(String from, String to) throws IOException {

        File fromPath = new File(from);
        File toPath = new File(to+"\\");

        if (!fromPath.exists()) {
            System.out.println("Error: source path does not exists!");

        } else if ( fromPath.isDirectory() ) {

            if ( !toPath.exists() ) {
                toPath.mkdir();
            }

            for (String fileName : fromPath.list()) {

                File srcFile = new File(fromPath.toString(), fileName);
                File destFile = new File(toPath.toString(), fileName);

                copy(srcFile.toString(), destFile.toString());

            }
        } else {
            if (toPath.isDirectory()) {
                File destFile = new File(toPath.toString(), fromPath.getName());
                copyFile(fromPath, destFile);
            } else {
                copyFile(fromPath, toPath);
            }
        }
    }

    private static void copyFile(File fromPath, File toPath) throws IOException {
        InputStream sourceFile = null;
        OutputStream destinationFile = null;
        try {
             //Files.copy(fromPath.toPath(), toPath.toPath()/*.resolve(fromPath.getName())*/, StandardCopyOption.REPLACE_EXISTING);
             sourceFile = new FileInputStream(fromPath);
             destinationFile = new FileOutputStream(toPath);

             byte[] buffer = new byte[1024];
             int length;
             while ((length = sourceFile.read(buffer)) > 0) {
                 destinationFile.write(buffer, 0, length);
             }
        } catch (FileNotFoundException e) {
              System.out.println("Error: can't copy this file!");
              e.printStackTrace();
        } finally {
              sourceFile.close();
              destinationFile.close();
        }
    }

    //- public static void move(String from, String to) - метод по перемещению папок и файлов.
    // Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться перемещение.
    public static void move(String from, String to) throws IOException {

        File fromPath = new File(from);
        File toPath = new File(to+"\\");

        if (!fromPath.exists()) {
            System.out.println("Error: source path does not exists!");

        } else if ( fromPath.isDirectory() ) {

            if ( !toPath.exists() ) {
                toPath.mkdir();
            }

            for (String fileName : fromPath.list()) {

                File srcFile = new File(fromPath.toString(), fileName);
                File destFile = new File(toPath.toString(), fileName);

                move(srcFile.toString(), destFile.toString());

            }
        } else {
            if (toPath.isDirectory()) {
                File destFile = new File(toPath.toString(), fromPath.getName());
                copyFile(fromPath, destFile);
            } else {
                copyFile(fromPath, toPath);
                Files.delete(fromPath.toPath());
            }
        }

    }
}
