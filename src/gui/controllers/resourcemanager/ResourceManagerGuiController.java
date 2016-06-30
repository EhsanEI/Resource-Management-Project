package gui.controllers.resourcemanager;

import com.sun.org.apache.bcel.internal.generic.NEW;
import gui.controllers.MainMenuController;
import gui.controllers.iMainMenuController;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Created by qizilbash on 6/25/2016.
 */
public class ResourceManagerGuiController extends MainMenuController implements iMainMenuController {
    // permissions
    private MenuItem essentialResourceAllocationPrediction;
    private MenuItem newResourceRegisteration;
    private MenuItem resourceAllocationRegisteration;

    @FXML
    private AnchorPane ResourceAllocationPane;

    @FXML
    private AnchorPane RequirementViewPane;

    @FXML
    private AnchorPane AllocationRegistrationPane;

    @FXML
    private AnchorPane EssentialResourcesPredictionPane;

    // report menu
    private Menu reportsMenu;

    private MenuItem flowReport;
    private MenuItem requirementReport;
    private MenuItem resourceReport;


    @FXML
    private AnchorPane NewResourceRegistrationPane;

    @FXML
    private AnchorPane ResourceFlowPane;

    @FXML
    private AnchorPane ResourceRequirementPane;

    @FXML
    private AnchorPane ResourceReportPane;

    @FXML
    private AnchorPane emptyPane;

    @FXML
    private AnchorPane onTheTop;



    @FXML
    private void initialize(){
        onTheTop = emptyPane;
    }



    @Override
    public void initializeSpecifically() {

        //Permissions
        essentialResourceAllocationPrediction = new MenuItem("Predict Essential Resource Allocation");
        newResourceRegisteration = new MenuItem("Register New Resource");
        resourceAllocationRegisteration = new MenuItem("Register Resource Allocation");

        essentialResourceAllocationPrediction.setOnAction(event -> predictEssentialResource());

        newResourceRegisteration.setOnAction(event -> registerNewResource());

        resourceAllocationRegisteration.setOnAction(event -> registerResourceAllocation());

        permissionMenu.getItems().addAll(resourceAllocationRegisteration,newResourceRegisteration,essentialResourceAllocationPrediction);


        //Report Items
        reportsMenu = new Menu("Reports");
        flowReport = new MenuItem("Resource Allocation Flow");
        requirementReport = new MenuItem("Resource Requirements");
        resourceReport = new MenuItem("Resources");

        flowReport.setOnAction(event -> showResourceFlowPAne());
        requirementReport.setOnAction(event -> showRequirementPane());
        resourceReport.setOnAction(event -> showResourceReportPane());

        reportsMenu.getItems().addAll(resourceReport,requirementReport,flowReport);

        menuBar.getMenus().add(2,reportsMenu);
    }

    private void showResourceReportPane() {
        ResourceReportPane.setLayoutX(0);
        ResourceReportPane.setLayoutY(25);
        onTheTop.setLayoutX(1000);
        onTheTop = ResourceReportPane;
    }

    private void showRequirementPane() {
        ResourceRequirementPane.setLayoutX(0);
        ResourceRequirementPane.setLayoutY(25);
        onTheTop.setLayoutX(1000);
        onTheTop = ResourceRequirementPane;
    }

    private void showResourceFlowPAne() {
        ResourceFlowPane.setLayoutX(0);
        ResourceFlowPane.setLayoutY(25);
        onTheTop.setLayoutX(1000);
        onTheTop = ResourceFlowPane;
    }

    private void registerResourceAllocation() {
        ResourceAllocationPane.setLayoutX(0);
        ResourceAllocationPane.setLayoutY(25);
        onTheTop.setLayoutX(1000);
        onTheTop = ResourceAllocationPane;
    }


    private void predictEssentialResource() {
        EssentialResourcesPredictionPane.setLayoutX(0);
        EssentialResourcesPredictionPane.setLayoutY(25);
        onTheTop.setLayoutX(1000);
        onTheTop  = EssentialResourcesPredictionPane;
    }

    private void registerNewResource() {
        stage = (Stage) anchorPane.getScene().getWindow();
        NewResourceRegistrationPane.setLayoutX(0);
        NewResourceRegistrationPane.setLayoutY(25);
        onTheTop.setLayoutX(1000);
        onTheTop = NewResourceRegistrationPane;
    }

    public void registerResource(ActionEvent event) {
        System.out.println("register new resource pressed");
    }

    public void getResourceReportPressed(ActionEvent event) {
        System.out.println("get resource report pressed");
    }

    public void getRequirementReportPressed(ActionEvent event) {
        System.out.println("get requirement resource report pressed");
    }

    public void getFlowReportPressed(ActionEvent event) {
        System.out.println("get flow report pressed");
    }

    public void addSpecification(ActionEvent event) {
        System.out.println("add specification pressed");
    }

    public void viewRequirementPressed(ActionEvent event) {
        RequirementViewPane.setLayoutX(0);
        RequirementViewPane.setLayoutY(25);
        onTheTop.setLayoutX(1000);
        onTheTop = RequirementViewPane;
    }

    public void determineSituationPressed(ActionEvent event) {
        AllocationRegistrationPane.setLayoutX(0);
        AllocationRegistrationPane.setLayoutY(25);
        onTheTop.setLayoutX(1000);
        onTheTop = AllocationRegistrationPane;
    }

    public void viewRelatedResourcesPressed(ActionEvent event) {
        System.out.println("view related resource pressed");
    }

    public void backFromRequirmentView(Event event) {
        ResourceAllocationPane.setLayoutX(0);
        ResourceAllocationPane.setLayoutY(25);
        onTheTop.setLayoutX(1000);
        onTheTop = ResourceAllocationPane;
    }

    public void allocationRegisterPressed(ActionEvent event) {
        System.out.println("register allocation pressed");
    }

    public void backFromAllocationPane(Event event) {
        RequirementViewPane.setLayoutX(0);
        RequirementViewPane.setLayoutY(25);
        onTheTop.setLayoutX(1000);
        onTheTop = RequirementViewPane;
    }

    public void predictPressed(ActionEvent event) {
        System.out.println("predict button Pressed");
    }
}
