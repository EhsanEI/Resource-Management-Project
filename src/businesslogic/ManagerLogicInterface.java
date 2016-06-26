package businesslogic;

import businesslogic.accounting.user.User;

/**
 * Created by Esi on 6/22/2016.
 */
public interface ManagerLogicInterface {
    User[] getUnapprovedUsers();
    void approveUser(User newUser, boolean accepted);
}
