package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try (Socket client = serverSocket.accept();
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
                ) {
                    final String name = in.readLine();
                    System.out.println("New connection accepted");
                    out.println(String.format("Hi %s, your port is %d", name, client.getPort()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}