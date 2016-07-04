package gui.controllers.accounting;


import businesslogic.accounting.user.User;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.USER_EXCEPTION;


/**
 * Created by qizilbash on 6/25/2016.
 */
public class ProfileViewController {
    public User user;
    public Stage stage;

    @FXML
    public Pane anchorPane;

    @FXML
    private void backFromProfileView() {
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.hide();
        stage.close();
    }
    public void setUser(User user){
        this.user = user;
        System.out.printf("you are user " + user);
    }
}
