package gui.controllers;


import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * Created by qizilbash on 6/25/2016.
 */
public class HelpViewController {
    public Stage stage;

    @FXML
    public Pane anchorPane;

    @FXML
    private void backFromHelp() {
        stage = (Stage) anchorPane.getScene().getWindow();
        stage.hide();
        stage.close();
    }
}
