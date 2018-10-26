package com.dolgov.net;

import java.io.*;

public class ResourceReader {
    private String webAppPath = "G:\\Work\\GitHubWorkingBranch\\trainings\\WebApp\\resources\\";
    private File rootPath = new File(webAppPath);

    public ResourceReader(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public String readContent (String uri) throws IOException {

        String content = new String();
        File sourceFileName = new File(rootPath.toString(), uri);

        //File sourceFileName = new File(webAppPath.toString()+"\\"+ uri) ;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFileName));

        try {
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null ) {
                stringBuilder.append(line);
            }

            content = stringBuilder.toString();
        } catch (IOException e){
            e.getMessage();
        }

        return content;
    }
}
