package gui.controllers;
/**
 * Created by qizilbash on 6/23/2016.
 */

import gui.MainMenu;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;



public class StartMenuController{

    @FXML private Pane mainPane;
    @FXML private ImageView backGroundImage;

    @FXML private Button signInButton;
    @FXML private Button SignUpButton;
    @FXML private Button recoverPasswordButton;


    @FXML private TextField usernameTextField;
    @FXML private PasswordField passwordField;

    @FXML private Label passwordLabel;
    @FXML private Label usernameLabel;

    private Stage stage;
    private Button backButton;

    private TextField passwordTextField;
    private TextField confirmPasswordTextField;
    private Label confirmPasswordLabel;




    private Timeline timeline;

    private double animationTime = 700;



    @FXML private void signInPressed() throws Exception {
        System.out.println(usernameTextField.getText() + "@" + passwordField.getText());
        stage = (Stage) usernameTextField.getScene().getWindow();
        stage.close();

        // verifies the user and handle it
        // if user null returns
        // else sends the user for main menu
        new MainMenu().start(stage, Integer.parseInt(usernameTextField.getText()));
    }


    @FXML private void signUpPressed() {
        System.out.println("sign up pressed");
        changePane2SignUp();
    }

    @FXML private void recoverPasswordPressed() {
        System.out.println("recover password pressed");
    }

    private void changePane2SignIn(){

    }

    private void register(){
        System.out.println("register pressed");
    }

