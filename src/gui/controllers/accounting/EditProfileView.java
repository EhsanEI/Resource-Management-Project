package gui.controllers.accounting;

import businesslogic.accounting.job.JobType;
import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.job.SpecialtyDAO;
import businesslogic.accounting.user.User;
import businesslogic.accounting.user.UserType;
import gui.Direction;
import gui.controllers.Controller;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class EditProfileView extends Controller {


    private Alert alert;
    private ArrayList<Specialty> specialties = new ArrayList<>();
    private ArrayList<String> jobTitles = new ArrayList<>();

    @FXML private AnchorPane signUpPane;
    @FXML private AnchorPane specialtyAdditionPane;
    @FXML private AnchorPane jobAdditionPane;


    @FXML private TextField usernameTextField;
    @FXML private TextField passwordTextField;
    @FXML private TextField passwordConfirmationTextField;
    @FXML private TextField emailTextField;

    @FXML private ListView<String> jobsListView;
    @FXML private ListView<String> specialtiesListView;

    @FXML private ComboBox<String> jobTypeCombo;
    @FXML private ListView<String> jobsListViewInJobAddition;


    @FXML private TextField specialtyTitleTextField;
    @FXML private Slider proficiencyLevelSlider;
    @FXML private ListView<String> specialtiesListViewInSpecialtyAddition;
    @FXML private Button addSpecialtyButton;


    public void specialInit(){

        onTheTopPane = empptyPane;
        animatePaneChange(signUpPane,Direction.RIGHT);


        for(JobType jobType : JobType.values())
            jobTypeCombo.getItems().add(jobType.getTitle());


        addSpecialtyButton.setDisable(true);
        specialtiesListView.setDisable(true);

        fillProfile();

        alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));

    }

    private void fillProfile() {
        usernameTextField.setText(user.getUsername());
        emailTextField.setText(user.getEmail());
        passwordTextField.setText(user.getPassword());
        passwordConfirmationTextField.setText(user.getPassword());
    }

    @FXML private void backFromSpecialtyAdditionPressed(Event event) {

        animatePaneChange(signUpPane, Direction.LEFT);

        specialtiesListView.getItems().removeAll();

        for(String specialty : specialtiesListViewInSpecialtyAddition.getItems())
            specialtiesListView.getItems().add(specialty);
    }

    @FXML private void singleSpecialtyAddButtonPressed(ActionEvent event) {
        Specialty specialty = SpecialtyDAO.createSpecialty();
        specialty.setTitle(specialtyTitleTextField.getText());
        specialty.setProficiencyLevel((int)(proficiencyLevelSlider.getValue() / proficiencyLevelSlider.getMax() * 10));
        specialties.add(specialty);
        specialtiesListViewInSpecialtyAddition.getItems().add(specialty.getTitle());

    }

    @FXML private void backFromJobAdditionPressed(Event event) {
        animatePaneChange(signUpPane, Direction.LEFT);
        jobsListView.getItems().removeAll(jobsListView.getItems());

        for(String job : jobsListViewInJobAddition.getItems())
            jobsListView.getItems().add(job);

        if(!jobsListView.getItems().contains(JobType.Programming.getTitle())){
            addSpecialtyButton.setDisable(true);
            specialtiesListView.setDisable(true);
            specialtiesListView.getItems().removeAll(specialtiesListView.getItems());
            specialties.removeAll(specialties);
        }else {
            addSpecialtyButton.setDisable(false);
            specialtiesListView.setDisable(false);
        }
    }

    @FXML private void singleJobAddButtonPressed(ActionEvent event) {
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

    @FXML private void addSpecialtyButtonPressed(ActionEvent event) {
        animatePaneChange(specialtyAdditionPane,Direction.RIGHT);
    }

    @FXML private void singleJobRemoveButtonPressed(ActionEvent event) {
        String jobToRemove = null;
        for(String job : jobTitles)
            if(job == jobsListViewInJobAddition.getSelectionModel().getSelectedItem())
                jobToRemove = job;
        jobTitles.remove(jobToRemove);

        jobsListViewInJobAddition.getItems().remove(jobsListViewInJobAddition.getSelectionModel().getSelectedItem());
    }

    @FXML private void singleSpecialtyRemoveButtonPressed(ActionEvent event) {
        for(Specialty specialty : specialties)
            if(specialty.getTitle() == specialtiesListViewInSpecialtyAddition.getSelectionModel().getSelectedItem())
                specialties.remove(specialty.getTitle());
        specialtiesListViewInSpecialtyAddition.getItems().remove(specialtiesListViewInSpecialtyAddition.getSelectionModel().getSelectedItem());
    }

    @FXML private void addJobButtonPressed(ActionEvent event) {
        animatePaneChange(jobAdditionPane,Direction.RIGHT);
    }


    @FXML private void registerButtonPressed(ActionEvent event) {

    }
}
