package gui.controllers.projectmanager;

import gui.controllers.MainMenuController;
import gui.controllers.iMainMenuController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
        EstimateResourceAllocationPane.setLayoutX(0);
        EstimateResourceAllocationPane.setLayoutY(25);
        onTheTopPane.setLayoutX(0);
        onTheTopPane = EstimateResourceAllocationPane;

    }



    private void assignModule() {
        ProjectSelectionToAssignPane.setLayoutX(0);
        ProjectSelectionToAssignPane.setLayoutY(25);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = ProjectSelectionToAssignPane;

    }


    private void registerRequirement() {
        SelectInformationResourcePane.setLayoutX(0);
        SelectInformationResourcePane.setLayoutY(25);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = SelectInformationResourcePane;

    }


    private void registerProjectScale() {
        stage = (Stage) anchorPane.getScene().getWindow();
        initializeProjectPane.setLayoutY(25);
        initializeProjectPane.setLayoutX(0);
        onTheTopPane = initializeProjectPane;
    }




    public void initializeProjectPressed(ActionEvent event) {
        systemAdditionPane.setLayoutY(25);
        systemAdditionPane.setLayoutX(0);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = systemAdditionPane;

    }

    public void addSystemPressed(ActionEvent event) {
        System.out.println("add system pressed");

    }

    public void addSubsystemsPressed(ActionEvent event) {
        subsystemAdditionPane.setLayoutY(25);
        subsystemAdditionPane.setLayoutX(0);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = subsystemAdditionPane;
    }

    public void backFromSystem(Event event) {
        initializeProjectPane.setLayoutX(0);
        initializeProjectPane.setLayoutY(25);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = initializeProjectPane;
    }

    public void addSybsystemPressed(ActionEvent event) {
        System.out.println("add subsystem pressed");
    }

    public void addModulesPressed(ActionEvent event) {
        modulesAdditionPane.setLayoutX(0);
        modulesAdditionPane.setLayoutY(25);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = modulesAdditionPane;
    }

    public void backFromSubsystem(Event event) {
        systemAdditionPane.setLayoutX(0);
        systemAdditionPane.setLayoutY(25);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = systemAdditionPane;
    }

    public void addModulePressed(ActionEvent event) {
        System.out.println("add module pressed");
    }

    public void addSpecialtiesPressed(ActionEvent event) {
        specialtyAdditionPane.setLayoutX(0);
        specialtyAdditionPane.setLayoutY(25);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = specialtyAdditionPane;
    }

    public void backFromModules(Event event) {
        subsystemAdditionPane.setLayoutX(0);
        subsystemAdditionPane.setLayoutY(25);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = subsystemAdditionPane;
    }

    public void addSpecialtyPressed(ActionEvent event) {
        System.out.println("add specialty pressed");
    }


    public void backFromSpecialty(Event event) {
        modulesAdditionPane.setLayoutX(0);
        modulesAdditionPane.setLayoutY(25);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = modulesAdditionPane;
    }

    public void estimatePressed(ActionEvent event) {
        EstimationPane.setLayoutX(0);
        EstimationPane.setLayoutY(25);
        onTheTopPane.setLayoutX(0);
        onTheTopPane = EstimationPane;
    }

    public void backFromEstimationResultPressed(Event event) {
        EstimateResourceAllocationPane.setLayoutX(0);
        EstimateResourceAllocationPane.setLayoutY(25);
        onTheTopPane.setLayoutX(0);
        onTheTopPane = EstimateResourceAllocationPane;
    }

    public void assignModulePressed(ActionEvent event) {
        System.out.println("assign modle pressed");

    }

    public void backFromAssignmentPressed(Event event) {
        ProjectSelectionToAssignPane.setLayoutX(0);
        ProjectSelectionToAssignPane.setLayoutY(25);
        onTheTopPane.setLayoutX(10000);
        onTheTopPane = ProjectSelectionToAssignPane;

    }

    public void getModulesAndProgrammersPressed(ActionEvent event) {
        ModuleAssignmentPane.setLayoutX(0);
        ModuleAssignmentPane.setLayoutY(25);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = ModuleAssignmentPane;
    }

    public void RegisterRequirementPressed(ActionEvent event) {
        System.out.println("requirement register pressed");
    }

    public void RegisterARequirementPressed(ActionEvent event) {
        RegisterRequirementPane.setLayoutX(0);
        RegisterRequirementPane.setLayoutY(25);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = RegisterRequirementPane;
    }

    public void backFromReqisterRequirementPressed(Event event) {
        SelectInformationResourcePane.setLayoutX(0);
        SelectInformationResourcePane.setLayoutY(25);
        onTheTopPane.setLayoutX(1000);
        onTheTopPane = SelectInformationResourcePane;
    }
}
