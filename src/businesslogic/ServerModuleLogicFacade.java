package businesslogic;

import businesslogic.distribution.resource.Module;
import businesslogic.distribution.resource.ModuleDAO;
import org.orm.PersistentException;

/**
 * Created by Esi on 6/22/2016.
 */
public class ServerModuleLogicFacade implements ModuleLogicInterface{

    private static ServerModuleLogicFacade instance;

    private ServerModuleLogicFacade() {
    }

    public static ServerModuleLogicFacade getInstance() {
        if(instance == null) {
            instance = new ServerModuleLogicFacade();
        }
        return instance;
    }

    @Override
    public Module[] getModuleList(int UserID) {
        StringBuffer condition = new StringBuffer("");

        Module[] result = null;
        try {
            result = ModuleDAO.listModuleByQuery(condition.toString(),null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        return result;
    }
}
