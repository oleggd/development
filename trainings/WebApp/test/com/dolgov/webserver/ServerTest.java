package com.dolgov.webserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class ServerTest {
    public static void main(String[] args) throws IOException {
        Server server = new Server("G:\\Work\\GitHubWorkingBranch\\trainings\\WebApp\\resources");
        //server.setPort(3000);
        //server.setWebAppPath("resource/webapp");
        server.start();

        /*String uri = new String ("/webapp/index.html");
        String webAppPath = "G:\\Work\\GitHubWorkingBranch\\trainings\\WebApp\\resources";
        File rootPath = new File(webAppPath*//*"G:\\Work\\GitHubWorkingBranch\\trainings\\WebApp\\resources"*//*);
        File sourceFileName = new File(rootPath, uri*//*"G:\\Work\\GitHubWorkingBranch\\trainings\\WebApp\\resources\\webapp\\index.html"*//*);
        System.out.println(sourceFileName.toString());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFileName));
        String line;

        while ((line = bufferedReader.readLine()) != null ) {
            System.out.println(line);
        }*/
    }
    //@Test

}


// http://localhost:3000/index.html
// http://localhost:3000/js/common/script.js

// GET /index.html HTTP 1.0

// URI -> /index.html
// on server -> webAppPath + URI -> resource/webapp/index.html

// URI -> /css/style.css
// on server -> webAppPath + URI -> resource/webapp/css/style.css