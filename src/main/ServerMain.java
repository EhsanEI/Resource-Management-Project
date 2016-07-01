package main;

import com.sun.javafx.tk.ScreenConfigurationAccessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by qizilbash on 7/1/2016.
 */
public class ServerMain {
    public static void main(String[] args) throws IOException, InterruptedException {
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
        while (true)
            System.out.println(input.readLine());

    }
    private static boolean available(int port) {
        try (Socket ignored = new Socket("", port)) {
            return false;
        } catch (IOException ignored) {
            return true;
        }
    }
}
