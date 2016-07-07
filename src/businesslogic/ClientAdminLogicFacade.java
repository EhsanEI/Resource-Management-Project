package businesslogic;

import businesslogic.support.SystemConfiguration;
import network.ClientNetwork;
import network.NetworkRequest;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Esi on 6/22/2016.
 */
public class ClientAdminLogicFacade implements AdminLogicInterface{

    private static ClientNetwork clientNetwork;

    private static ClientAdminLogicFacade clientAdminLogicFacade;

    public static ClientAdminLogicFacade getInstance() throws IOException, ClassNotFoundException {
        if(clientAdminLogicFacade == null) {
            clientAdminLogicFacade = new ClientAdminLogicFacade();
            clientNetwork = ClientNetwork.getInstance();
        }
        return clientAdminLogicFacade;
    }

    @Override
    public boolean configureSystem(SystemConfiguration configureSystem) throws IOException, ClassNotFoundException {
        ArrayList<Serializable> params = new ArrayList<>();
        params.add(configureSystem);
        return (boolean)clientNetwork.sendRequest(new NetworkRequest("configureSystem",params)).getResponse();
    }
}
