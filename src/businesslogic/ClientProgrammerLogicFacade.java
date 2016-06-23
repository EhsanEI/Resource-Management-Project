package businesslogic;

import businesslogic.distribution.resource.ModuleChange;
import businesslogic.utility.Date;

/**
 * Created by Esi on 6/22/2016.
 */
public class ClientProgrammerLogicFacade implements ProgrammerLogicInterface{
    @Override
    public void registerModuleCreation(int userID, int moduleID, String description, Date startDate, Date endDate) {

    }

    @Override
    public void registerModuleMaintenance(int userID, int moduleID, ModuleChange[] changes) {

    }
}
