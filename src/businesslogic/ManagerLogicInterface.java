package businesslogic;

import businesslogic.accounting.user.User;

import java.io.IOException;

/**
 * Created by Esi on 6/22/2016.
 */
public interface ManagerLogicInterface {
    User[] getUnapprovedUsers() throws IOException, ClassNotFoundException;
    boolean approveUser(User newUser, boolean accepted) throws IOException, ClassNotFoundException;
}
