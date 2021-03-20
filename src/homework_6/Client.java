package homework_6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final int PORT = 8081;
    private final String IP_ADDRESS = "localhost";
    private final String EXIT = "стоп";
    private Scanner scanner;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public Client() {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);
            System.out.println("Клиент к серверу подключен");
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        messageFromServer(scanner.nextLine());
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();
            while (true) {
                String serverMessage = in.readUTF();
                if (serverMessage.equalsIgnoreCase(EXIT)) {
                    break;
                }
                System.out.println("Сервер: " + serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            messageFromServer(EXIT);
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void messageFromServer(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
