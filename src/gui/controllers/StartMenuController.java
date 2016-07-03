package gui.controllers;
/**
 * Created by qizilbash on 6/23/2016.
 */

import businesslogic.ClientAccountingLogicFacade;
import businesslogic.accounting.Permission;
import businesslogic.accounting.ResourceManagement;
import businesslogic.accounting.job.*;
import businesslogic.accounting.user.*;
import businesslogic.distribution.resource.HumanResource;
import businesslogic.distribution.resource.HumanResourceDAO;
import businesslogic.utility.Notification;
import gui.MainMenu;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
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

    private ArrayList<Specialty> specialties = new ArrayList<>();
    private ArrayList<String> jobTitles = new ArrayList<>();

    //add job fields
    @FXML private ComboBox<String> jobTypeCombo;
    @FXML private ListView<String> jobsListViewInJobAddition;

    // add specialty fields
    @FXML private TextField specialtyTitleTextField;
    @FXML private Slider proficiencyLevelSlider;
    @FXML private ListView<String> specialtiesListViewInspecialtyAddition;



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

        for(JobType jobType : JobType.values())
            jobTypeCombo.getItems().add(jobType.getTitle());

        for(UserType userType : UserType.values())
            userTypeCombo.getItems().add(userType.getTitle());


    }

    @FXML
    private void signInPressed() throws Exception {
        //User user = clientAccountingLogicFacade.login(usernameTextField.getText(), passwordField.getText()).getUser();
        User user = new User();
        user.addPermission(new Permission());

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

    public void registerButtonPressed(ActionEvent event) throws IOException, ClassNotFoundException {
        User user = null;
        ArrayList<Job> jobs = new ArrayList<>();

        String userType = userTypeCombo.getValue();

        if(userType == UserType.Admin.getTitle()){
            user = new Admin();
        }else if(userType == UserType.Emplpyee.getTitle()){
            user = new Employee();
        }else if(userType == UserType.HighLevelManager.getTitle()){
            user = new HighLevelManager();
        }else if(userType == UserType.MiddleLevelManager.getTitle()){
            user = new MiddleLevelManager();
        }

        user.setUsername(signupUsernameTextField.getText());
        if(!signupPasswordTextField.getText().equals( confirmationTextField.getText())){

            confirmationTextField.getScene().getRoot().setDisable(true);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Password Wrong!");
            alert.setContentText("Passwords texts dose not match!");
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

            stage.getIcons().add(new Image(getClass().getResource("../resources/erp.png").toString()));


            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                usernameTextField.getScene().getRoot().setDisable(false);
                return;
            }
        }
        user.setPassword(signupPasswordTextField.getText());
        user.setEmail(emailTextField.getText());

        HumanResource humanResource = HumanResourceDAO.createHumanResource();
        ArrayList<HumanResource> humanResources = new ArrayList<>();
        for(String job : jobTitles){
            if(job == JobType.Programming.getTitle()){
                Programming programming= new Programming();
                jobs.add(programming);
                humanResource.setProgramming(programming);
                humanResource.setName(signupUsernameTextField.getText());
                humanResource.setUniqueIdentifier("HumanResource_" + signupUsernameTextField.getText());
                humanResources.add(humanResource);
            }else if(job == JobType.ProjectManagement.getTitle()){
                jobs.add(new ProjectManagement());
            }else if(job == JobType.ResourceManagement.getTitle()){
                jobs.add(new ResourceManagement());
            }
        }

        // fields check
        if(signupUsernameTextField.getText().equals("") || signupPasswordTextField.getText().equals("")|| emailTextField.getText().equals(""))
        {
            confirmationTextField.getScene().getRoot().setDisable(true);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong Inputs!");
            System.out.println(user);
            if(signupUsernameTextField.getText().equals(""))
                alert.setContentText("Empty username!");
            else if( signupPasswordTextField.getText().equals(""))
                alert.setContentText("Empty password");
            else
                alert.setContentText("Empty email address!");

            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

            stage.getIcons().add(new Image(getClass().getResource("../resources/erp.png").toString()));


            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                usernameTextField.getScene().getRoot().setDisable(false);
                return;
            }
        }

