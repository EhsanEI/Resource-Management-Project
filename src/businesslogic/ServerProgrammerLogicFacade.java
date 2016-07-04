package businesslogic;

import businesslogic.distribution.resource.Module;
import businesslogic.distribution.resource.ModuleChange;
import businesslogic.distribution.resource.ModuleChangeDAO;
import businesslogic.distribution.resource.ModuleDAO;
import businesslogic.utility.Date;
import businesslogic.utility.Notification;
import org.orm.PersistentException;

/**
 * Created by Esi on 6/22/2016.
 */
public class ServerProgrammerLogicFacade implements ProgrammerLogicInterface{
    @Override
    public Notification registerModuleCreation(int userID, int moduleID, String description, Date startDate, Date endDate) {
        Notification notification = new Notification();

        Module module = null;
        try {
            module = ModuleDAO.getModuleByORMID(moduleID);
        } catch (PersistentException e) {
            notification.setContent("Module not found.");
            return notification;
        }

        module.setDescription(description);
        module.setStartDate(startDate.toString());
        module.setEndDate(endDate.toString());

        try {
            ModuleDAO.save(module);
        } catch (PersistentException e) {
            notification.setContent("Cannot save the changes.");
            return notification;
        }

        notification.setContent("Module creation has been saved.");
        return notification;
    }

    @Override
    public Notification registerModuleMaintenance(int userID, int moduleID, ModuleChange[] changes) {
        Notification notification = new Notification();

        Module module = null;
        try {
            module = ModuleDAO.getModuleByORMID(moduleID);
        } catch (PersistentException e) {
            notification.setContent("Module not found.");
            return notification;
        }

        try {
            for (ModuleChange change : changes) {
                module.addModuleChange(change);
                ModuleChangeDAO.save(change);
            }
            ModuleDAO.save(module);
        } catch(PersistentException e) {
            e.printStackTrace();
            notification.setContent("Cannot save the changes.");
            return notification;
        }

        notification.setContent("Module changes have been saved.");
        return notification;
    }
}
