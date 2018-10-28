package com.dolgov.webserver.resource;

import com.dolgov.webserver.resource.ResourceReader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ResourceReaderTest {

    @Test
    public void readContent() throws IOException {
        String expectedContent = new String ("<!doctype html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "    <meta charset=\"UTF-8\">" +
                "    <meta name=\"viewport\"" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">" +
                "    <link rel=\"stylesheet\" href=\"css/style.css\">" +
                "    <title>My Page</title>" +
                "</head>" +
                "<body>" +
                "<h1>Our first page in HTML</h1>" +
                "</body>" +
                "</html>");

        String actualContent = new String();

        ResourceReader resourceReader = new ResourceReader("resources\\webapp");
        actualContent = resourceReader.readContent("index.html");

        assertEquals(expectedContent,actualContent);
    }
}