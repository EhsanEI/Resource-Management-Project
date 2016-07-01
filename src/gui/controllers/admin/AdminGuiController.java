package gui.controllers.admin;


import gui.controllers.MainMenuController;
import gui.controllers.iMainMenuController;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;


/**
 * Created by qizilbash on 6/25/2016.
 */
public class AdminGuiController extends MainMenuController implements iMainMenuController {


    private MenuItem configuresystem;

    @FXML
    private AnchorPane configureSystemAnchorPane;
    @FXML
    private AnchorPane emptyPane;

    @FXML
    private void initialize(){
        onTheTopPane = emptyPane;
    }


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
    }

    private void configureSystemSelected() throws IOException {
        animatePaneChange(configureSystemAnchorPane, true);
    }


    public void configure(ActionEvent event) {
        System.out.println("configure pressed!");
    }


}
