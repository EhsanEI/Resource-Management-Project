package gui.controllers.resourcemanager;

import com.sun.org.apache.bcel.internal.generic.NEW;
import gui.controllers.MainMenuController;
import gui.controllers.iMainMenuController;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Created by qizilbash on 6/25/2016.
 */
public class ResourceManagerGuiController extends MainMenuController implements iMainMenuController {


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
    private void initialize(){
        onTheTopPane = emptyPane;
    }

    @Override
    public void initializeSpecifically() {

        essentialResourceAllocationPrediction = new MenuItem("Predict Essential Resource Allocation");

        newResourceRegisteration = new MenuItem("Register New Resource");

        resourceAllocationRegisteration = new MenuItem("Register Resource Allocation");


        essentialResourceAllocationPrediction.setOnAction(event -> predictEssentialResource());

        newResourceRegisteration.setOnAction(event -> registerNewResource());

        resourceAllocationRegisteration.setOnAction(event -> registerResourceAllocation());


        permissionMenu.getItems().addAll(resourceAllocationRegisteration,newResourceRegisteration,essentialResourceAllocationPrediction);


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
        animatePaneChange(ResourceReportPane, true);
    }

    private void showRequirementPane() {
        animatePaneChange(ResourceRequirementPane, true);
    }

    private void showResourceFlowPAne() {
        animatePaneChange(ResourceFlowPane, true);
    }

    private void registerResourceAllocation() {
        animatePaneChange(ResourceAllocationPane, true);
    }


    private void predictEssentialResource() {
        animatePaneChange(EssentialResourcesPredictionPane, true);
    }

    private void registerNewResource() {
        animatePaneChange(NewResourceRegistrationPane, true);
    }

    public void registerResource(ActionEvent event) {
        System.out.println("register new resource pressed");
    }

    public void getResourceReportPressed(ActionEvent event) {
        System.out.println("get resource report pressed");
    }

    public void getRequirementReportPressed(ActionEvent event) { System.out.println("get requirement resource report pressed");
    }

    public void getFlowReportPressed(ActionEvent event) {
        System.out.println("get flow report pressed");
    }

    public void addSpecification(ActionEvent event) {
        System.out.println("add specification pressed");
    }

    public void viewRequirementPressed(ActionEvent event) {
        animatePaneChange(RequirementViewPane , true);
    }

    public void determineSituationPressed(ActionEvent event) {
        animatePaneChange(AllocationRegistrationPane, true);
    }

    public void viewRelatedResourcesPressed(ActionEvent event) {
        System.out.println("view related resource pressed");
    }

    public void backFromRequirmentView(Event event) {
        animatePaneChange(ResourceAllocationPane, false);
    }

    public void allocationRegisterPressed(ActionEvent event) {
        System.out.println("register allocation pressed");
    }

    public void backFromAllocationPane(Event event) {
        animatePaneChange(RequirementViewPane,false);
    }

    public void predictPressed(ActionEvent event) {
        System.out.println("predict button Pressed");
    }

}