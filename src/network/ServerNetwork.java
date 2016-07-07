package network;

import businesslogic.*;
import businesslogic.accounting.job.Job;
import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.user.User;
import businesslogic.distribution.Allocation;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.resource.*;
import businesslogic.support.SystemConfiguration;
import businesslogic.utility.Date;
import businesslogic.utility.Notification;

import java.io.*;
import java.lang.System;
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
            case  "approveUser":
                networkResponse = new NetworkResponse(
                        ServerManagerLogicFacade.getInstance().approveUser(
                                (User)request.getParams().get(0),
                                (boolean)request.getParams().get(1)),"Processed");
                break;
            case "getUnapprovedUsers":
                networkResponse = new NetworkResponse(
                        ServerManagerLogicFacade.getInstance().getUnapprovedUsers(),"Processed"
                );
                break;
            case "configureSystem":

                break;
            case "getModuleList":
                networkResponse = new NetworkResponse(
                        ServerModuleLogicFacade.getInstance().getModuleList((Integer)request.getParams().get(0)),
                        "Processed");
                break;
            case "registerModuleMaintenance":
                networkResponse = new NetworkResponse(
                        ServerProgrammerLogicFacade.getInstance().registerModuleMaintenance(
                                (Integer)request.getParams().get(0),
                                (Integer)request.getParams().get(1),
                                (ModuleChange[])request.getParams().get(2)),"Processed"
                );
                break;
            case "registerModuleCreation":
                networkResponse = new NetworkResponse(
                  ServerProgrammerLogicFacade.getInstance().registerModuleCreation(
                          (Integer)request.getParams().get(0),
                          (Integer)request.getParams().get(1),
                          (String) request.getParams().get(2),
                          (Date) request.getParams().get(3),
                          (Date) request.getParams().get(4)),"Processed"
                );
                break;

            case "registerProjectScale":
                networkResponse = new NetworkResponse(
                  ServerProjectManagerLogicFacade.getInstance().registerProjectScale(
                          (Integer)request.getParams().get(0),
                          (Project)request.getParams().get(1)),"Processed"
                );
                break;
            case "estimateResourceAllocations":
                networkResponse = new NetworkResponse(
                  ServerProjectManagerLogicFacade.getInstance().estimateResourceAllocations(
                          (String[])request.getParams().get(0),
                          (Date)request.getParams().get(1),
                          (Date)request.getParams().get(2),
                          (Integer)request.getParams().get(3)),"Processed"
                );
                break;
            case "registerRequirement":
                networkResponse = new NetworkResponse(
                        ServerProjectManagerLogicFacade.getInstance().registerRequirement(
                                (Integer)request.getParams().get(0),
                                (Requirement) request.getParams().get(1)),"Processed");
                break;
            case "getProjectList":
                networkResponse = new NetworkResponse(
                        ServerProjectManagerLogicFacade.getInstance().getProjectList((Integer)request.getParams().get(0)),"Processed");
                break;
            case  "getProgrammers":
                networkResponse = new NetworkResponse(
                        ServerProjectManagerLogicFacade.getInstance().getProgrammers((Project)request.getParams().get(0)),"Processed");
                break;
            case "getModules":
                networkResponse = new NetworkResponse(
                        ServerProjectManagerLogicFacade.getInstance().getModules((Project)request.getParams().get(0)),"Processed");
                break;
            case "getInformationResources":
                networkResponse = new NetworkResponse(
                        ServerProjectManagerLogicFacade.getInstance().getInformationResources((Integer)request.getParams().get(0)),"Processed");
                break;
            case "getResourceNames":
                networkResponse = new NetworkResponse(
                        ServerProjectManagerLogicFacade.getInstance().getResourceNames((Integer)request.getParams().get(0),
                                (String)request.getParams().get(1)),"Processed");
                break;
            case "registerResourceAllocation":
                networkResponse = new NetworkResponse(
                        ServerResourceManagerLogicFacade.getInstance().registerResourceAllocation(
                                (Integer)request.getParams().get(0),
                                (Allocation)request.getParams().get(1),
                                (Resource[])request.getParams().get(2)
                        ),"Processed");
                break;
            case "rejectResourceAllocation":
                networkResponse = new NetworkResponse(
                        ServerResourceManagerLogicFacade.getInstance().rejectResourceAllocation(
                                (Integer) request.getParams().get(0),
                                (Integer) request.getParams().get(1)
                        ),"Processed");
                break;
            case "getInformationResourcesForResourceManager":
                networkResponse = new NetworkResponse(
                        ServerResourceManagerLogicFacade.getInstance().getInformationResources(
                                (Integer) request.getParams().get(0)
                        ),"Processed");
                break;
            case "getResourceNamesForResourceManager":
                networkResponse = new NetworkResponse(
                        ServerResourceManagerLogicFacade.getInstance().getResourceNames(
                                (Integer) request.getParams().get(0),
                                (String)request.getParams().get(1)
                        ),"Processed");
                break;
            case "getRequirements":
                networkResponse = new NetworkResponse(
                        ServerResourceManagerLogicFacade.getInstance().getRequirements(
                                (Integer) request.getParams().get(0)
                        ),"Processed");
                break;
            case "getResources":
                networkResponse = new NetworkResponse(
                        ServerResourceManagerLogicFacade.getInstance().getResources(
                                (Integer) request.getParams().get(0),
                                (String)request.getParams().get(1),
                                (String)request.getParams().get(2)
                        ),"Processed");
                break;
            case "registerNewResource":
                networkResponse = new NetworkResponse(
                        ServerResourceManagerLogicFacade.getInstance().registerNewResource(
                                (Integer) request.getParams().get(0),
                                (Resource)request.getParams().get(1)
                                ), "Processed");
                break;
            case "reportResources":
                networkResponse = new NetworkResponse(
                        ServerResourceManagerLogicFacade.getInstance().reportResources(), "Processed");
                break;
            case "reportFlowResourceAllocations":
                networkResponse = new NetworkResponse(
                        ServerResourceManagerLogicFacade.getInstance().reportFlowResourceAllocations(
                                (Resource)request.getParams().get(0),
                                (Date)request.getParams().get(1),
                                (Date)request.getParams().get(2)
                        ), "Processed");
                break;
            case "reportResourceRequirements":
                networkResponse = new NetworkResponse(
                        ServerResourceManagerLogicFacade.getInstance().reportResourceRequirements(
                                (InformationResource)request.getParams().get(0)
                                ), "Processed");
                break;
            case "predictEssentialResourceAllocations":
                networkResponse = new NetworkResponse(
                        ServerResourceManagerLogicFacade.getInstance().predictEssentialResourceAllocations(
                                (Project)request.getParams().get(0)
                                ), "Processed");
                break;
            case "getAllProjectList":
                networkResponse = new NetworkResponse(
                        ServerResourceManagerLogicFacade.getInstance().getAllProjectList(), "Processed");
                break;
        }



        objectOutputStream.writeObject(networkResponse);
        return true;
    }
}
