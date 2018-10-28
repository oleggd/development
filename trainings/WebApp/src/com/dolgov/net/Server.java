package com.dolgov.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static int port = 3000;
    private String webAppPath;

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port);) {

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {

                    RequestHandler requestHandler = new RequestHandler(bufferedReader,bufferedWriter,webAppPath);

                    while (true) {
                        requestHandler.handle();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}