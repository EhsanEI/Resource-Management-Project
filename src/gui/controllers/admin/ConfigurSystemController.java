package gui.controllers.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


/**
 * Created by qizilbash on 6/26/2016.
 */
public class ConfigurSystemController {

    @FXML
    private AnchorPane configureSystemAnchorPane;

    private int user;
    @FXML
    private Button configurreButton;
    @FXML
    private ComboBox<String> backupFormatsCombo;


    public void handle(AnchorPane anchorPane, int user) throws IOException {
        init(user);
        anchorPane.getChildren().set(2,configureSystemAnchorPane);
        anchorPane.getChildren().get(2).setLayoutY(25);
    }

    private void init(int user) throws IOException {
        this.user = user;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../fxmls/admin/ConfigureSystemView.fxml"));
        configureSystemAnchorPane = fxmlLoader.load();
    }

    @FXML
    public void configure() {
        System.out.println("configure pressed!");
    }
}
