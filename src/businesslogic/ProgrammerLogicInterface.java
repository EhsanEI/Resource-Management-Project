package businesslogic;

import businesslogic.distribution.resource.Module;
import businesslogic.distribution.resource.ModuleChange;
import businesslogic.utility.Date;
import businesslogic.utility.Notification;

/**
 * Created by Esi on 6/22/2016.
 */
public interface ProgrammerLogicInterface {
    Notification registerModuleCreation(int userID, int moduleID, String description, Date startDate, Date endDate);
    Notification registerModuleMaintenance(int userID, int moduleID, ModuleChange[] changes);
    Module[] getModuleList(int userID);
}
