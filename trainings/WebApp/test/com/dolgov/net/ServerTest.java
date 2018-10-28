package com.dolgov.net;

import static org.junit.Assert.*;

public class ServerTest {
    public static void main(String[] args) {
        Server server = new Server();
        server.setPort(3000);
        server.setWebAppPath("resource/webapp");
        server.start();
    }
}


// http://localhost:3000/index.html
// http://localhost:3000/js/common/script.js

// GET /index.html HTTP 1.0

// URI -> /index.html
// on server -> webAppPath + URI -> resource/webapp/index.html

// URI -> /css/style.css
// on server -> webAppPath + URI -> resource/webapp/css/style.css