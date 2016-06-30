package gui.controllers.accounting;


import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * Created by qizilbash on 6/25/2016.
 */
public class ProfileEditController {
    public int user;
    public Stage stage;

    @FXML
    public Pane anchorPane;

    @FXML
    private void editProfile() {
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.hide();
        stage.close();
    }
    public void setUser(int user){
        user = 1;
        System.out.printf("you are user " + user);
    }
}
