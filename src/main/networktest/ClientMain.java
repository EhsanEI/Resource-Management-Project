package main.networktest;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by qizilbash on 7/1/2016.
 */
public class ClientMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        Banana banana1= new Banana(1);
        Banana banana2 = new Banana(2);
        Bapple bapple = new Bapple(1);
        bapple.addBanana(banana1);
        bapple.addBanana(banana2);



        ServerSocket listener = new ServerSocket(9091);
        Scanner scanner = new Scanner(System.in);
        new Thread()
        {
            public void run() {
                try {
                    Socket socket = listener.accept();
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    while (true)
                    {
                        scanner.nextLine();
                        ObjectOutputStream clientOutputStream = new ObjectOutputStream(socket.getOutputStream());
                        clientOutputStream.writeObject(banana1);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


        Socket s = null;

        while (true){

            try {
                s = new Socket("", 9090);
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