/*
        Notification notification = clientAccountingLogicFacade.signup(user, jobs.toArray(new Job[jobs.size()]),
                specialties.toArray(new Specialty[specialties.size()]),
                humanResources.toArray(new HumanResource[humanResources.size()]));
*/

        Notification notification = new Notification("hi " + signupUsernameTextField.getText() + "!");

        signupPasswordTextField.getScene().getRoot().setDisable(true);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sign up notification");
        alert.setContentText(notification.getContent());
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

        stage.getIcons().add(new Image(getClass().getResource("../resources/erp.png").toString()));


        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK)
            signupUsernameTextField.getScene().getRoot().setDisable(false);

        backFromSignupButtonPressed(null);


    }


    public void backFromSpecialtyAdditionPressed(Event event) {

        animatePaneChange(signupPane,false);

        specialtiesListView.getItems().removeAll();

        for(String specialty : specialtiesListViewInspecialtyAddition.getItems())
            specialtiesListView.getItems().add(specialty);
    }

    public void singleSpecialtyAddButtonPressed(ActionEvent event) {
        Specialty specialty = SpecialtyDAO.createSpecialty();
        specialty.setTitle(specialtyTitleTextField.getText());
        specialty.setProficiencyLevel((int)(proficiencyLevelSlider.getValue() / proficiencyLevelSlider.getMax()));
        specialties.add(specialty);
        specialtiesListViewInspecialtyAddition.getItems().add(specialty.getTitle());

    }

    public void backFromJobAdditionPressed(Event event) {
        animatePaneChange(signupPane, false);
        jobsListView.getItems().removeAll();
        for(String job : jobsListViewInJobAddition.getItems())
            jobsListView.getItems().add(job);
    }

    public void singleJobAddButtonPressed(ActionEvent event) {
        if (jobTypeCombo.getValue() == JobType.Programming.getTitle() && !jobsListViewInJobAddition.getItems().contains(jobTypeCombo.getValue())) {
            jobTitles.add(jobTypeCombo.getValue());
            jobsListViewInJobAddition.getItems().add(jobTypeCombo.getValue());
        } else if (jobTypeCombo.getValue() == JobType.ProjectManagement.getTitle()  && !jobsListViewInJobAddition.getItems().contains(jobTypeCombo.getValue())) {
            jobTitles.add(jobTypeCombo.getValue());
            jobsListViewInJobAddition.getItems().add(jobTypeCombo.getValue());
        }else if (jobTypeCombo.getValue() == JobType.ResourceManagement.getTitle()  && !jobsListViewInJobAddition.getItems().contains(jobTypeCombo.getValue())) {
            jobTitles.add(jobTypeCombo.getValue());
            jobsListViewInJobAddition.getItems().add(jobTypeCombo.getValue());
        }
    }

    public void addSpecialtyButtonPressed(ActionEvent event) {
        animatePaneChange(specialtyAdditionPane,true);
    }

    public void addJobButtonPressed(ActionEvent event) {
        animatePaneChange(jobAdditionPane,true);
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

    public void singleJobRemoveButtonPressed(ActionEvent event) {
        for(String job : jobTitles)
            if(job == jobsListViewInJobAddition.getSelectionModel().getSelectedItem())
                jobTitles.remove(job);


        jobsListViewInJobAddition.getItems().remove(jobsListViewInJobAddition.getSelectionModel().getSelectedItem());
    }

    public void singleSpecialtyRemoveButtonPressed(ActionEvent event) {
        for(Specialty specialty : specialties)
            if(specialty.getTitle() == specialtiesListViewInspecialtyAddition.getSelectionModel().getSelectedItem())
                specialties.remove(specialty.getTitle());
        specialtiesListViewInspecialtyAddition.getItems().remove(specialtiesListViewInspecialtyAddition.getSelectionModel().getSelectedItem());
    }
}