package network;

import businesslogic.ServerAccountingLogicFacade;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Esi on 6/25/2016.
 */
public class ServerNetwork {

    private ServerAccountingLogicFacade serverAccountingLogicFacade;
    private ServerSocket listener;
    private Socket destiny;
    private Socket source;

    public ServerNetwork(ServerSocket serverSocket) throws IOException {
        listener = serverSocket;
        serverAccountingLogicFacade = ServerAccountingLogicFacade.getInstance();
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
        String method = request.getMethod();
        NetworkResponse networkResponse = null;

        switch (method){
            case "recoverPassword":
                // call method from serverAccountingLogicFacade with request params
                // put returned object in Response
                networkResponse = new NetworkResponse(null,"processed");
            case "signup":
                //
        }


        ObjectOutputStream clientOutputStream = new ObjectOutputStream(destiny.getOutputStream());
        clientOutputStream.writeObject(networkResponse);
        return true;
    }
}
