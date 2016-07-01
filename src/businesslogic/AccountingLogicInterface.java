package businesslogic;

import businesslogic.accounting.AuthenticationResult;
import businesslogic.accounting.job.Job;
import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.user.User;
import businesslogic.distribution.resource.HumanResource;

import java.io.IOException;

/**
 * Created by Esi on 6/22/2016.
 */
public interface AccountingLogicInterface {
    AuthenticationResult login(String username, String password);
    boolean signup(User user, Job[] jobs, Specialty[] specialties, HumanResource[] humanResources);
    void logout(int UserID);
    String recoverPassword(String username) throws IOException;
    void editProfile(User user);
}
