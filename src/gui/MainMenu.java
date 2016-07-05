package gui;

import businesslogic.accounting.user.User;

import gui.controllers.MainMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by qizilbash on 6/25/2016.
 */
public class MainMenu {

    private double stageH = 625;
    private double stageW = 755;

    private Parent root;


    public void start(Stage stage, User user) throws Exception {

        stage.hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/MainMenuView.fxml"));

        root = fxmlLoader.load();

        MainMenuController mainMenuController = fxmlLoader.<MainMenuController>getController();
        mainMenuController.setUser(user);
        mainMenuController.setStage(stage);
        mainMenuController.initializeView();

        stage.setTitle("ERP System");
        stage.getIcons().add(new Image(getClass().getResource("resources/erp.png").toString()));
        stage.setScene(new Scene(root, stageH, stageW));
        stage.setHeight(stageH);
        stage.setWidth(stageW);
        stage.setResizable(false);
        stage.setX(400);
        stage.show();

    }
}
