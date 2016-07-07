package businesslogic;

import businesslogic.distribution.resource.Module;

import java.io.IOException;

/**
 * Created by Esi on 6/22/2016.
 */
public interface ModuleLogicInterface {
    Module[] getModuleList(int UserID) throws IOException, ClassNotFoundException;
}
