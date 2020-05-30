package lesson6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) {
        System.out.println("Начали");
        try (Scanner sc = new Scanner(System.in);
             Socket socket = new Socket("127.0.0.1", 8189)) {
            System.out.println("Соединение прошло успешно");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                out.writeUTF(sc.nextLine());
                String str = in.readUTF();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
