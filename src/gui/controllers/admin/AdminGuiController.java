package gui.controllers.admin;


import gui.controllers.MainMenuController;
import gui.controllers.iMainMenuController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by qizilbash on 6/25/2016.
 */
public class AdminGuiController extends MainMenuController implements iMainMenuController {

    private MenuItem configuresystem;
    private ConfigurSystemController configurSystemController;


    public void initializeSpecifically(){
        configuresystem = new MenuItem();
        configuresystem.setText("Configure System");
        configuresystem.setOnAction(event -> {
            try {
                configureSystemSelected();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        permissionMenu.getItems().add(configuresystem);
        configurSystemController = new ConfigurSystemController();

    }

    private void configureSystemSelected() throws IOException {
        stage = (Stage) anchorPane.getScene().getWindow();
        configurSystemController.handle(anchorPane, user);
    }


}
