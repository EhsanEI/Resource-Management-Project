package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by qizilbash on 7/1/2016.
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
                    System.out.println("Waiting for Client ...");
                    destiny = listener.accept();
                    System.out.println("Connected to the server ...");
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

                        while (true){
                            try {
                                source = new Socket("", 9090);
                                break;
                            } catch (Exception e) {
                                continue;
                            }
                        }

                        while (true) {
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
                            System.out.println(networkRequest.getMethod());
                        }

                    }
                }
            }
        }.start();
    }


    public boolean sendRequest(NetworkRequest request) throws IOException {
        ObjectOutputStream clientOutputStream = new ObjectOutputStream(destiny.getOutputStream());
        clientOutputStream.writeObject(request);
        return true;
    }
}
