package businesslogic;

import businesslogic.distribution.resource.Module;
import businesslogic.distribution.resource.ModuleChange;
import businesslogic.utility.Date;

/**
 * Created by Esi on 6/22/2016.
 */
public interface ProgrammerLogicInterface {
    void registerModuleCreation(int userID, int moduleID, String description, Date startDate, Date endDate);
    void registerModuleMaintenance(int userID, int moduleID, ModuleChange[] changes);
}
