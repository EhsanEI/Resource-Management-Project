package businesslogic;

import businesslogic.support.SystemConfiguration;
import businesslogic.support.SystemConfigurationDAO;
import org.orm.PersistentException;

/**
 * Created by Esi on 6/22/2016.
 */
public class ServerAdminLogicFacade implements AdminLogicInterface{

    private static ServerAdminLogicFacade instance;

    private ServerAdminLogicFacade() {
    }

    public static ServerAdminLogicFacade getInstance() {
        if(instance == null) {
            instance = new ServerAdminLogicFacade();
        }
        return instance;
    }

    @Override
    public boolean configureSystem(SystemConfiguration configureSystem) {

        SystemConfiguration oldConfiguration = null;
        try {
            oldConfiguration = SystemConfigurationDAO.getSystemConfigurationByORMID(1);
            SystemConfigurationDAO.delete(oldConfiguration);
        } catch (PersistentException e) {
        }

        try {
            SystemConfigurationDAO.save(configureSystem);
        } catch (PersistentException e) {
            e.printStackTrace();
            if(oldConfiguration != null) {
                try {
                    SystemConfigurationDAO.save(oldConfiguration);
                } catch (PersistentException e1) {
                    e1.printStackTrace();
                }
            }
        }

        //TODO notification
        System.out.println("sending notification...");
        return true;
    }
}
