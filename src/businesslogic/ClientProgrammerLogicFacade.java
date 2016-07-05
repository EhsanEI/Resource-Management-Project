package businesslogic;

import businesslogic.distribution.resource.ModuleChange;
import businesslogic.utility.Date;
import businesslogic.utility.Notification;
import network.ClientNetwork;

import java.io.IOException;

/**
 * Created by Esi on 6/22/2016.
 */
public class ClientProgrammerLogicFacade implements ProgrammerLogicInterface{


    private static ClientNetwork clientNetwork;

    private static ClientProgrammerLogicFacade programmerLogicFacade;

    public static ClientProgrammerLogicFacade getInstance() throws IOException, ClassNotFoundException {
        if(programmerLogicFacade== null) {
            programmerLogicFacade= new ClientProgrammerLogicFacade();
            clientNetwork = ClientNetwork.getInstance();
        }
        return programmerLogicFacade;
    }


    @Override
    public Notification registerModuleCreation(int userID, int moduleID, String description, Date startDate, Date endDate) {
        return null;
    }

    @Override
    public Notification registerModuleMaintenance(int userID, int moduleID, ModuleChange[] changes) {
        return null;
    }
}
