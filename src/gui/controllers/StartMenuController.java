package gui.controllers;
/**
 * Created by qizilbash on 6/23/2016.
 */

import businesslogic.ClientAccountingLogicFacade;
import gui.MainMenu;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import network.ClientNetwork;

import java.io.IOException;
import java.net.ServerSocket;


public class StartMenuController{

    private ClientAccountingLogicFacade clientAccountingLogicFacade;

    private AnchorPane onTheTopPane;
    @FXML private AnchorPane signinPane;
    @FXML private AnchorPane signupPane;

    @FXML private ImageView backGroundImage;

    @FXML private Button signInButton;
    @FXML private Button SignUpButton;
    @FXML private Button recoverPasswordButton;

    @FXML private Button registerButton;
    @FXML private Button backFromSignupButton;


    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordField;

    @FXML private Label passwordLabel;
    @FXML private Label usernameLabel;

    private Stage stage;



    private Timeline timeline;

    private double animationTime = 700;

    @FXML
    private void
    initialize() throws IOException, ClassNotFoundException {
        clientAccountingLogicFacade = ClientAccountingLogicFacade.getInstance();
        onTheTopPane = signinPane;
    }

    @FXML
    private void signInPressed() throws Exception {
        stage = (Stage) usernameTextField.getScene().getWindow();
        System.out.println(usernameTextField.getText() + "@" + passwordField.getText());
        stage.close();
        

        // verifies the user and handle it
        // if user null returns
        // else sends the user for main menu
        new MainMenu().start(stage, null);
    }


    @FXML
    private void signUpPressed() {
        stage = (Stage) usernameTextField.getScene().getWindow();
        System.out.println("sign up pressed");
        backGroundImage.setFitHeight(620);
        stage.setHeight(620);
        animatePaneChange(signupPane, true);
    }

    @FXML
    private void recoverPasswordPressed() throws IOException {
        System.out.println(clientAccountingLogicFacade.recoverPassword(usernameTextField.getText()).getContent());
    }


    public void backFromSignupButtonPressed(ActionEvent event) {
        stage.setHeight(320);
        backGroundImage.setFitHeight(320);
        animatePaneChange(signinPane,false);
    }

    public void registerButtonPressed(ActionEvent event) {
    }

    public void animatePaneChange(AnchorPane anchorPane, boolean direction){

        double yPos1 = -600;
        double yPos2 = 600;

        if (!direction){
            yPos1 = 600;
            yPos2 = -600;
        }

        anchorPane.setLayoutX(0);
        anchorPane.setLayoutY(yPos1);

        Timeline timeline = new Timeline();

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(animationTime),
                        new KeyValue(anchorPane.layoutYProperty(),
                                0,
                                Interpolator.EASE_BOTH)));
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(animationTime),
                        new KeyValue(onTheTopPane.layoutYProperty(),
                                yPos2,
                                Interpolator.EASE_BOTH)));



        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();

        timeline.setOnFinished(event -> onTheTopPane = anchorPane);
    }


}