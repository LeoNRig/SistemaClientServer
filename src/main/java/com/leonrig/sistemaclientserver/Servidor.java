package com.leonrig.sistemaclientserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private static final int PORT = 12345;
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor criado, porta " + PORT);
            while(true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
