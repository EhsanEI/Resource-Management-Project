package businesslogic;

import businesslogic.distribution.resource.Module;

/**
 * Created by Esi on 6/22/2016.
 */
public class ClientModuleLogicFacade implements ModuleLogicInterface{
    @Override
    public Module[] getModuleList(int UserID) {
        return new Module[0];
    }
}
