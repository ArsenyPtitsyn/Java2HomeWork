package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        System.out.println("создан сервер и ждём клиента");
        try (ServerSocket serverSocket = new ServerSocket(8189);
                Socket currentClient = serverSocket.accept()) {
            System.out.println("к нам подключился клиент");
            DataInputStream in = new DataInputStream(currentClient.getInputStream());
            DataOutputStream out = new DataOutputStream(currentClient.getOutputStream());
            while (true) {
                String str = in.readUTF();
                out.writeUTF("echo: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
