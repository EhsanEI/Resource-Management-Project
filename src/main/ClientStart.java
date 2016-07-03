package main;

import network.ClientNetwork;
import network.NetworkRequest;
import network.ServerNetwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by qizilbash on 7/1/2016.
 */
public class ClientStart {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientNetwork clientNetwork = new ClientNetwork(new Socket("",9090));

        Scanner scanner = new Scanner(System.in);
        while (true){
            String message = scanner.nextLine();
            System.out.println(clientNetwork.sendRequest(new NetworkRequest(message, null)).getMessage());
        }
    }
}
