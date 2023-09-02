package ru.neotologia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", Server.Port);
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader bw = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            pw.println("Client message");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}