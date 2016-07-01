package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Esi on 6/25/2016.
 */

public class ClientNetwork {
    private ServerSocket listener;
    private Socket destiny;
    private Socket source;

    public ClientNetwork(ServerSocket serverSocket) throws IOException {
        listener = serverSocket;
        new Thread(){
            public void run(){
                try {
                    System.out.println("Waiting for Server ...");
                    destiny = listener.accept();
                    System.out.println("Connected to the Server ...");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    public void communicate() throws IOException, ClassNotFoundException {
        while (true) {
            try {
                source = new Socket("", 9090);
                return;
            } catch (Exception e) {
                continue;
            }
        }
    }

    public NetworkResponse sendRequest(NetworkRequest request) throws IOException {

        ObjectOutputStream clientOutputStream = new ObjectOutputStream(destiny.getOutputStream());
        clientOutputStream.writeObject(request);

        ObjectInputStream clientInputStream = null;
        try {
            clientInputStream = new ObjectInputStream(source.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        NetworkResponse networkResponse = null;
        try {
            networkResponse = (NetworkResponse) clientInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return networkResponse;
    }
}
