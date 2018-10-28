package com.dolgov.webserver;

import com.dolgov.webserver.service.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int DEFAUT_PORT = 3000;
    private int port;
    private String webAppPath;

    public Server(String webAppPath) {
        this(DEFAUT_PORT,webAppPath);
    }

    public Server(int port, String webAppPath) {
        this.port = port;
        this.webAppPath = webAppPath;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(DEFAUT_PORT);) {

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {

                    RequestHandler requestHandler = new RequestHandler(bufferedReader,bufferedWriter,webAppPath);

                    requestHandler.handle();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}