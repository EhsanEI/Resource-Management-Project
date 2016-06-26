package businesslogic;

import businesslogic.accounting.user.User;

/**
 * Created by Esi on 6/22/2016.
 */
public class ClientManagerLogicFacade implements ManagerLogicInterface {
    @Override
    public User[] getUnapprovedUsers() {
        return new User[0];
    }

    @Override
    public void approveUser(User newUser, boolean accepted) {

    }
}
