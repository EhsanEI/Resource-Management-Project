package businesslogic;

import businesslogic.accounting.user.User;
import businesslogic.accounting.user.UserDAO;
import businesslogic.utility.Notification;
import businesslogic.utility.NotificationDAO;
import network.Email;
import org.orm.PersistentException;
import orm.OODPersistentManager;

import javax.mail.MessagingException;

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
    public boolean approveUser(User newUser1, boolean accepted) {
        User newUser = null;
        try {
            newUser = UserDAO.getUserByORMID(newUser1.getID());
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        User creatorUser = newUser.getCreatorUser();

        //No creator user -> Signup request
        if(creatorUser == null) {
            Notification notification = NotificationDAO.createNotification();
            if(accepted) {
                newUser.approve();
                try {

                    UserDAO.save(newUser);
                    notification.setContent("Your signup request to Resource Management System has been accepted.");
                } catch (PersistentException e) {
                    e.printStackTrace();
                    return false;
                }

            } else {
                notification.setContent("Your signup request to Resource Management System has been rejected by animate manager.");
            }
            Email email = new Email(notification, newUser.getEmail());
            try {
                email.send();
            } catch (MessagingException e) {
            }
            return true;
        }
        //There is animate creator user -> EditProfile request
        else {
            if(accepted) {
                newUser.approve();
                try {
                    UserDAO.save(newUser);
                    UserDAO.delete(creatorUser);
                } catch (PersistentException e) {
                    e.printStackTrace();
                    return false;
                }

            } else {
                try {
                    UserDAO.delete(newUser);
                } catch (PersistentException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return true;
        }
    }
}
