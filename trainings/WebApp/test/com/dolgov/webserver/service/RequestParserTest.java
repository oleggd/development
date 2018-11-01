package com.dolgov.webserver.service;

import com.dolgov.webserver.entity.Request;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import static org.junit.Assert.*;

public class RequestParserTest {

    @Test
    public void parseRequest() throws IOException {
        Request request = new Request();
        RequestParser requestParser = new RequestParser();

        String requestString = new String (
                "GET /wiki/страница HTTP/1.1\n" +
                "Host: ru.wikipedia.org\n" +
                "User-Agent: Mozilla/5.0 (X11; U; Linux i686; ru; rv:1.9b5) Gecko/2008050509 Firefox/3.0b5\n" +
                "Accept: text/html\n" +
                "Connection: close");

        String expectedRequest = "GET\n" +
                "/wiki/страница\n" + "{Host=: ru.wikipedia.org, " +
                "User-Agent=: Mozilla/5.0 (X11; U; Linux i686; ru; rv:1.9b5) Gecko/2008050509 Firefox/3.0b5, " +
                "Accept=: text/html}" + "Connection: close"
                ;

        Reader inputString = new StringReader(requestString);
        BufferedReader inputReader = new BufferedReader(inputString);

        request = requestParser.parseRequest(inputReader);
        assertEquals(expectedRequest,request.toString());

    }
}