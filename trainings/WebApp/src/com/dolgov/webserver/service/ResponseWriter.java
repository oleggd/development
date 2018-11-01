package com.dolgov.webserver.service;

import com.dolgov.webserver.entity.StatusCode;

import java.io.BufferedWriter;
import java.io.IOException;

public class ResponseWriter {

    private BufferedWriter socketWriter;


    public ResponseWriter(BufferedWriter socketWriter) {

        this.socketWriter = socketWriter;
    }

    public void sendSuccessResponse (StatusCode statusCode, String content) throws IOException {
        socketWriter.write(statusCode.generateResponseLine());
        socketWriter.write(content);
        socketWriter.flush();
    }

    public void sendFailedResponse (StatusCode statusCode) throws IOException {
        socketWriter.write(statusCode.generateResponseLine());
        socketWriter.flush();
    }

}
