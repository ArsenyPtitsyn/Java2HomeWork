package lesson6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) {
        System.out.println("Начали");
        try (Socket socket = new Socket("127.0.0.1", 8189)) {
            System.out.println("Соединение прошло успешно");
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            System.out.println("Отправляем байт " + 123);
            out.write(123);
            int b = in.read();
            System.out.println("получили байт от сервера " + b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
