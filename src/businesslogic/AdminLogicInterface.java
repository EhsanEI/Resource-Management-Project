package businesslogic;

import businesslogic.support.SystemConfiguration;

import java.io.IOException;

/**
 * Created by Esi on 6/22/2016.
 */
public interface AdminLogicInterface {
    boolean configureSystem(SystemConfiguration configureSystem) throws IOException, ClassNotFoundException;
}
