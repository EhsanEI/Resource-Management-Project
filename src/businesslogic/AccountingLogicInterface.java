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
    AuthenticationResult login(String username, String password) throws IOException, ClassNotFoundException;
    Notification signup(User user, Job[] jobs, Specialty[] specialties, HumanResource[] humanResources) throws IOException, ClassNotFoundException;
    boolean logout(int UserID) throws IOException, ClassNotFoundException;
    Notification recoverPassword(String username) throws IOException, ClassNotFoundException;
    Notification editProfile(User user) throws IOException, ClassNotFoundException;
}
