package ru.neotologia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer Port = 8070;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(Port)) {
            System.out.println("Server ready");
            while (true) {
                try (Socket client = serverSocket.accept();
                     PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                ) {
                    System.out.println("New connection accepted");
                    final String name = in.readLine();
                    System.out.println("Client message " + name);
                    System.out.println("Client port " + client.getPort());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
