package network;

import businesslogic.ServerAccountingLogicFacade;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Esi on 6/25/2016.
 */
public class ServerNetwork {

    private ServerAccountingLogicFacade serverAccountingLogicFacade;

    private ServerSocket listener;
    private ArrayList<Socket> clients = new ArrayList<>();

    public ServerNetwork(ServerSocket serverSocket) throws IOException {
        listener = serverSocket;
        serverAccountingLogicFacade = ServerAccountingLogicFacade.getInstance();
        new Thread(){
            public void run(){
                while (true){
                    try {
                        System.out.println("Waiting for Client ...");
                        Socket newClient = listener.accept();
                        clients.add(newClient);
                        listen(newClient);
                        System.out.println("Client " + newClient.getPort() + " Connected!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void listen(Socket client) throws IOException {

        new Thread(){
            ObjectInputStream clientInputStream = new ObjectInputStream(client.getInputStream());
            public void run(){
                while (!client.isInputShutdown())
                {
                    try {
                        sendResponse((NetworkRequest) clientInputStream.readObject(), client);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


    public boolean sendResponse(NetworkRequest request, Socket client) throws IOException {

        String method = request.getMethod();
        NetworkResponse networkResponse = null;

        switch (method){
            case "recoverPassword":
                networkResponse = new NetworkResponse(
                        serverAccountingLogicFacade.recoverPassword((String)request.getParams().get(0)), "processed");
                break;
            case "signup":
                //
        }


        ObjectOutputStream clientOutputStream = new ObjectOutputStream(client.getOutputStream());
        clientOutputStream.writeObject(networkResponse);
        return true;
    }
}
