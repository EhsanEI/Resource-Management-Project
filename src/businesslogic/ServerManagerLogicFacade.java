package businesslogic;

import businesslogic.accounting.user.User;
import businesslogic.accounting.user.UserDAO;
import org.orm.PersistentException;

/**
 * Created by Esi on 6/22/2016.
 */
public class ServerManagerLogicFacade implements ManagerLogicInterface {

    private static ServerManagerLogicFacade instance;

    private ServerManagerLogicFacade() {
    }

    public static ServerManagerLogicFacade getInstance() {
        if(instance == null) {
            instance = new ServerManagerLogicFacade();
        }
        return instance;
    }

    @Override
    public User[] getUnapprovedUsers() {
        try {
            User[] users = UserDAO.listUserByQuery("Approved = False", null);
            return users;
        }
        catch (PersistentException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void approveUser(User newUser, boolean accepted) {
        User creatorUser = newUser.getCreatorUser();


        //No creator user -> Signup request
        if(creatorUser == null) {
            if(accepted) {
                newUser.approve();
                try {
                    UserDAO.save(newUser);
                } catch (PersistentException e) {
                    e.printStackTrace();
                }

            } else {
                //TODO send email
                System.out.println("sending email...");
            }
        }
        //There is a creator user -> EditProfile request
        else {
            if(accepted) {
                newUser.approve();
                try {
                    UserDAO.save(newUser);
                    UserDAO.delete(creatorUser);
                } catch (PersistentException e) {
                    e.printStackTrace();
                }

            } else {
                //TODO add notification
                System.out.println("adding notification...");
            }
        }
    }
}