    private void backTostartMenu(){
        System.out.println("back pressed");

        backButton.setDisable(true);
        backButton.setVisible(false);




        signInButton.setDisable(false);
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(animationTime), signInButton);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1.0);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);
        fadeTransition.play();

        recoverPasswordButton.setDisable(false);
        FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(animationTime), recoverPasswordButton);
        fadeTransition1.setFromValue(0);
        fadeTransition1.setToValue(1.0);
        fadeTransition1.setAutoReverse(true);
        fadeTransition1.setCycleCount(1);
        fadeTransition1.play();

        passwordTextField.setDisable(true);

        FadeTransition fadeTransition2 = new FadeTransition(Duration.millis(animationTime), passwordTextField);
        fadeTransition2.setFromValue(1.0);
        fadeTransition2.setToValue(0);
        fadeTransition2.setAutoReverse(true);
        fadeTransition2.setCycleCount(1);
        fadeTransition2.play();

        confirmPasswordTextField.setDisable(true);
        FadeTransition fadeTransition3 = new FadeTransition(Duration.millis(animationTime), confirmPasswordTextField);
        fadeTransition3.setFromValue(1.0);
        fadeTransition3.setToValue(0);
        fadeTransition3.setAutoReverse(true);
        fadeTransition3.setCycleCount(1);
        fadeTransition3.play();

        confirmPasswordLabel.setDisable(true);
        FadeTransition fadeTransition4 = new FadeTransition(Duration.millis(animationTime), confirmPasswordLabel);
        fadeTransition4.setFromValue(1.0);
        fadeTransition4.setToValue(0);
        fadeTransition4.setAutoReverse(true);
        fadeTransition4.setCycleCount(1);
        fadeTransition4.play();

        passwordField.setDisable(false);
        passwordField.setVisible(true);
        passwordField.setLayoutX(usernameTextField.getLayoutX());
        passwordField.toFront();


        timeline = new Timeline();

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(animationTime),
                        new KeyValue(usernameTextField.layoutXProperty(),
                                usernameTextField.getLayoutX() - 80,
                                Interpolator.EASE_BOTH)));

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(animationTime),
                        new KeyValue(SignUpButton.layoutXProperty(),
                                recoverPasswordButton.getLayoutX() + 135,
                                Interpolator.EASE_BOTH)));

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(animationTime),
                        new KeyValue(SignUpButton.layoutYProperty(),
                                recoverPasswordButton.getLayoutY(),
                                Interpolator.EASE_BOTH)));

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(animationTime),
                        new KeyValue(passwordField.layoutXProperty(),
                                usernameTextField.getLayoutX() - 80,
                                Interpolator.EASE_BOTH)));



        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();

        timeline.setOnFinished(event -> {
            stage.setWidth(410);
            stage.setHeight(320);
            backGroundImage.setFitHeight(320);
            backGroundImage.setFitWidth(410);

            SignUpButton.setText("Sign up");

            SignUpButton.setOnAction(e -> {
                Object source = e.getSource();
                if (source instanceof Button) {
                    signUpPressed();
                }
            });

        });
    }

    private void changePane2SignUp(){

        stage = (Stage) usernameTextField.getScene().getWindow();
        stage.setWidth(490);
        stage.setHeight(500);

        backGroundImage.setFitHeight(500);
        backGroundImage.setFitWidth(490);








        passwordTextField = new TextField();
        passwordTextField.setEffect(passwordField.getEffect());
        passwordTextField.setLayoutX(passwordField.getLayoutX());
        passwordTextField.setLayoutY(passwordField.getLayoutY());
        passwordTextField.setPrefWidth(passwordField.getPrefWidth());

        confirmPasswordTextField = new TextField();
        confirmPasswordTextField.setEffect(passwordField.getEffect());
        confirmPasswordTextField.setLayoutX(passwordField.getLayoutX());
        confirmPasswordTextField.setLayoutY(passwordField.getLayoutY() + (passwordField.getLayoutY()- usernameTextField.getLayoutY()));
        confirmPasswordTextField.setPrefWidth(passwordField.getPrefWidth());


        confirmPasswordLabel = new Label("Confirm Password:");
        confirmPasswordLabel.setEffect(passwordLabel.getEffect());
        confirmPasswordLabel.setFont(passwordLabel.getFont());
        confirmPasswordLabel.setLayoutX(-100);
        confirmPasswordLabel.setLayoutY(passwordLabel.getLayoutY() + (passwordLabel.getLayoutY() - usernameLabel.getLayoutY() ) + 15);

        backButton = new Button("Back");
        backButton.setEffect(SignUpButton.getEffect());
        backButton.setLayoutX(SignUpButton.getLayoutX() + 20);
        backButton.setLayoutY(SignUpButton.getLayoutY() + 180);
        backButton.setStyle(SignUpButton.getStyle());
        backButton.setFont(SignUpButton.getFont());
        backButton.setOnAction(event1 -> backTostartMenu());

        mainPane.getChildren().addAll(backButton, confirmPasswordLabel,confirmPasswordTextField,passwordTextField);

        SignUpButton.setText("Register");

        SignUpButton.setOnAction(e -> {
            Object source = e.getSource();
            if (source instanceof Button) {
                register();
            }
        });

        timeline = new Timeline();


        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(animationTime),
                        new KeyValue(usernameTextField.layoutXProperty(),
                                usernameTextField.getLayoutX() + 80,
                                Interpolator.EASE_BOTH)));

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(animationTime),
                        new KeyValue(passwordTextField.layoutXProperty(),
                                usernameTextField.getLayoutX() + 80,
                                Interpolator.EASE_BOTH)));

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(animationTime),
                        new KeyValue(confirmPasswordTextField.layoutXProperty(),
                                usernameTextField.getLayoutX() + 80,
                                Interpolator.EASE_BOTH)));

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(animationTime),
                        new KeyValue(confirmPasswordLabel.layoutXProperty(),
                                passwordLabel.getLayoutX(),
                                Interpolator.EASE_BOTH)));

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(animationTime),
                        new KeyValue(SignUpButton.layoutXProperty(),
                                passwordTextField.getLayoutX()+ 210,
                                Interpolator.EASE_BOTH)));

        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(animationTime),
                        new KeyValue(SignUpButton.layoutYProperty(),
                                backButton.getLayoutY(),
                                Interpolator.EASE_BOTH)));


        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();




        signInButton.setDisable(true);
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(animationTime), signInButton);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(1);
        fadeTransition.setAutoReverse(false);
        fadeTransition.play();

        recoverPasswordButton.setDisable(true);
        FadeTransition fadeTransition1 = new FadeTransition(Duration.millis(700), recoverPasswordButton);
        fadeTransition1.setFromValue(1.0);
        fadeTransition1.setToValue(0);
        fadeTransition1.setAutoReverse(true);
        fadeTransition1.setCycleCount(1);
        fadeTransition1.play();

        passwordField.setDisable(true);
        passwordField.setVisible(false);

    }

}