package gui.controllers;
/**
 * Created by qizilbash on 6/23/2016.
 */

import businesslogic.ClientAccountingLogicFacade;
import businesslogic.accounting.user.User;
import gui.MainMenu;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import network.ClientNetwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Optional;


public class StartMenuController{

    private ClientAccountingLogicFacade clientAccountingLogicFacade;

    private AnchorPane onTheTopPane;
    @FXML private AnchorPane signinPane;
    @FXML private AnchorPane signupPane;
    @FXML private AnchorPane specialtyAdditionPane;
    @FXML private AnchorPane jobAdditionPane;

    //sign up fields
    @FXML private TextField signupUsernameTextField;
    @FXML private TextField signupPasswordTextField;
    @FXML private TextField confirmationTextField;
    @FXML private TextField emailTextField;
    @FXML private ComboBox<String> userTypeCombo;
    @FXML private ListView<String> jobsListView;
    @FXML private ListView<String> specialtiesListView;



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
    private void initialize() throws IOException, ClassNotFoundException {
        clientAccountingLogicFacade = ClientAccountingLogicFacade.getInstance();
        onTheTopPane = signinPane;
    }

    @FXML
    private void signInPressed() throws Exception {
        User user = clientAccountingLogicFacade.login(usernameTextField.getText(), passwordField.getText()).getUser();
        if(user != null)
            new MainMenu().start(stage,user);
        else{
            usernameTextField.getScene().getRoot().setDisable(true);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Failed!");
            alert.setContentText(clientAccountingLogicFacade.recoverPassword(usernameTextField.getText()).getContent());

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

            stage.getIcons().add(new Image(getClass().getResource("../resources/erp.png").toString()));


            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK)
                usernameTextField.getScene().getRoot().setDisable(false);
        }
    }


    @FXML
    private void signUpPressed() {
        stage = (Stage) usernameTextField.getScene().getWindow();
        backGroundImage.setFitHeight(620);
        stage.setHeight(620);
        animatePaneChange(signupPane, true);
    }

    @FXML
    private void recoverPasswordPressed() throws IOException, ClassNotFoundException {

        usernameTextField.getScene().getRoot().setDisable(true);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Password Recovery");
        alert.setContentText(clientAccountingLogicFacade.recoverPassword(usernameTextField.getText()).getContent());
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

        stage.getIcons().add(new Image(getClass().getResource("../resources/erp.png").toString()));


        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK)
            usernameTextField.getScene().getRoot().setDisable(false);

    }


    public void backFromSignupButtonPressed(ActionEvent event) {
        stage.setHeight(320);
        backGroundImage.setFitHeight(320);
        animatePaneChange(signinPane,false);
    }

    public void registerButtonPressed(ActionEvent event){

    }




    public void backFromSpecialtyAdditionPressed(Event event) {
        animatePaneChange(signupPane,false);
    }

    public void singleSpecialtyAddButtonPressed(ActionEvent event) {
    }

    public void backFromJobAdditionPressed(Event event) {
        animatePaneChange(signupPane, false);
    }

    public void singleJobAddButtonPressed(ActionEvent event) {
    }

    public void addSpecialtyButtonPressed(ActionEvent event) {
    }

    public void addJobButtonPressed(ActionEvent event) {
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