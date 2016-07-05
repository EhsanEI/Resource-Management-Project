package gui.controllers.accounting;

import businesslogic.ClientAccountingLogicFacade;
import businesslogic.accounting.user.User;
import gui.MainMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class LoginViewController {


    private  Stage stage;
    @FXML private TextField usernameTextField;


    @FXML private void recoverPasswordPressed(ActionEvent event) throws IOException, ClassNotFoundException {

        usernameTextField.getScene().getRoot().setDisable(true);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Password Recovery");
        alert.setContentText(ClientAccountingLogicFacade.getInstance().recoverPassword(usernameTextField.getText()).getContent());
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

        stage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));


        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK)
            usernameTextField.getScene().getRoot().setDisable(false);

    }

    @FXML private void signUpPressed(ActionEvent event) throws IOException {
        stage.hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../fxmls/accounting/SignupView.fxml"));
        Parent root = fxmlLoader.load();
        SignupViewController signupViewController = fxmlLoader.<SignupViewController>getController();
        signupViewController.setStage(stage);
        stage.setScene(new Scene(root,400,600));
        stage.setWidth(400);
        stage.setHeight(620);
        stage.show();
    }

    @FXML private void signInPressed() throws Exception {
        //User user = clientAccountingLogicFacade.login(usernameTextField.getText(), passwordField.getText()).getUser();
        // TODO
        User user = new User();

        if(user != null)
            new MainMenu().start(stage,user);
        else{
            usernameTextField.getScene().getRoot().setDisable(true);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Failed!");
            alert.setContentText(ClientAccountingLogicFacade.getInstance().recoverPassword(usernameTextField.getText()).getContent());

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

            stage.getIcons().add(new Image(getClass().getResource("../resources/erp.png").toString()));


            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK)
                usernameTextField.getScene().getRoot().setDisable(false);
        }
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }
}
