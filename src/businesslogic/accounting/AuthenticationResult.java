package businesslogic.accounting;

import businesslogic.accounting.user.User;
import businesslogic.utility.Notification;

/**
 * Created by Esi on 6/24/2016.
 */
public class AuthenticationResult {

    private User user;
    private Notification notification;

    public AuthenticationResult(User user, Notification notification) {
        this.user = user;
        this.notification = notification;
    }

    public User getUser() {
        return user;
    }

    public Notification getNotification() {
        return notification;
    }
}
