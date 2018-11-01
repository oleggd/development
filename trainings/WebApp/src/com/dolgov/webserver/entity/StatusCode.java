package com.dolgov.webserver.entity;

public enum StatusCode {
    SUCCESS("200", "OK"),
    NOT_FOUND("404", "Not Found"),
    BAD_REQUEST("400", "Bad Request"),
    INTERNAL_SERVER_ERROR("500", "Internal Server Error"),
    METHOD_NOT_ALLOWED("405", "Method Not Allowed");

    private String statusCode;
    private String statusMessage;

    StatusCode(String statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public String generateResponseLine() {

        return "HTTP/1.1 " + statusCode + " " + statusMessage +
                "        Date: Sun, 28 Oct 2018 12:00:0 GMT\n" +
                "        Server: Apache\n" +
                "        X-Powered-By: PHP/5.2.4-2ubuntu5wm1\n" +
                "        Last-Modified: Wed, 11 Feb 2009 11:20:59 GMT\n" +
                "        Content-Language: ru\n" +
                "        Content-Type: text/html; charset=utf-8\n" +
                "        Content-Length: 1234\n" +
                "        Connection: close\n" +
                "        \n" +
                "        Here is content of file: \n \n";
    }

}
