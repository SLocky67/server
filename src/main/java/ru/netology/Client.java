package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  {
        try (Socket socket = new Socket("localhost", Server.PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
             ) {
         out.println("Hi");
         System.out.println(in.readLine());
             }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}