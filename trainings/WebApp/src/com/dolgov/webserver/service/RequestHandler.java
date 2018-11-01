package com.dolgov.webserver.service;

import com.dolgov.webserver.entity.StatusCode;
import com.dolgov.webserver.service.*;
import com.dolgov.webserver.entity.Request;
import com.dolgov.webserver.resource.ResourceReader;
import com.dolgov.webserver.exception.ServerException;

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

        String  contentString;
        Request request = new Request();

        RequestParser  requestParser  = new RequestParser();
        ResourceReader resourceReader = new ResourceReader(webAppPath);
        ResponseWriter responeWriter  = new ResponseWriter(writer);

        try {
            // get request
            // call RequestParser.parseRequest
            request = requestParser.parseRequest(reader);
            // get content for uri from parser
            // call ResourceReader.readContent(request.uri)
            contentString = resourceReader.readContent(request.uri);

            // call ResponceWriter.sendSomeResponce() depends on results
            responeWriter.sendSuccessResponse(StatusCode.SUCCESS, contentString);

        } catch (ServerException e) {
            // call ResponceWriter.sendSomeResponce() depends on results
            responeWriter.sendFailedResponse(e.getStatusCode());
        }
    }
}
