package com.dolgov.net;

import java.io.BufferedWriter;

public class ResponseWriter {

    private BufferedWriter socketWriter;


    public ResponseWriter(BufferedWriter socketWriter) {
        this.socketWriter = socketWriter;
    }

    public void sendSuccessResponse (String content) {

    }

    public void sendNotFoundResponse () {

    }
    public void sendBadRequestResponse () {

    }
    public void sendInternalServerErrorResponse () {

    }
}
