package businesslogic;

import businesslogic.accounting.job.Job;
import businesslogic.accounting.job.Programming;
import businesslogic.accounting.job.ProjectManagement;
import businesslogic.accounting.user.User;
import businesslogic.accounting.user.UserDAO;
import businesslogic.distribution.resource.*;
import businesslogic.utility.Date;
import businesslogic.utility.Notification;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import orm.OODPersistentManager;

import java.util.List;

/**
 * Created by Esi on 6/22/2016.
 */
public class ServerProgrammerLogicFacade implements ProgrammerLogicInterface{

    private static ServerProgrammerLogicFacade instance;

    private ServerProgrammerLogicFacade() {
    }

    public static ServerProgrammerLogicFacade getInstance() {
        if(instance == null) {
            instance = new ServerProgrammerLogicFacade();
        }
        return instance;
    }

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

    @Override
    public Module[] getModuleList(int userID) {
        Programming programming = getProgramming(userID);
        return programming.getModules();

    }

    private Programming getProgramming(int userID) {
        try {
            PersistentSession session = OODPersistentManager.instance().getSession();
            User user = UserDAO.getUserByORMID(userID);
            for(Job job:user.getJobs()) {
                if(job instanceof Programming) {
                    return (Programming) job;
                }
            }
        } catch (PersistentException e) {
        }
        return null;
    }
}
