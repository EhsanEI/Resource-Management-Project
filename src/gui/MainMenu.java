package gui;

import gui.controllers.admin.AdminGuiController;
import gui.controllers.programmer.ProgrammerGuiController;
import gui.controllers.projectmanager.ProjectManagerGuiController;
import gui.controllers.resourcemanager.ResourceManagerGuiController;
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

    public void start(Stage stage, int user) throws Exception {
        FXMLLoader fxmlLoader;
        switch (user){
            case 1:
                fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/admin/AdminView.fxml"));
                root = fxmlLoader.load();
                AdminGuiController adminGuiController = fxmlLoader.<AdminGuiController>getController();
                adminGuiController.setUser(user);
                adminGuiController.initializeGenerally();
                adminGuiController.initializeSpecifically();
                break;
            case 2:
                fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/programmer/ProgrammerView1.fxml"));
                root = fxmlLoader.load();
                ProgrammerGuiController programmerGuiController= fxmlLoader.<ProgrammerGuiController>getController();
                programmerGuiController.setUser(user);
                programmerGuiController.initializeGenerally();
                programmerGuiController.initializeSpecifically();
                break;
            case 3:
                fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/projectmanager/ProjectManagerView.fxml"));
                root = fxmlLoader.load();
                ProjectManagerGuiController projectManagerGuiController= fxmlLoader.<ProjectManagerGuiController>getController();
                projectManagerGuiController.setUser(user);
                projectManagerGuiController.initializeGenerally();
                projectManagerGuiController.initializeSpecifically();
                break;
            case 4:
                fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/resourcemanager/ResourceManagerView1.fxml"));
                root = fxmlLoader.load();
                ResourceManagerGuiController resourceManagerGuiController= fxmlLoader.<ResourceManagerGuiController>getController();
                resourceManagerGuiController.setUser(user);
                resourceManagerGuiController.initializeGenerally();
                resourceManagerGuiController.initializeSpecifically();
                break;

        }


        stage.setTitle("ERP System");
        stage.getIcons().add(new Image(getClass().getResource("resources/erp.png").toString()));
        stage.setScene(new Scene(root, stageH, stageW));
        stage.setHeight(stageH);
        stage.setWidth(stageW);
        stage.show();
        stage.setResizable(false);
    }
}
