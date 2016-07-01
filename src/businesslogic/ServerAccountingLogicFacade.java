package businesslogic;

import businesslogic.accounting.Authentication;
import businesslogic.accounting.AuthenticationResult;
import businesslogic.accounting.job.*;
import businesslogic.accounting.user.User;
import businesslogic.accounting.user.UserDAO;
import businesslogic.distribution.resource.HumanResource;
import businesslogic.distribution.resource.Spec;
import businesslogic.utility.Notification;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Esi on 6/22/2016.
 */
public class ServerAccountingLogicFacade implements AccountingLogicInterface{

    private static ServerAccountingLogicFacade instance;

    private ServerAccountingLogicFacade() {
    }

    public static ServerAccountingLogicFacade getInstance() {
        if(instance == null) {
            instance = new ServerAccountingLogicFacade();
        }
        return instance;
    }

    @Override
    public AuthenticationResult login(String username, String password) {
        AuthenticationResult result = Authentication.getInstance().authenticate(username, password);
        return result;
    }

    @Override
    public Notification signup(User user, Job[] jobs, Specialty[] specialties, HumanResource[] humanResources) {

        try {

            for(Object ujObject: user.getORM_UserJobs()) {
                UserJob uj = (UserJob) ujObject;
                UserJobDAO.save(uj);
            }

            for(Job job: jobs) {
                JobDAO.save(job);
            }

            for(Specialty specialty: specialties) {
                SpecialtyDAO.save(specialty);
            }

            UserDAO.save(user);

            Notification notification = new Notification();
            notification.setContent("Signup was successful.");
            return notification;
        } catch (PersistentException e) {
        }

        Notification notification = new Notification();
        notification.setContent("Your request has been submitted.");
        return notification;
    }

    @Override
    public boolean logout(int UserID) {
        return Authentication.getInstance().logout(UserID);
    }

    @Override
    public Notification recoverPassword(String username) {
        StringBuffer condition = new StringBuffer();
        condition.append("username = '").append(username).append("'");
        User[] users = null;
        try {
            users = UserDAO.listUserByQuery(condition.toString(),null);
        } catch (PersistentException e) {
            Notification notification = new Notification();
            notification.setContent("User was not found.");
            return notification;
        }

        if(users != null && users.length == 1) {
            User user = users[0];

            SecureRandom random = new SecureRandom();
            String randomPassword = new BigInteger(130, random).toString(32);

            user.setPassword(randomPassword);

            try {
                UserDAO.save(user);
            } catch (PersistentException e) {
                Notification notification = new Notification();
                notification.setContent("Cannot save the changes.");
                return notification;
            }
        }
        Notification notification = new Notification();
        notification.setContent("Cannot recover password.");
        return notification;
    }

    @Override
    public Notification editProfile(User user) {
        try {
            UserDAO.delete(user.getCreatorUser());
            UserDAO.save(user);
            Notification notification = new Notification();
            notification.setContent("Your request has been submitted.");
            return notification;
        } catch (PersistentException e) {
        }
        Notification notification = new Notification();
        notification.setContent("Cannot save the changes.");
        return notification;
    }
}
