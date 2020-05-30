package lesson6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        System.out.println("создан сервер и ждём клиента");
        try (ServerSocket serverSocket = new ServerSocket(8189);
                Socket currentClient = serverSocket.accept()) {
            System.out.println("к нам подключился клиент");
            InputStream in = currentClient.getInputStream();
            OutputStream out = currentClient.getOutputStream();
            int b = in.read();
            System.out.println("приняли байт " + b + ". Отправим " + (b + 1));
            out.write(b + 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
