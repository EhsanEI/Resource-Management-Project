package businesslogic;

import businesslogic.accounting.AuthenticationResult;
import businesslogic.accounting.job.Job;
import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.user.User;
import businesslogic.distribution.resource.HumanResource;
import network.ClientNetwork;
import network.NetworkRequest;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Esi on 6/22/2016.
 */

public class ClientAccountingLogicFacade implements AccountingLogicInterface{


    private static ClientNetwork clientNetwork;

    private static ClientAccountingLogicFacade clientAccountingLogicFacade;

    public static ClientAccountingLogicFacade getInstance() throws IOException, ClassNotFoundException {
        if(clientAccountingLogicFacade == null) {
            clientAccountingLogicFacade = new ClientAccountingLogicFacade();
            clientNetwork = new ClientNetwork(new ServerSocket(9091));
            clientNetwork.communicate();
        }
        return clientAccountingLogicFacade;
    }

    @Override
    public AuthenticationResult login(String username, String password) {
        return null;
    }

    @Override
    public void signup(User user, Job[] jobs, Specialty[] specialties, HumanResource[] humanResources) {

    }

    @Override
    public void logout(int UserID) {

    }

    @Override
    public String recoverPassword(String username) throws IOException {
        return clientNetwork.sendRequest(new NetworkRequest(username, null)).getMessage();
    }


    @Override
    public void editProfile(User user) {

    }

}
