package gui.controllers.programmer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by qizilbash on 6/26/2016.
 */
public class ModuleCreationController {
    @FXML
    private AnchorPane moduleCreationPane;

    private int user;
    @FXML
    private Button moduleCreationButton;
    @FXML
    private ComboBox<String> modulesCombo;


    public void handle(AnchorPane anchorPane, int user) throws IOException {
        init(user);
        anchorPane.getChildren().set(2, moduleCreationPane);
        anchorPane.getChildren().get(2).setLayoutY(25);
    }

    private void init(int user) throws IOException {
        this.user = user;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../fxmls/programmer/ModuleCreationView.fxml"));
        moduleCreationPane = fxmlLoader.load();
    }

    @FXML
    private void  createModule(){
        System.out.println("module creation pressed");
    }

}
