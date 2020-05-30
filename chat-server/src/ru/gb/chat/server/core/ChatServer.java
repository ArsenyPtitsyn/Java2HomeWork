package ru.gb.chat.server.core;

import ru.gb.jtwo.network.ServerSocketThread;

public class ChatServer {

    ServerSocketThread server;

    public void start(int port) {
        if (server == null || !server.isAlive())
            server = new ServerSocketThread("Server", port, 2000);
        else
            System.out.println("Server already started");
    }

    public void stop() {
        if (server == null || !server.isAlive()) {
            System.out.println("Server is not running");
        } else {
            server.interrupt();
        }
    }
}