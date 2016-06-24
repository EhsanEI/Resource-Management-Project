package gui;

/**
 * Created by qizilbash on 6/23/2016.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class Controller {
    @FXML private Text actiontarget;
    @FXML protected void handleSubmitButtonAction() {
        actiontarget.setText("Sign in button pressed");
    }

}