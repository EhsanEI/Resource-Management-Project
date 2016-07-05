package businesslogic;

import businesslogic.support.SystemConfiguration;
import network.ClientNetwork;

import java.io.IOException;

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
    public void configureSystem(SystemConfiguration configureSystem) {

    }
}
