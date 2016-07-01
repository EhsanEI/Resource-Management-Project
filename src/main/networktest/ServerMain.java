package main.networktest;

import main.networktest.Banana;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by qizilbash on 7/1/2016.
 */
public class ServerMain {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        ServerSocket listener = new ServerSocket(9090);
        Scanner scanner = new Scanner(System.in);
        new Thread() {
            public void run() {
                try {
                    Socket socket = listener.accept();
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    while (true) {
                        out.println(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        Socket s = null;

        while (true){

            try {
                s = new Socket("", 9091);
                break;
            } catch (Exception e) {
                continue;
            }
         }

        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));

        while (true) {
            ObjectInputStream clientInputStream = new ObjectInputStream(s.getInputStream());
            Banana banana = (Banana) clientInputStream.readObject();
            System.out.println(banana.getId());
        }

    }
    private static boolean available(int port) {
        try (Socket ignored = new Socket("", port)) {
            return false;
        } catch (IOException ignored) {
            return true;
        }
    }
}
