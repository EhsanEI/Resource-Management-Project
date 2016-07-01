package gui.controllers.projectmanager;

import gui.controllers.MainMenuController;
import gui.controllers.iMainMenuController;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Created by qizilbash on 6/25/2016.
 */
public class ProjectManagerGuiController extends MainMenuController implements iMainMenuController {


    private MenuItem resourceAllocationsEstimate;
    private MenuItem moduleAssign;
    private MenuItem projectScaleRegistreation;
    private MenuItem requirementRegistreation;

    @FXML
    private AnchorPane initializeProjectPane;
    @FXML
    private AnchorPane systemAdditionPane;
    @FXML
    private AnchorPane subsystemAdditionPane;
    @FXML
    private AnchorPane modulesAdditionPane;
    @FXML
    private AnchorPane specialtyAdditionPane;

    @FXML
    private AnchorPane EstimateResourceAllocationPane;

    @FXML
    private AnchorPane EstimationPane;

    @FXML
    private AnchorPane ProjectSelectionToAssignPane;
    @FXML
    private AnchorPane ModuleAssignmentPane;

    @FXML
    private  AnchorPane RegisterRequirementPane;

    @FXML
    private AnchorPane SelectInformationResourcePane;

    @FXML
    private AnchorPane emptyPane;

    @FXML
    private void initialize(){
        onTheTopPane = emptyPane;
    }
    private AnchorPane onTheTopPane;


    @Override
    public void initializeSpecifically() {
        requirementRegistreation = new MenuItem("Register Requirement");

        moduleAssign = new MenuItem("Assign Module");

        projectScaleRegistreation = new MenuItem("Register Project Scale");

        resourceAllocationsEstimate = new MenuItem("Estimate Resource Allocations");


        requirementRegistreation.setOnAction(event -> registerRequirement());

        projectScaleRegistreation.setOnAction(event -> registerProjectScale());

        resourceAllocationsEstimate.setOnAction(event -> estimateResourceAllocations());

        moduleAssign.setOnAction(event -> assignModule());


        permissionMenu.getItems().addAll(requirementRegistreation,moduleAssign,projectScaleRegistreation,resourceAllocationsEstimate);
    }

    private void estimateResourceAllocations() {
        animatePaneChange(EstimateResourceAllocationPane, true);
    }



    private void assignModule() {
        animatePaneChange(ProjectSelectionToAssignPane, true);
    }


    private void registerRequirement() {
        animatePaneChange(SelectInformationResourcePane, true);
    }


    private void registerProjectScale() {
        animatePaneChange(initializeProjectPane, true);
    }




    public void initializeProjectPressed(ActionEvent event) {
        animatePaneChange(systemAdditionPane, true);

    }

    public void addSystemPressed(ActionEvent event) {
        System.out.println("add system pressed");
    }

    public void addSubsystemsPressed(ActionEvent event) {
        animatePaneChange(subsystemAdditionPane, true);
    }

    public void backFromSystem(Event event) {
        animatePaneChange(initializeProjectPane, false);
    }

    public void addSybsystemPressed(ActionEvent event) {
        System.out.println("add subsystem pressed");
    }

    public void addModulesPressed(ActionEvent event) {
        animatePaneChange(modulesAdditionPane, true);
    }

    public void backFromSubsystem(Event event) {
        animatePaneChange(systemAdditionPane, false);
    }

    public void addModulePressed(ActionEvent event) {
        System.out.println("add module pressed");
    }

    public void addSpecialtiesPressed(ActionEvent event) {
        animatePaneChange(specialtyAdditionPane, true);
    }

    public void backFromModules(Event event) {
        animatePaneChange(subsystemAdditionPane,false);
    }

    public void addSpecialtyPressed(ActionEvent event) {
        System.out.println("add specialty pressed");
    }


    public void backFromSpecialty(Event event) {
        animatePaneChange(modulesAdditionPane,false);
    }

    public void estimatePressed(ActionEvent event) {
        animatePaneChange(EstimationPane,true);
    }

    public void backFromEstimationResultPressed(Event event) {
        animatePaneChange(EstimateResourceAllocationPane,false);
    }

    public void assignModulePressed(ActionEvent event) {
        System.out.println("assign modle pressed");

    }

    public void backFromAssignmentPressed(Event event) {
        animatePaneChange(ProjectSelectionToAssignPane, false);
    }

    public void getModulesAndProgrammersPressed(ActionEvent event) {
        animatePaneChange(ModuleAssignmentPane, true);
    }

    public void RegisterRequirementPressed(ActionEvent event) {
        System.out.println("requirement register pressed");
    }

    public void RegisterARequirementPressed(ActionEvent event) {
        animatePaneChange(RegisterRequirementPane, true);
    }

    public void backFromReqisterRequirementPressed(Event event) {
        animatePaneChange(SelectInformationResourcePane, false);
    }

}
