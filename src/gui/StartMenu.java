package gui;
/**
 * Created by qizilbash on 6/24/2016.
 */
import gui.controllers.StartMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class StartMenu extends Application {


    public static void main() {
        launch();
    }


    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/StartMenuView.fxml"));
        Parent root = fxmlLoader.load();
        StartMenuController startMenuController = fxmlLoader.<StartMenuController>getController();

        startMenuController.setStage(stage);

        stage.setTitle("ERP System");
        stage.setScene(new Scene(root, 400, 290));
        stage.getIcons().add(new Image(getClass().getResource("resources/erp.png").toString()));
        stage.setHeight(315);
        stage.setWidth(400);
        stage.setX(500);
        stage.setY(50);
        stage.show();
        stage.setResizable(false);
    }

}
