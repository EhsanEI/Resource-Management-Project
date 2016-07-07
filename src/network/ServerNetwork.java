package network;

import businesslogic.ServerAccountingLogicFacade;
import businesslogic.accounting.job.Job;
import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.user.User;
import businesslogic.distribution.resource.HumanResource;
import businesslogic.utility.Notification;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Esi on 6/25/2016.
 */
public class ServerNetwork {

    private ServerSocket listener;
    private ArrayList<Socket> clients = new ArrayList<>();

    public ServerNetwork(ServerSocket serverSocket) throws IOException {
        listener = serverSocket;
        new Thread(){
            public void run(){
                while (true){
                    try {
                        System.out.println("Waiting for Client ...");
                        Socket newClient = listener.accept();
                        clients.add(newClient);
                        listen(newClient,  new ObjectInputStream(newClient.getInputStream()),new ObjectOutputStream(newClient.getOutputStream()));
                        System.out.println("Client " + newClient.getPort() + " Connected!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void listen(Socket client, ObjectInputStream clientInputStream, ObjectOutputStream objectOutputStream) throws IOException {

        new Thread(){
            public void run(){
                NetworkRequest networkRequest = null;
                try {
                    while ((networkRequest = (NetworkRequest) clientInputStream.readObject()) != null)
                    {
                        try {
                            sendResponse(networkRequest, objectOutputStream);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    System.out.println(client.getPort() + "  Disconnected!");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    public boolean sendResponse(NetworkRequest request, ObjectOutputStream objectOutputStream) throws IOException {

        String method = request.getMethod();
        NetworkResponse networkResponse = null;


        switch (method){
            case "login":
                networkResponse = new NetworkResponse(
                        ServerAccountingLogicFacade.getInstance().login((String)request.getParams().get(0),
                                (String)request.getParams().get(1)),"Processed");
                break;

            case "signup":
                networkResponse = new NetworkResponse(
                        ServerAccountingLogicFacade.getInstance().signup((User) request.getParams().get(0),
                                (Job[]) request.getParams().get(1), (Specialty[]) request.getParams().get(2),
                                (HumanResource[]) request.getParams().get(3)), "Processed");
                break;

            case "logout":
                networkResponse = new NetworkResponse(
                        ServerAccountingLogicFacade.getInstance().logout((Integer)request.getParams().get(0)),"Processed");
                break;

            case "recoverPassword":
                networkResponse = new NetworkResponse(
                        ServerAccountingLogicFacade.getInstance().recoverPassword((String) request.getParams().get(0)), "processed");
                break;

            case "editProfile":
                networkResponse =  new NetworkResponse(
                        ServerAccountingLogicFacade.getInstance().editProfile((User)request.getParams().get(0)),"Processed");
                break;
        }


        objectOutputStream.writeObject(networkResponse);
        return true;
    }
}
