package gui.controllers.programmer;

import gui.controllers.MainMenuController;
import gui.controllers.iMainMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by qizilbash on 6/25/2016.
 */
public class ProgrammerGuiController extends MainMenuController implements iMainMenuController {

    private MenuItem moduleCreation;
    private MenuItem moduleMaintenance;


    @FXML
    private AnchorPane emptyPane;
    @FXML
    private AnchorPane moduleMaintenancePane;
    @FXML
    private AnchorPane moduleCreationPane;

    @FXML
    private Button moduleCreationButton;
    @FXML
    private Button moduleMaintenanceButton;
    @FXML
    private Button addChangeButton;





    @FXML
    private void initialize(){
        onTheTopPane = emptyPane;
    }


    @Override
    public void initializeSpecifically() {
        moduleCreation = new MenuItem();
        moduleCreation.setText("Register Module Creation");

        moduleMaintenance = new MenuItem();
        moduleMaintenance.setText("Register Module Maintenance");

        moduleCreation.setOnAction(event -> {
            try {
                createModule();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        moduleMaintenance.setOnAction(event -> {
            try {
                maintainModule();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        permissionMenu.getItems().addAll(moduleCreation, moduleMaintenance);

    }


    private void maintainModule() throws IOException {
        animatePaneChange(moduleMaintenancePane, true);
    }

    private void createModule() throws IOException {
        animatePaneChange(moduleCreationPane, true);
    }



    @FXML
    public void addChangePressed(ActionEvent event) {
        System.out.println("add change pressed");
    }

    @FXML
    public void registerMaintenancePressed(ActionEvent event) {
        System.out.println("registerMaintenancePressed");
    }

    @FXML
    public void createModulePressed(ActionEvent event) {
        System.out.println("createModulepressed");
    }
}
