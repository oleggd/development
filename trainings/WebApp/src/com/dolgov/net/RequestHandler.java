package com.dolgov.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class RequestHandler {
    private BufferedReader reader;
    private BufferedWriter writer;
    private String webAppPath;

    public RequestHandler(BufferedReader reader, BufferedWriter writer, String webAppPath) {
        this.reader = reader;
        this.writer = writer;
        this.webAppPath = webAppPath;
    }


    public void handle() throws IOException {

        String value;
        Request request = new Request();
        RequestParser requestParser = new RequestParser();
        ResourceReader resourceReader = new ResourceReader(webAppPath);
        ResponseWriter responeWriter = new ResponseWriter(writer);



        // get request
        // call RequestParser.parseRequest

        // get content for uri from parser
        // call ResourceReader.readContent(request.uri)

        // write file into output
        // call ResponceWriter.sendSomeResponce() depends on results

    }
}
