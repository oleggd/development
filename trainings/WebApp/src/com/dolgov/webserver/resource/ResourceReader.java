package com.dolgov.webserver.resource;

import com.dolgov.webserver.entity.StatusCode;
import com.dolgov.webserver.exception.ServerException;

import java.io.*;

public class ResourceReader {
    private String webAppPath;// = "G:\\Work\\GitHubWorkingBranch\\trainings\\WebApp";

    public ResourceReader(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public String readContent (String uri) throws IOException {

        String content = new String();

        //File sourceFileName = new File(webAppPath.toString()+"\\"+ uri) ;
        try {
            File rootPath = new File(webAppPath);
            File sourceFileName = new File(rootPath, uri/*"G:\\Work\\GitHubWorkingBranch\\trainings\\WebApp\\resources\\webapp\\index.html"*/);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFileName));

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null ) {
                stringBuilder.append(line);
            }

            content = stringBuilder.toString();
        } catch (IOException e){
            throw new ServerException("File not found", e, StatusCode.NOT_FOUND);
        }

        return content;
    }
}
