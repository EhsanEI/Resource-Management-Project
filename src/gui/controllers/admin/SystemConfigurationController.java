package gui.controllers.admin;

import businesslogic.ClientAdminLogicFacade;
import businesslogic.support.SystemConfiguration;
import gui.controllers.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;


/**
 * Created by qizilbash on 7/4/2016.
 */
public class SystemConfigurationController extends Controller {

    //TODO
    @FXML private void configure(ActionEvent event) throws IOException, ClassNotFoundException {
        ClientAdminLogicFacade.getInstance().configureSystem(new SystemConfiguration());
    }
}
