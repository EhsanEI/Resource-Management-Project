package businesslogic;

import businesslogic.accounting.Authentication;
import businesslogic.accounting.AuthenticationResult;
import businesslogic.accounting.job.*;
import businesslogic.accounting.user.User;
import businesslogic.accounting.user.UserDAO;
import businesslogic.distribution.resource.HumanResource;
import businesslogic.distribution.resource.Spec;
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
    public void signup(User user, Job[] jobs, Specialty[] specialties, HumanResource[] humanResource) {
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
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logout(int UserID) {
        Authentication.getInstance().logout(UserID);
    }

    @Override
    public String recoverPassword(String username) {
        StringBuffer condition = new StringBuffer();
        condition.append("username = '").append(username).append("'");
        User[] users = null;
        try {
            users = UserDAO.listUserByQuery(condition.toString(),null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        if(users != null && users.length == 1) {
            User user = users[0];

            SecureRandom random = new SecureRandom();
            String randomPassword = new BigInteger(130, random).toString(32);

            user.setPassword(randomPassword);

            try {
                UserDAO.save(user);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        }
        return  null;
    }

    @Override
    public void editProfile(User user) {
        try {
            UserDAO.save(user);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User addUser() {
        return null;
    }
}
