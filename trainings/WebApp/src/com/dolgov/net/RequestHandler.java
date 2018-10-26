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

        String contentString;
        Request request = new Request();
        RequestParser requestParser   = new RequestParser();
        ResourceReader resourceReader = new ResourceReader(webAppPath);
        ResponseWriter responeWriter  = new ResponseWriter(writer);

        // get request
        // call RequestParser.parseRequest
        try {
            request = requestParser.parseRequest(reader);
        } catch (IOException e) {
            // call ResponceWriter.sendSomeResponce() depends on results
            responeWriter.sendBadRequestResponse();
        }


        // get content for uri from parser
        // call ResourceReader.readContent(request.uri)
        try {
            contentString = resourceReader.readContent(request.uri);
        } catch (IOException e) {
            // call ResponceWriter.sendSomeResponce() depends on results
            responeWriter.sendNotFoundResponse();
        }

        // write file into output
        // call ResponceWriter.sendSomeResponce() depends on results

    }
}
