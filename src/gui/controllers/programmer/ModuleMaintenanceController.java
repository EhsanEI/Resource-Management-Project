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
public class ModuleMaintenanceController {
    @FXML
    private AnchorPane moduleMaintenancePane;

    @FXML
    private AnchorPane contentPane;

    private int user;
    @FXML
    private Button moduleMaintenanceButton;
    @FXML
    private Button addChangeButton;
    @FXML
    private ComboBox<String> modulesCombo;


    public void handle(AnchorPane anchorPane, int user) throws IOException {
        init(user);
        anchorPane.getChildren().set(2,moduleMaintenancePane) ;
        anchorPane.getChildren().get(2).setLayoutY(25);

    }

    private void init(int user) throws IOException {
        this.user = user;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../fxmls/programmer/ModuleMaintenanceView1.fxml"));
        moduleMaintenancePane = fxmlLoader.load();
    }

    @FXML
    private void  addChange(){
        System.out.println("add change pressed");
    }

    @FXML
    private void registerMaintenance(){
        System.out.println("register changes pressed");
    }

}
