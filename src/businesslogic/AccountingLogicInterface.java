package businesslogic;

import businesslogic.accounting.AuthenticationResult;
import businesslogic.accounting.job.Job;
import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.user.User;
import businesslogic.distribution.resource.HumanResource;

/**
 * Created by Esi on 6/22/2016.
 */
public interface AccountingLogicInterface {
    AuthenticationResult login(String username, String password);
    void signup(User user, Job[] jobs, Specialty[] specialties, HumanResource[] humanResources);
    void logout(int UserID);
    void recoverPassword(String username);
    void editProfile(User user);
}
