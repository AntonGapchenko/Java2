package homework_6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private final int PORT = 8081;
    private final String EXIT = "стоп";
    private Scanner scanner;
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;


   public Server() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер ожидает клиента...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключен");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            scanner = new Scanner(System.in);
            out.writeUTF("Здравствуй Клиент");
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        messageFromClient(scanner.nextLine());
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();

            while (true) {
                String clientMessage = in.readUTF();
                if (clientMessage.equalsIgnoreCase(EXIT)) {
                    messageFromClient(EXIT);
                    break;
                }
                System.out.println("Клиент: " + clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void messageFromClient(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }


}
