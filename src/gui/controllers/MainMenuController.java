package gui.controllers;

import businesslogic.ClientAccountingLogicFacade;
import businesslogic.ClientResourceManagerLogicFacade;
import businesslogic.ServerProjectManagerLogicFacade;
import businesslogic.accounting.Permission;
import businesslogic.accounting.PermissionTitles;
import businesslogic.accounting.user.User;
import businesslogic.distribution.Allocation;
import businesslogic.distribution.Allocation_DAO;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.requirement.RequirementDAO;
import businesslogic.distribution.requirement.RequirementPriorityEnum;
import businesslogic.distribution.resource.ModuleDAO;
import businesslogic.distribution.resource.Resource;
import gui.StartMenu;
import gui.controllers.accounting.HelpViewController;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by qizilbash on 6/25/2016.
 */

public class MainMenuController {

    ClientAccountingLogicFacade clientAccountingLogicFacade;
    ClientResourceManagerLogicFacade clientResourceManagerLogicFacade;

    private User user;

    private double animationTime = 1000;

    private AnchorPane onTheTopPane;

    private Menu profileMenu;
    private MenuItem viewProfile;
    private MenuItem editProfile;
    private MenuItem signOut;

    private Menu permissionMenu;

    private Menu helpMenu;
    private MenuItem about;

    @FXML private AnchorPane rootPane;
    @FXML private AnchorPane emptyPane;
    @FXML private MenuBar menuBar;

    @FXML private AnchorPane profileEdittionPane;
    @FXML private AnchorPane profileViewPane;

    @FXML private AnchorPane systemConfigurationPane;

    @FXML private AnchorPane moduleMaintenancePane;
    @FXML private AnchorPane moduleCreationPane;

    @FXML private AnchorPane essentialResourcesPredictionPane;



    @FXML private AnchorPane requirementViewPane;
    @FXML private AnchorPane resourceAllocationPane;
    @FXML private AnchorPane resourcesReportPane;
    @FXML private AnchorPane resourceRequirementReportPane;
    @FXML private AnchorPane resourceFlowReportPane;
    @FXML private AnchorPane registerNewResourcePane;
    @FXML private AnchorPane registerRequirementPane;
    @FXML private AnchorPane selectInformationResourcePane;
    @FXML private AnchorPane moduleAssignmentPane;
    @FXML private AnchorPane projectSelectionToAssignPane;
    @FXML private AnchorPane estimationPane;
    @FXML private AnchorPane estimateResourceAllocationPane;
    @FXML private AnchorPane specialtyAdditionPane;
    @FXML private AnchorPane modulesAdditionPane;
    @FXML private AnchorPane subsystemAdditionPane;
    @FXML private AnchorPane systemAdditionPane;
    @FXML private AnchorPane initializeProjectPane;

    //resource allocation
    @FXML private ListView<String> requirementsListViewResourceAllocation;
    @FXML private ListView<String> requirementSpecifictionView;
    private Requirement[] requirements;
    private Requirement selectedRequirementToAllocation = null;
    @FXML private ListView<String> relatedResourcesNamesListView;



    private Alert informationAlert;



    @FXML private void initialize() throws IOException, ClassNotFoundException {
        onTheTopPane = emptyPane;
        clientAccountingLogicFacade = ClientAccountingLogicFacade.getInstance();
        clientResourceManagerLogicFacade = ClientResourceManagerLogicFacade.getInstance();

        informationAlert = new Alert(Alert.AlertType.INFORMATION);



        Stage stage = (Stage) informationAlert.getDialogPane().getScene().getWindow();

        stage.getIcons().add(new Image(getClass().getResource("../resources/erp.png").toString()));

    }

    public void initializeView(){

        initializeProfileMenu();

        initializePermissionMenu();

        initializeHelpMenu();

    }

