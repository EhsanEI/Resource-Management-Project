package businesslogic;

import businesslogic.accounting.AuthenticationResult;
import businesslogic.accounting.job.Job;
import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.user.User;
import businesslogic.distribution.resource.HumanResource;
import businesslogic.utility.Notification;

import java.io.IOException;

/**
 * Created by Esi on 6/22/2016.
 */
public interface AccountingLogicInterface {
    AuthenticationResult login(String username, String password);
    Notification signup(User user, Job[] jobs, Specialty[] specialties, HumanResource[] humanResources);
    boolean logout(int UserID);
    Notification recoverPassword(String username) throws IOException;
    Notification editProfile(User user);
}
