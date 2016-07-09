package gui.controllers.admin;

import businesslogic.ClientAdminLogicFacade;
import businesslogic.support.BackupFormat;
import businesslogic.support.SystemConfiguration;
import gui.Direction;
import gui.controllers.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by qizilbash on 7/4/2016.
 */
public class SystemConfigurationView extends Controller {

    @FXML private AnchorPane systemConfigurationPane;
    @FXML private TextField backupPeriodDays;

    @FXML private ComboBox<String> backupTeypesCombo;
    private Alert alert;

    public void animate(){
        animatePaneChange(systemConfigurationPane, Direction.RIGHT);
    }

    public void specialInit(){
        for(BackupFormat backupFormat : BackupFormat.values())
            backupTeypesCombo.getItems().add(backupFormat.toString());
        alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));
    }
    @FXML private void configure(ActionEvent event) throws IOException, ClassNotFoundException {
        if (backupTeypesCombo.getSelectionModel().getSelectedItem().isEmpty()) {

        } else{
            SystemConfiguration systemConfiguration = new SystemConfiguration();
            systemConfiguration.setBackupFormat(BackupFormat.valueOf(backupTeypesCombo.getSelectionModel().getSelectedItem()));
            systemConfiguration.setBackupPreiodDays(Integer.parseInt(backupPeriodDays.getText()));
            ClientAdminLogicFacade.getInstance().configureSystem(systemConfiguration);
        }
    }
}
