package com.dolgov.net;

import java.util.HashMap;
import java.util.Map;

public class Request {
    String uri;
    String httpMethod;
    Map<String,String> headers = new HashMap<String,String>();

    public void buildRequest () {

    }

    public String toString() {
        String requestString = new String();

        requestString = httpMethod + "\n" +
                uri + "\n" +
                headers.toString();

        return requestString;
    }
}

/*
GET /wiki/страница HTTP/1.1
Host: ru.wikipedia.org
User-Agent: Mozilla/5.0 (X11; U; Linux i686; ru; rv:1.9b5) Gecko/2008050509 Firefox/3.0b5
Accept: text/html
Connection: close
(пустая строка)
*/