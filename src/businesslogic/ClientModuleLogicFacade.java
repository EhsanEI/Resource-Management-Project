package businesslogic;

import businesslogic.distribution.resource.Module;
import network.ClientNetwork;

import java.io.IOException;

/**
 * Created by Esi on 6/22/2016.
 */
public class ClientModuleLogicFacade implements ModuleLogicInterface{


    private static ClientNetwork clientNetwork;

    private static ClientModuleLogicFacade moduleLogicFacade;

    public static ClientModuleLogicFacade getInstance() throws IOException, ClassNotFoundException {
        if(moduleLogicFacade == null) {
            moduleLogicFacade = new ClientModuleLogicFacade();
            clientNetwork = ClientNetwork.getInstance();
        }
        return moduleLogicFacade;
    }

    @Override
    public Module[] getModuleList(int UserID) {
        return new Module[0];
    }
}
