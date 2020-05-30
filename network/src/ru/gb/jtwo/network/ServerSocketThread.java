package ru.gb.jtwo.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerSocketThread extends Thread {

    int port;
    int timeout;

    public ServerSocketThread(String name, int port, int timeout) {
        super(name);
        this.port = port;
        this.timeout = timeout;
        start();
    }

    @Override
    public void run() {
        System.out.println("Server started");
        try (ServerSocket server = new ServerSocket(port)) {
            server.setSoTimeout(timeout);
            while (!isInterrupted()) {
                Socket socket;
                try {
                    socket = server.accept();
                } catch (SocketTimeoutException e) {
                    System.out.println("PING? PONG!");
                    continue;
                }
                    System.out.println("Socket accept");

            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            System.out.println("Server stopped");
        }
    }
}
