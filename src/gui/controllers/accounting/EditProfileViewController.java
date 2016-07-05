package gui.controllers.accounting;

import businesslogic.accounting.user.User;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class EditProfileViewController {
    private Stage stage;
    private User user;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public void buttonPresed(ActionEvent event) {
        System.out.println("hi");
    }
}
