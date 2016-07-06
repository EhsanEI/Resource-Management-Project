package gui.controllers.admin;

import businesslogic.ClientAdminLogicFacade;
import businesslogic.support.SystemConfiguration;
import gui.Direction;
import gui.controllers.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


/**
 * Created by qizilbash on 7/4/2016.
 */
public class SystemConfigurationView extends Controller {

    //TODO

    @FXML private AnchorPane systemConfigurationPane;
    public void animate(){
        animatePaneChange(systemConfigurationPane, Direction.RIGHT);
    }

    public void specialInit(){

    }
    @FXML private void configure(ActionEvent event) throws IOException, ClassNotFoundException {
        ClientAdminLogicFacade.getInstance().configureSystem(new SystemConfiguration());
    }
}
