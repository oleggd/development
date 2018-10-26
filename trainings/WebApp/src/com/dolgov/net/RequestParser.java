package com.dolgov.net;

import java.io.BufferedReader;
import java.io.IOException;

public class RequestParser {


    public Request parseRequest(BufferedReader reader) throws IOException {
        String value;
        Request request = new Request();
        // read first status line
        // call injectUriAndMethod
        // read others
        while ((value = reader.readLine()) != null && !value.isEmpty()) {

            //call injectHeaders
        }
        return request;

    }

    private void injectUriAndMethod(Request request, String requestLine) {

    }

    private void injectHeaders(Request request, BufferedReader reader) {

    }
}
