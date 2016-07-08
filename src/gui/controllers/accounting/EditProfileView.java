package gui.controllers.accounting;

import businesslogic.ClientAccountingLogicFacade;
import businesslogic.ClientProgrammerLogicFacade;
import businesslogic.accounting.job.*;
import businesslogic.accounting.user.*;
import businesslogic.distribution.resource.Spec;
import businesslogic.utility.Notification;
import com.sun.org.apache.xalan.internal.xsltc.dom.NthIterator;
import gui.Direction;
import gui.controllers.Controller;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

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

        Job[] jobs = user.getJobs();
        for (Job job : jobs){
            if(Programming.class.isInstance(job)) {
                jobsListView.getItems().add(JobType.Programming.getTitle());
                addSpecialtyButton.setDisable(false);
                specialtiesListView.setDisable(false);
                Programming programming = (Programming)job;
                for (Specialty specialty : programming.getSpecialties())
                    specialtiesListView.getItems().addAll(specialty.getTitle());
            }else if(ProjectManagement.class.isInstance(job))
                jobsListView.getItems().add(JobType.ProjectManagement.getTitle());
            else
                jobsListView.getItems().add(JobType.ResourceManagement.getTitle());
        }
    }

    @FXML private void backFromSpecialtyAdditionPressed(Event event) {

        animatePaneChange(signUpPane, Direction.LEFT);

        specialtiesListView.getItems().clear();

        for(String specialty : specialtiesListViewInSpecialtyAddition.getItems())
            specialtiesListView.getItems().add(specialty);
    }

    @FXML private void singleSpecialtyAddButtonPressed(ActionEvent event) {
        Specialty specialty = new Specialty();
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
        if (jobTypeCombo.getValue().equals(JobType.Programming.getTitle()) && !jobsListViewInJobAddition.getItems().contains(jobTypeCombo.getValue())) {
            jobTitles.add(jobTypeCombo.getValue());
            jobsListViewInJobAddition.getItems().add(jobTypeCombo.getValue());
        } else if (jobTypeCombo.getValue().equals(JobType.ProjectManagement.getTitle())  && !jobsListViewInJobAddition.getItems().contains(jobTypeCombo.getValue())) {
            jobTitles.add(jobTypeCombo.getValue());
            jobsListViewInJobAddition.getItems().add(jobTypeCombo.getValue());
        }else if (jobTypeCombo.getValue().equals(JobType.ResourceManagement.getTitle())  && !jobsListViewInJobAddition.getItems().contains(jobTypeCombo.getValue())) {
            jobTitles.add(jobTypeCombo.getValue());
            jobsListViewInJobAddition.getItems().add(jobTypeCombo.getValue());
        }
    }

    @FXML private void addSpecialtyButtonPressed(ActionEvent event) {
        specialtiesListViewInSpecialtyAddition.getItems().clear();
        for(String item : specialtiesListView.getItems())
            specialtiesListViewInSpecialtyAddition.getItems().add(item);
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
        jobsListViewInJobAddition.getItems().clear();

        for(String item : jobsListView.getItems())
            jobsListViewInJobAddition.getItems().addAll(item);

        animatePaneChange(jobAdditionPane,Direction.RIGHT);
    }


    @FXML private void registerButtonPressed(ActionEvent event) throws IOException, ClassNotFoundException {
        User newUser = null;

        if(Admin.class.isInstance(user)){
            newUser = new Admin();
        }else if(Employee.class.isInstance(user)){
            newUser = new Employee();
        }else if(HighLevelManager.class.isInstance(user)){
            newUser = new HighLevelManager();
        }else if(MiddleLevelManager.class.isInstance(user)){
            newUser = new MiddleLevelManager();
        }


        newUser.setUsername(usernameTextField.getText());
        newUser.setPassword(passwordTextField.getText());
        newUser.setEmail(emailTextField.getText());


        ArrayList<Job> jobs = new ArrayList<>();

        for(String job : jobTitles){
            if(job == JobType.Programming.getTitle()){
                Programming programming= new Programming();
                for(Specialty specialty : specialties)
                    programming.addSpecialty(specialty);
                newUser.addJob(programming);
            }else if(job == JobType.ProjectManagement.getTitle()){
                newUser.addJob(new ProjectManagement());
            }else if(job == JobType.ResourceManagement.getTitle()){
                newUser.addJob(new ResourceManagement());
            }
        }

        newUser.setCreatorUser(user);
        Notification notification = ClientAccountingLogicFacade.getInstance().editProfile(newUser);

        alert.setTitle("Result");
        if(notification!=null)
            alert.setContentText(notification.getContent());
        else
            alert.setContentText("null notification");
    }

}
