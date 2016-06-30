package gui.controllers.programmer;

import gui.controllers.MainMenuController;
import gui.controllers.admin.ConfigurSystemController;
import gui.controllers.iMainMenuController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by qizilbash on 6/25/2016.
 */
public class ProgrammerGuiController extends MainMenuController implements iMainMenuController {

    private MenuItem moduleCreation;
    private MenuItem moduleMaintenance;

    private ModuleCreationController moduleCreationController;
    private ModuleMaintenanceController moduleMaintenanceController;

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
                maintaineModule();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        permissionMenu.getItems().addAll(moduleCreation, moduleMaintenance);

        moduleCreationController = new ModuleCreationController();
        moduleMaintenanceController = new ModuleMaintenanceController();
    }


    private void maintaineModule() throws IOException {
        stage = (Stage) anchorPane.getScene().getWindow();
        moduleMaintenanceController.handle(anchorPane, user);
    }

    private void createModule() throws IOException {
        stage = (Stage) anchorPane.getScene().getWindow();
        moduleCreationController.handle(anchorPane, user);
    }
}
