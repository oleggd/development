package com.dolgov.net;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestParser {


    public Request parseRequest(BufferedReader reader) throws IOException {

        Request request = new Request();
        // read first status line
        injectUriAndMethod(request, reader.readLine());
        // read others
        injectHeaders(request, reader);
        return request;

    }

    private void injectUriAndMethod(Request request, String requestLine) {
        request.httpMethod = requestLine.substring(0,requestLine.indexOf(" "));
        request.uri = requestLine.substring(requestLine.indexOf(" "),requestLine.lastIndexOf(" "));
        //"GET /wiki/страница HTTP/1.1\n"
    }

    private void injectHeaders(Request request, BufferedReader reader) throws IOException {
        String value;

        while ((value = reader.readLine()) != null && !value.isEmpty()) {
            request.headers.put(value.substring(0,value.indexOf(":")),
                                value.substring(value.indexOf(":"),value.length())
                               );
            //call injectHeaders
        }

    }
}
