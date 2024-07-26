package com.leonrig.sistemaclientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try(Socket socket = new Socket(HOST, PORT)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String mensagem;
            System.out.println("Digite a mensagem");

            while ((mensagem = stdIn.readLine()) != null) {}
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
