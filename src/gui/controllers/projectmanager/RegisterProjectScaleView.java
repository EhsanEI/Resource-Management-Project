package gui.controllers.projectmanager;

import businesslogic.ClientProjectManagerLogicFacade;
import businesslogic.accounting.job.Specialty;
import businesslogic.accounting.job.SpecialtyDAO;
import businesslogic.distribution.resource.*;
import businesslogic.distribution.resource.System;
import businesslogic.utility.Date;
import businesslogic.utility.Notification;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.scenario.effect.impl.state.LinearConvolveRenderState;
import gui.Direction;
import gui.controllers.Controller;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class RegisterProjectScaleView extends Controller {

    @FXML private AnchorPane initializeProjectPane;
    @FXML private TextField projectNameTextField;
    @FXML private TextField projectBudgetTextField;
    @FXML private DatePicker projectStartDate;
    @FXML private DatePicker projectEndDate;
    @FXML private TextArea projectDescriptionTextArea;
    @FXML private TextField projectIDTextField;




    @FXML private AnchorPane systemAdditionPane;
    @FXML private TextField systemNameTextField;
    @FXML private TextField technologyTextField;
    @FXML private TextField systemIDTextField;





    @FXML private AnchorPane subsystemAdditionPane;
    @FXML private TextField subsystemNameTextField;
    @FXML private TextField subsystemIDTextField;
    @FXML private ListView<String> subsystemsListView;


    @FXML private AnchorPane modulesAdditionPane;
    @FXML private TextField moduleNameTextField;
    @FXML private TextField moduleIDTextField;
    @FXML private TextField locTextField;
    @FXML private DatePicker startDate;
    @FXML private DatePicker endDate;
    @FXML private ListView<String> modulesListView;




    @FXML private AnchorPane specialtyAdditionPane;
    @FXML private TextField specialtyNameTextField;
    @FXML private Slider proficiencyLevelSlider;
    @FXML private ListView<String>  specialtiesListView;









    @FXML private ListView<String> technologiesListView;
    @FXML private ListView<String> systemsListView;





    private Project project;
    private System system;
    private Subsystem subsystem;
    private Module module;
    private Specialty specialty;

    private ArrayList<System> systems = new ArrayList<>();
    private ArrayList<Subsystem> subsystems = new ArrayList<>();
    private ArrayList<Module> modules = new ArrayList<>();
    private ArrayList<Specialty> specialties = new ArrayList<>();

    private ArrayList<String> technologies = new ArrayList<>();

    private Alert alert;

    public void animate(){
        animatePaneChange(initializeProjectPane, Direction.RIGHT);
    }

    public void specialInit(){
        systems.clear();
        subsystems.clear();
        modules.clear();
        specialties.clear();
        technologies.clear();

        alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));
    }

    @FXML private void addTechnology(ActionEvent event) {
        if(technologyTextField.getText() != "")
            technologies.add(technologyTextField.getText());
        technologiesListView.getItems().add(technologyTextField.getText());
        technologyTextField.setText("");

    }

    @FXML private void addSystemPressed(ActionEvent event) {

        system = SystemDAO.createSystem();
        system.setName(systemNameTextField.getText());
        system.setUniqueIdentifier(systemIDTextField.getText());
        String technologiesString = "";
        for(String item : technologies)
            technologiesString += item + ", ";
        system.setTechnologies(technologiesString);
        for(Subsystem subsystem : subsystems)
            system.addSubsystem(subsystem);
        systems.add(system);

        systemsListView.getItems().add(getSystemString(system));
        systemNameTextField.setText("");
        systemIDTextField.setText("");
        technologies.clear();
        technologyTextField.setText("");
        technologiesListView.getItems().clear();
        subsystems.clear();

    }

    @FXML private void addSubsystemsPressed(ActionEvent event) {
        animatePaneChange(subsystemAdditionPane,Direction.RIGHT);
    }

    @FXML private void addSubsystemPressed(ActionEvent event) {
        subsystem = SubsystemDAO.createSubsystem();
        subsystem.setName(subsystemNameTextField.getText());
        subsystem.setUniqueIdentifier(subsystemIDTextField.getText());
        for(Module module : modules)
            subsystem.addModule(module);
        subsystemsListView.getItems().add(getSubsystemString(subsystem));
        subsystems.add(subsystem);

        modules.clear();
        subsystemNameTextField.clear();
        subsystemIDTextField.clear();
    }

    @FXML private void addModulesPressed(ActionEvent event) {
        animatePaneChange(modulesAdditionPane,Direction.RIGHT);
    }

    @FXML private void addModulePressed(ActionEvent event) {

        module = ModuleDAO.createModule();
        module.setName(moduleNameTextField.getText());

        java.util.Date sDate = new java.util.Date(startDate.getValue().toEpochDay());
        java.util.Date eDate = new java.util.Date(endDate.getValue().toEpochDay());
        businesslogic.utility.Date stDate = new businesslogic.utility.Date(sDate);
        businesslogic.utility.Date edDate = new businesslogic.utility.Date(eDate);

        module.setStartDate(stDate.toString());
        module.setEndDate(edDate.toString());
        try {
            module.setLinesOfCode(Integer.parseInt(locTextField.getText()));
        }catch (Exception e){

        }
        module.setUniqueIdentifier(moduleIDTextField.getText());

        for(Specialty specialty : specialties)
            module.addSpecialty(specialty);

        modules.add(module);
        modulesListView.getItems().add(getModulestring(module));
        specialties.clear();
        moduleNameTextField.clear();
        moduleIDTextField.clear();
        locTextField.clear();
    }

    @FXML private void addSpecialtiesPressed(ActionEvent event) {
        animatePaneChange(specialtyAdditionPane, Direction.RIGHT);
    }

    @FXML private void addSpecialtyPressed(ActionEvent event) {

        specialty = SpecialtyDAO.createSpecialty();
        specialty.setTitle(specialtyNameTextField.getText());
        specialty.setProficiencyLevel( (int)(proficiencyLevelSlider.getValue() / proficiencyLevelSlider.getMax() * 10));
        specialties.add(specialty);
        specialtiesListView.getItems().add(getSpecialtyString(specialty));
        specialtyNameTextField.clear();
    }

    @FXML private void backFromModules(Event event) {
        animatePaneChange(systemAdditionPane,Direction.LEFT);
    }

    @FXML private void backFromSpecialty(Event event) {
        animatePaneChange(modulesAdditionPane,Direction.LEFT);
    }

    @FXML private void backFromSubsystem(Event event) {
        animatePaneChange(systemAdditionPane,Direction.LEFT);
    }

    @FXML private void initializeProjectPressed(ActionEvent event) {
        animatePaneChange(systemAdditionPane,Direction.RIGHT);
    }

    @FXML private void backFromSystems(Event event) {
        animatePaneChange(initializeProjectPane,Direction.LEFT);
    }



    @FXML private void registerProjectPressed(ActionEvent event) throws IOException, ClassNotFoundException {


        project = ProjectDAO.createProject();
        project.setName(projectNameTextField.getText());
        project.setUniqueIdentifier(projectIDTextField.getText());
        try {
            project.setBudget(Integer.parseInt(projectBudgetTextField.getText()));
        }catch (Exception e){

        }

        for (System system : systems)
            project.addSystem(system);




        Notification notification = ClientProjectManagerLogicFacade.getInstance().registerProjectScale(
                user.getID(), project
        );


        initializeProjectPane.getScene().getRoot().setDisable(true);
        alert.setTitle("Result");
        if(notification!=null)
            alert.setContentText(notification.getContent());
        else
            alert.setContentText("Null Result");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            initializeProjectPane.getScene().getRoot().setDisable(false);
            return;
        }
    }


    private String getSystemString(System system){
        return system.getUniqueIdentifier() + " : " + system.getName();
    }

    private String getSubsystemString(Subsystem subsystem){
        return subsystem.getUniqueIdentifier() + " : " + subsystem.getName();
    }

    private String getModulestring(Module module){
        return module.getUniqueIdentifier() + " : " + module.getName();
    }
    private String getSpecialtyString(Specialty specialty){
        return specialty.getID() + " : " + specialty.getTitle();
    }

}