    private void initializeProfileMenu() {
        profileMenu = new Menu("Profile");
        viewProfile = new MenuItem("View Profile");
        viewProfile.setOnAction(event -> {
            try {
                viewProfile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        editProfile = new MenuItem("Edit Profile");
        editProfile.setOnAction(event -> {
            try {
                editProfile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        signOut = new MenuItem("Sign Out");
        signOut.setOnAction(event -> {
            try {
                signOut();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        profileMenu.getItems().addAll(viewProfile,editProfile,signOut);

        menuBar.getMenus().add(profileMenu);
    }

    private void initializeHelpMenu() {
        helpMenu = new Menu("Help");
        about = new MenuItem("about");
        helpMenu.getItems().add(about);
        about.setOnAction(event -> {
            try {
                showAbout();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        menuBar.getMenus().add(helpMenu);
    }

    private void initializePermissionMenu() {
        permissionMenu = new Menu("Permissions");



        ////////////////////// Create a typical user ////////////////
       /* User user = new User();
        user.setUsername("qizilbash");
        user.setPassword("pass");
        user.setEmail("email");*/

        Permission permission1 = new Permission();
        permission1.setTitle(PermissionTitles.SYSTEM_CONFIGURATION.getTitleText());

        Permission permission2 = new Permission();
        permission2.setTitle(PermissionTitles.MODULE_CREATION.getTitleText());

        Permission permission3 = new Permission();
        permission3.setTitle(PermissionTitles.REQUIREMENT_REGISTRATION.getTitleText());

        Permission permission4 = new Permission();
        permission4.setTitle(PermissionTitles.NEW_RESOURCE_REGISTRATION.getTitleText());

/*
        user.addPermission(permission1);
        user.addPermission(permission2);
        user.addPermission(permission3);
        user.addPermission(permission4);

        user.setApproved(true);
*/
        ////////////////////////////////////////////////////////////

        ArrayList<Permission> permissionsList = new ArrayList<>();

        for(PermissionTitles title : PermissionTitles.values()){
            Permission permission = new Permission();
            permission.setTitle(title.getTitleText());
            permissionsList.add(permission);
        }


        Permission[] permissions = permissionsList.toArray(new Permission[permissionsList.size()]);

        for(Permission permission : permissions )
            switch (permission.getTitle()) {
                case "Configure System":
                    MenuItem configureSystemMenuItem = new MenuItem(permission.getTitle());
                    configureSystemMenuItem.setOnAction(event -> configureSystemSelected());
                    permissionMenu.getItems().add(configureSystemMenuItem);
                    break;
                case "Register Module Creation":
                    MenuItem createModuleMenuItem = new MenuItem(permission.getTitle());
                    createModuleMenuItem.setOnAction(event -> createModuleMenuItemSelected());
                    permissionMenu.getItems().add(createModuleMenuItem);
                    break;
                case "Register Module Maintenance":
                    MenuItem maintaneModuleMenuItem = new MenuItem(permission.getTitle());
                    maintaneModuleMenuItem.setOnAction(event -> maintaneModuleMenuItemSelected());
                    permissionMenu.getItems().add(maintaneModuleMenuItem);
                    break;
                case "Register Requirement":
                    MenuItem registerRequirementMenuItem = new MenuItem(permission.getTitle());
                    registerRequirementMenuItem.setOnAction(event -> registerRequirementMenuItemSelected());
                    permissionMenu.getItems().add(registerRequirementMenuItem);
                    break;
                case "Assign Module":
                    MenuItem assignModuleMenuItem = new MenuItem(permission.getTitle());
                    assignModuleMenuItem.setOnAction(event -> assignModuleMenuItemSelected());
                    permissionMenu.getItems().add(assignModuleMenuItem);
                    break;
                case "Register Project Scale":
                    MenuItem registerProjectScaleMenuItem = new MenuItem(permission.getTitle());
                    registerProjectScaleMenuItem.setOnAction(event -> registerProjectScaleMenuItemSelected());
                    permissionMenu.getItems().add(registerProjectScaleMenuItem);
                    break;
                case "Estimate Resource Allocations":
                    MenuItem estimateResourceAllocationsMenuItem = new MenuItem(permission.getTitle());
                    estimateResourceAllocationsMenuItem.setOnAction(event -> estimateResourceAllocationsMenuItemSelected());
                    permissionMenu.getItems().add(estimateResourceAllocationsMenuItem);
                    break;
                case "Predict Essential Resource Allocation":
                    MenuItem predictEssentialResourceAllocationMenuItem = new MenuItem(permission.getTitle());
                    predictEssentialResourceAllocationMenuItem.setOnAction(event -> predictEssentialResourceAllocationMenuItemSelected());
                    permissionMenu.getItems().add(predictEssentialResourceAllocationMenuItem);
                    break;
                case "Register New Resource":
                    MenuItem registerNewResourceMenuItem = new MenuItem(permission.getTitle());
                    registerNewResourceMenuItem.setOnAction(event -> registerNewResourceMenuItemSelected());
                    permissionMenu.getItems().add(registerNewResourceMenuItem);
                    break;
                case "Register Resource Allocation":
                    MenuItem registerResourceAllocationMenuItem = new MenuItem(permission.getTitle());
                    registerResourceAllocationMenuItem.setOnAction(event -> registerResourceAllocationMenuItemSelected());
                    permissionMenu.getItems().add(registerResourceAllocationMenuItem);
                    break;
                case "Resource Allocation Flow Report":
                    MenuItem reportResourceAllocationMenuItem = new MenuItem(permission.getTitle());
                    reportResourceAllocationMenuItem.setOnAction(event -> reportResourceAllocationFlowMenuItemSelected());
                    permissionMenu.getItems().add(reportResourceAllocationMenuItem);
                    break;
                case "Resource Requirements Report":
                    MenuItem reportResourcerequirementMenuItem = new MenuItem(permission.getTitle());
                    reportResourcerequirementMenuItem.setOnAction(event -> reportResourceRequirementMenuItemSelected());
                    permissionMenu.getItems().add(reportResourcerequirementMenuItem);
                    break;
                case "Resources Report":
                    MenuItem reportResourcesMenuItem = new MenuItem(permission.getTitle());
                    reportResourcesMenuItem.setOnAction(event -> reportResourcesMenuItemSelected());
                    permissionMenu.getItems().add(reportResourcesMenuItem);
                    break;
            }

        menuBar.getMenus().add(permissionMenu);

    }



    private void configureSystemSelected() {
        animatePaneChange(systemConfigurationPane, Direction.RIGHT);
    }


    private void maintaneModuleMenuItemSelected() {
        animatePaneChange(moduleMaintenancePane, Direction.RIGHT);
    }
    private void createModuleMenuItemSelected() {
        animatePaneChange(moduleCreationPane, Direction.RIGHT);
    }


    private void reportResourcesMenuItemSelected() {
        animatePaneChange(resourcesReportPane, Direction.RIGHT);
    }
    private void reportResourceRequirementMenuItemSelected() {
        animatePaneChange(resourceRequirementReportPane, Direction.RIGHT);
    }
    private void reportResourceAllocationFlowMenuItemSelected() {
        animatePaneChange(resourceFlowReportPane,Direction.RIGHT);
    }


    private void registerRequirementMenuItemSelected() {
        animatePaneChange(selectInformationResourcePane, Direction.RIGHT);
    }
    private void registerProjectScaleMenuItemSelected() {
        animatePaneChange(initializeProjectPane, Direction.RIGHT);
    }
    private void estimateResourceAllocationsMenuItemSelected() {
        animatePaneChange(estimateResourceAllocationPane, Direction.RIGHT);
    }
    private void assignModuleMenuItemSelected() {
        animatePaneChange(projectSelectionToAssignPane, Direction.RIGHT);
    }


    private void registerResourceAllocationMenuItemSelected() {

        Requirement requirement = RequirementDAO.createRequirement();
        requirement.setStartDate("4/4/73");
        requirement.setEndDate("4/3/76");
        requirement.setQuantity(2);
        requirement.setResourceName("printer");
        requirement.setResourceType("PhysicalResource");
        requirement.setRequirementPriority(RequirementPriorityEnum.ORDINARY.ordinal());

        // TODO
        //Requirement[] requirements = clientResourceManagerLogicFacade.getRequirements(user.getID());
        requirements[0]= requirement;

        requirementsListViewResourceAllocation.getItems().removeAll(requirementsListViewResourceAllocation.getItems());

        for(Requirement  item : requirements){
            requirementsListViewResourceAllocation.getItems().add(getRequirementString(item));
        }

        animatePaneChange(resourceAllocationPane, Direction.RIGHT);
    }
    private void registerNewResourceMenuItemSelected() {
        animatePaneChange(registerNewResourcePane, Direction.RIGHT);
    }
    private void predictEssentialResourceAllocationMenuItemSelected() {
        animatePaneChange(essentialResourcesPredictionPane, Direction.RIGHT);
    }




    public void viewProfile() throws IOException {
        animatePaneChange(profileViewPane, Direction.RIGHT);
    }
    public void signOut() throws Exception {
        rootPane.setDisable(true);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning!");
        alert.setContentText("Are you sure?");



        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

        stage.getIcons().add(new Image(getClass().getResource("../resources/erp.png").toString()));


        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            stage = (Stage) rootPane.getScene().getWindow();
            stage.close();
            new StartMenu().start(stage);
        } else {
            rootPane.setDisable(false);
        }


    }
    private void editProfile() throws IOException {
        animatePaneChange(profileEdittionPane, Direction.RIGHT);
    }
    private void showAbout() throws IOException {
        Stage viewProfileStage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxmls/HelpView.fxml"));
        Parent warningRoot = fxmlLoader.load();
        HelpViewController controller = fxmlLoader.<HelpViewController>getController();


        viewProfileStage.getIcons().add(new Image(getClass().getResource("../resources/erp.png").toString()));
        viewProfileStage.setScene(new Scene(warningRoot,390,240));
        viewProfileStage.setTitle("Profile Edit");
        viewProfileStage.setResizable(false);
        viewProfileStage.show();



        viewProfileStage.setOnHiding(event -> rootPane.setDisable(false));

        rootPane.setDisable(true);
    }


    public void setUser(User user){
        this.user = user;
    }


    /////////////////////////////////////////////////////////////////////////////////////
    public void configure(ActionEvent event) {

    }


    public void registerMaintenancePressed(ActionEvent event) {

    }
    public void createModulePressed(ActionEvent event) {

    }

    public void getResourceReportPressed(ActionEvent event) {

    }
    public void getRequirementReportPressed(ActionEvent event) {

    }
    public void getFlowReportPressed(ActionEvent event) {

    }



    public void addChangePressed(ActionEvent event) {

    }



    public void predictPressed(ActionEvent event) {

    }

    public void allocationRegisterPressed(ActionEvent event) {

    }

    public void backFromAllocationPane(Event event) {
    }

    public void acceptAllocationButtonPressed(ActionEvent event) {
        if(relatedResourcesNamesListView.getSelectionModel().getSelectedItems().size() == 0){
            rootPane.setDisable(true);
            informationAlert.setContentText("Please select at least a resource to allocation");
            Optional<ButtonType> result = informationAlert.showAndWait();
            if (result.get() == ButtonType.OK) {
                rootPane.setDisable(false);
                return;
            }
        }

        ArrayList<Resource> allocatedResources = new ArrayList<>();

        //Resource[] resources = clientResourceManagerLogicFacade.getResources(user.getID(),selectedRequirement.getResourceType(),selectedRequirement.getResourceName());
        Resource[] resources = {};
        for(String item : relatedResourcesNamesListView.getSelectionModel().getSelectedItems())
            for (Resource resource : resources)
                if(getResourceString(resource) == item)
                    allocatedResources.add(resource);

        Allocation allocation = Allocation_DAO.createAllocation_();
        allocation.setRequirement(selectedRequirementToAllocation);
        allocation.addResources(allocatedResources.toArray(new Resource[allocatedResources.size()]));

        clientResourceManagerLogicFacade.registerResourceAllocation(user.getID(), allocation, allocatedResources.toArray(new Resource[allocatedResources.size()]));
    }

    public void rejectAllocationButtonPressed(ActionEvent event) {
        //clientResourceManagerLogicFacade.rejectAllocation(user.getID(), selectedRequirementToAllocation);
    }
    public void backFromRequirmentView(Event event) {
        animatePaneChange(resourceAllocationPane, Direction.LEFT);
    }

    public void viewRequirementPressed(ActionEvent event) {
        if(requirementsListViewResourceAllocation.getSelectionModel().getSelectedItem() == null){
            rootPane.setDisable(true);
            informationAlert.setContentText("Please select a requirement");
            Optional<ButtonType> result = informationAlert.showAndWait();
            if (result.get() == ButtonType.OK) {
                rootPane.setDisable(false);
                return;
            }
        }

        Requirement selectedRequirement = null;
        String requirement = requirementsListViewResourceAllocation.getSelectionModel().getSelectedItem();
        for ( Requirement item : requirements)
            if(requirement.equals(getRequirementString(item)))
                selectedRequirement = item;


        requirementSpecifictionView.getItems().removeAll(requirementSpecifictionView.getItems());

        requirementSpecifictionView.getItems().addAll(
                "ID : " + String.valueOf(selectedRequirement.getID()),
                "Name : " + String.valueOf(selectedRequirement.getResourceName()),
                "Resource Type : " + String.valueOf(selectedRequirement.getResourceType()),
                "Start Date : " + String.valueOf(selectedRequirement.getStartDate()),
                "End Date : " + String.valueOf(selectedRequirement.getEndDate()),
                "Quantity : " + selectedRequirement.getQuantity(),
                "Information Resource : " + " "
        );

        //TODO
        relatedResourcesNamesListView.getItems().removeAll(relatedResourcesNamesListView.getItems());
        //Resource[] resources = clientResourceManagerLogicFacade.getResources(user.getID(),selectedRequirement.getResourceType(),selectedRequirement.getResourceName());
        Resource[] resources = {};
        for (Resource resource : resources)
            relatedResourcesNamesListView.getItems().add(getResourceString(resource));

        animatePaneChange(requirementViewPane, Direction.RIGHT);
    }

    public void registerResource(ActionEvent event) {

    }

    public void addSpecification(ActionEvent event) {

    }

    public void RegisterRequirementPressed(ActionEvent event) {

    }

    public void backFromReqisterRequirementPressed(Event event) {

    }

    public void RegisterARequirementPressed(ActionEvent event) {

    }

    public void assignModulePressed(ActionEvent event) {

    }

    public void backFromAssignmentPressed(Event event) {

    }

    public void getModulesAndProgrammersPressed(ActionEvent event) {

    }

    public void backFromEstimationResultPressed(Event event) {

    }

    public void estimatePressed(ActionEvent event) {

    }

    public void backFromSpecialty(Event event) {

    }

    public void addSpecialtyPressed(ActionEvent event) {

    }

    public void addModulePressed(ActionEvent event) {

    }

    public void addSpecialtiesPressed(ActionEvent event) {

    }

    public void backFromModules(Event event) {

    }

    public void addSybsystemPressed(ActionEvent event) {

    }

    public void addModulesPressed(ActionEvent event) {

    }

    public void backFromSubsystem(Event event) {

    }

    public void addSystemPressed(ActionEvent event) {

    }

    public void addSubsystemsPressed(ActionEvent event) {

    }

    public void backFromSystem(Event event) {

    }

    public void initializeProjectPressed(ActionEvent event) {
    }



    public void editProfileButtonPressed(ActionEvent event) {

    }
    //////////////////////////////////////////////////////////////////////////////////////////


    public void animatePaneChange(AnchorPane anchorPane, Direction direction){
        Timeline timeline = new Timeline();

        if(direction == Direction.TOP)
        {
            anchorPane.setLayoutX(0);
            anchorPane.setLayoutY(-1000);

            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(anchorPane.layoutYProperty(),
                                    25,
                                    Interpolator.EASE_BOTH)));
            if(!(onTheTopPane == anchorPane))
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(onTheTopPane.layoutYProperty(),
                                    1000,
                                    Interpolator.EASE_BOTH)));
        } else if(direction == Direction.RIGHT){
            anchorPane.setLayoutX(1000);
            anchorPane.setLayoutY(25);

            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(anchorPane.layoutXProperty(),
                                    0,
                                    Interpolator.EASE_BOTH)));
            if(!(onTheTopPane == anchorPane))
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(onTheTopPane.layoutYProperty(),
                                    1000,
                                    Interpolator.EASE_BOTH)));
        } else if(direction == Direction.DOWN){
            anchorPane.setLayoutX(0);
            anchorPane.setLayoutY(1000);

            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(anchorPane.layoutYProperty(),
                                    25,
                                    Interpolator.EASE_BOTH)));
            if(!(onTheTopPane == anchorPane))
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(onTheTopPane.layoutYProperty(),
                                    -1000,
                                    Interpolator.EASE_BOTH)));
        } else {
            anchorPane.setLayoutX(-1000);
            anchorPane.setLayoutY(25);

            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(anchorPane.layoutXProperty(),
                                    0,
                                    Interpolator.EASE_BOTH)));
            if(!(onTheTopPane == anchorPane))
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(onTheTopPane.layoutXProperty(),
                                    1000,
                                    Interpolator.EASE_BOTH)));
        }

        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();

        timeline.setOnFinished(event -> onTheTopPane = anchorPane);
    }

    private String getRequirementString(Requirement requirement){
        String result = "";
        result += "Name : " + requirement.getResourceName() + " --> Project : " ;
        //TODO
        //result +=  requirement.getInformationResource().getName();
        return result;
    }
    private String getResourceString(Resource resource) {
        String result = "";
        result += resource.getName() + " : " + resource.getResourceState();
        return result;
    }


}
