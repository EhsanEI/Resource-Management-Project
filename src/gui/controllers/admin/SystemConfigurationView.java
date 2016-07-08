package gui.controllers.admin;

import businesslogic.ClientAdminLogicFacade;
import businesslogic.support.BackupFormat;
import businesslogic.support.SystemConfiguration;
import gui.Direction;
import gui.controllers.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


/**
 * Created by qizilbash on 7/4/2016.
 */
public class SystemConfigurationView extends Controller {

    @FXML private AnchorPane systemConfigurationPane;
    @FXML private TextField backupPeriodDays;

    public void animate(){
        animatePaneChange(systemConfigurationPane, Direction.RIGHT);
    }

    public void specialInit(){

    }
    @FXML private void configure(ActionEvent event) throws IOException, ClassNotFoundException {
        SystemConfiguration systemConfiguration =new SystemConfiguration();
        //TODO back up format not determined
        systemConfiguration.setBackupFormat(new BackupFormat());
        systemConfiguration.setBackupPreiodDays(Integer.parseInt(backupPeriodDays.getText()));
        ClientAdminLogicFacade.getInstance().configureSystem(systemConfiguration);
    }
}
