package businesslogic;

import businesslogic.accounting.AuthenticationResult;
import businesslogic.accounting.job.Job;
import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.user.User;

/**
 * Created by Esi on 6/22/2016.
 */

public class ClientAccountingLogicFacade implements AccountingLogicInterface{

    private static ClientAccountingLogicFacade clientAccountingLogicFacade;

    public static ClientAccountingLogicFacade getInstance() {
        if(clientAccountingLogicFacade == null) {
            clientAccountingLogicFacade = new ClientAccountingLogicFacade();
        }
        return clientAccountingLogicFacade;
    }

    @Override
    public AuthenticationResult login(String username, String password) {
        return null;
    }

    @Override
    public void signup(User user, Job[] jobs, Specialty[] specialties) {

    }

    @Override
    public void logout(int UserID) {

    }

    @Override
    public void recoverPassword(String username) {

    }

    @Override
    public void editProfile(User user) {

    }

    @Override
    public User addUser() {
        return null;
    }
}
