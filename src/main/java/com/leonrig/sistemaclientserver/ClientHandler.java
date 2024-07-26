package com.leonrig.sistemaclientserver;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import static java.lang.System.in;

public class ClientHandler implements Runnable{
    private Socket socket;
    private RabbitTemplate rabbitTemplate;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RabbitConfig.class);
        this.rabbitTemplate = context.getBean(RabbitTemplate.class);
    }

    @Override
    public void run() {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String mensagem;
            while ((mensagem = in.readLine()) != null){
                System.out.println("Mensagem recibida: " + mensagem);

                rabbitTemplate.convertAndSend("minhafila", mensagem);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
