package com.dolgov.net;

import java.io.BufferedWriter;
import java.io.IOException;

public class ResponseWriter {

    private BufferedWriter socketWriter;


    public ResponseWriter(BufferedWriter socketWriter) {

        this.socketWriter = socketWriter;
    }

    public void sendSuccessResponse (String content) throws IOException {
        socketWriter.write("HTTP/1.1 200 OK\n" +
                "        Date: Wed, 11 Feb 2009 11:20:59 GMT\n" +
                "        Server: Apache\n" +
                "        X-Powered-By: PHP/5.2.4-2ubuntu5wm1\n" +
                "        Last-Modified: Wed, 11 Feb 2009 11:20:59 GMT\n" +
                "        Content-Language: ru\n" +
                "        Content-Type: text/html; charset=utf-8\n" +
                "        Content-Length: 1234\n" +
                "        Connection: close\n" +
                "                \n" +
                "        Here is content of file: \n \n");
        socketWriter.write(content);
        socketWriter.flush();
    }

    public void sendNotFoundResponse () throws IOException {
        String fielNotFoundResponce = "HTTP/1.1 404 OK\n" +
                "        Date: Wed, 11 Feb 2009 11:20:59 GMT\n" +
                "        Server: Apache\n" +
                "        X-Powered-By: PHP/5.2.4-2ubuntu5wm1\n" +
                "        Last-Modified: Wed, 11 Feb 2009 11:20:59 GMT\n" +
                "        Content-Language: ru\n" +
                "        Content-Type: text/html; charset=utf-8\n" +
                "        Content-Length: 1234\n" +
                "        Connection: close\n" +
                "                \n" +
                "        Following file not found!!!";
        socketWriter.write(fielNotFoundResponce);
        socketWriter.flush();
    }
    public void sendBadRequestResponse () {

    }
    public void sendInternalServerErrorResponse () {

    }
}
