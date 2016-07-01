package main;

import network.ClientNetwork;
import network.NetworkRequest;
import network.ServerNetwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

/**
 * Created by qizilbash on 7/1/2016.
 */
public class ServerStart {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerNetwork serverNetwork = new ServerNetwork(new ServerSocket(9090));
        serverNetwork.communicate();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String message = scanner.nextLine();
            serverNetwork.sendRequest(new NetworkRequest(message,null));
        }
    }
}
