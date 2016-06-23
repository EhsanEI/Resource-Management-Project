package businesslogic;

import businesslogic.accounting.user.User;

/**
 * Created by Esi on 6/22/2016.
 */
public interface AccountingLogicInterface {
    void login(String username, String password);
    void signup(User user);
    void logout(int UserID);
    void recoverPassword();
    void editProfile();
    User addUser();
}
