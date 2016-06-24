package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Login extends Application {

    public static void main(String[] args) {
        Application.launch(Login.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        stage.setTitle("ERP System");
        stage.setScene(new Scene(root, 300, 275));
        stage.getIcons().add(new Image(Login.class.getResourceAsStream("erp.png")));
        stage.show();
    }
}
