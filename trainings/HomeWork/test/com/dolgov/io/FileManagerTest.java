package com.dolgov.io;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class FileManagerTest {

    private String testPathName = "G:\\Work\\GitHub\\trainings\\HomeWork\\tmp\\";

    @Before
    public void before() {

        File testDir = new File(testPathName);
        if (!testDir.exists()) {
            try {
                testDir.mkdir();
                // create empty subfolder
                File newTestDir = new File(testPathName + "\\0");
                newTestDir.mkdir();
                // with one file
                newTestDir = new File(testPathName + "\\1");
                newTestDir.mkdir();
                newTestDir = new File(testPathName + "\\1\\test1.txt");
                newTestDir.createNewFile();

                //with two files
                newTestDir = new File(testPathName + "\\2");
                newTestDir.mkdir();
                newTestDir = new File(testPathName + "\\2\\test21.txt");
                newTestDir.createNewFile();
                newTestDir = new File(testPathName + "\\2\\test22.txt");
                newTestDir.createNewFile();

                //with three files
                newTestDir = new File(testPathName + "\\3");
                newTestDir.mkdir();
                newTestDir = new File(testPathName + "\\3\\test31.txt");
                newTestDir.createNewFile();
                newTestDir = new File(testPathName + "\\3\\test32.txt");
                newTestDir.createNewFile();
                newTestDir = new File(testPathName + "\\3\\test33.txt");
                newTestDir.createNewFile();

                // extra deep
                newTestDir = new File(testPathName + "\\4\\");
                newTestDir.mkdir();
                newTestDir = new File(testPathName + "\\4\\5\\");
                newTestDir.mkdir();
                newTestDir = new File(testPathName + "\\4\\5\\6\\");
                newTestDir.mkdir();

                newTestDir = new File(testPathName + "\\4\\5\\6\\test61.txt");
                newTestDir.createNewFile();
                newTestDir = new File(testPathName + "\\4\\5\\6\\test62.txt");
                newTestDir.createNewFile();
                newTestDir = new File(testPathName + "\\4\\5\\6\\7");
                newTestDir.mkdir();
                newTestDir = new File(testPathName + "\\4\\5\\6\\7\\test71.txt");
                newTestDir.createNewFile();
                newTestDir = new File(testPathName + "\\4\\5\\6\\7\\test72.txt");
                newTestDir.createNewFile();
                newTestDir = new File(testPathName + "\\4\\5\\6\\7\\8");
                newTestDir.mkdir();
                newTestDir = new File(testPathName + "\\4\\5\\6\\7\\8\\test81.txt");
                newTestDir.createNewFile();
                newTestDir = new File(testPathName + "\\4\\5\\6\\7\\8\\test82.txt");
                newTestDir.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // directory structure in G:\Work\GitHub\trainings\HomeWork\

    }

    @Test
    public void countFilesInWrongDir() {
        FileManager testFileManager = new FileManager();
        assertEquals(0, testFileManager.countFiles(testPathName+"XXX"));
    }

    @Test
    public void countFiles() {
        FileManager testFileManager = new FileManager();

        assertEquals(12,testFileManager.countFiles(testPathName ));
        assertEquals(1, testFileManager.countFiles(testPathName +"\\1"));
        assertEquals(2, testFileManager.countFiles(testPathName +"\\2"));
        assertEquals(3, testFileManager.countFiles(testPathName +"\\3"));
        assertEquals(6, testFileManager.countFiles(testPathName +"\\4"));
        assertEquals(6, testFileManager.countFiles(testPathName +"\\4\\5"));
        assertEquals(6, testFileManager.countFiles(testPathName +"\\4\\5\\6"));
        assertEquals(4, testFileManager.countFiles(testPathName +"\\4\\5\\6\\7"));
        assertEquals(2, testFileManager.countFiles(testPathName +"\\4\\5\\6\\7\\8"));
    }

    @Test
    public void countDirs() {
        FileManager testFileManager = new FileManager();

        assertEquals(9, testFileManager.countDirs(testPathName ));
        assertEquals(0, testFileManager.countDirs(testPathName +"\\1"));
        assertEquals(0, testFileManager.countDirs(testPathName +"\\2"));
        assertEquals(0, testFileManager.countDirs(testPathName +"\\3"));
        assertEquals(4, testFileManager.countDirs(testPathName +"\\4"));
        assertEquals(3, testFileManager.countDirs(testPathName +"\\4\\5"));
        assertEquals(2, testFileManager.countDirs(testPathName +"\\4\\5\\6"));
        assertEquals(1, testFileManager.countDirs(testPathName +"\\4\\5\\6\\7"));
        assertEquals(0, testFileManager.countDirs(testPathName +"\\4\\5\\6\\7\\8"));
    }

    @After
    public void after() {
        File testDir = new File(testPathName);
        if (testDir.exists()) {
            testDir.delete();
        }

    }
}