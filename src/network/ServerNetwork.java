package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by qizilbash on 7/1/2016.
 */

public class ServerNetwork {

    private ServerSocket listener;
    private Socket destiny;
    private Socket source;

    public ServerNetwork(ServerSocket serverSocket) throws IOException {
        listener = serverSocket;
        new Thread(){
            public void run(){
                try {
                    System.out.println("Waiting for Client ...");
                    destiny = listener.accept();
                    System.out.println("Connected to the Client ...");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void communicate() throws IOException, ClassNotFoundException {

        new Thread(){
            public void run(){
                while (true){
                    while (true) {
                        source = null;

                        while (true) {
                            try {
                                source = new Socket("", 9091);
                                break;
                            } catch (Exception e) {
                                continue;
                            }
                        }

                        while (true)
                        {
                            ObjectInputStream clientInputStream = null;
                            try {
                                clientInputStream = new ObjectInputStream(source.getInputStream());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            NetworkRequest networkRequest = null;
                            try {
                                networkRequest = (NetworkRequest) clientInputStream.readObject();
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                            try {
                                sendResponse(networkRequest);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }.start();
    }

    public boolean sendResponse(NetworkRequest request) throws IOException {
        // TODO
        // switch based on request method
        NetworkResponse networkResponse = null;

        if(request.getMethod().equals("me")){
            networkResponse = new NetworkResponse(null,"processed");
        }

        ObjectOutputStream clientOutputStream = new ObjectOutputStream(destiny.getOutputStream());
        clientOutputStream.writeObject(networkResponse);
        return true;
    }
}
