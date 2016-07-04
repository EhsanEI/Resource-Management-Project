package gui.controllers;

import businesslogic.accounting.Permission;
import businesslogic.accounting.PermissionTitles;
import businesslogic.accounting.user.User;
import com.sun.deploy.perf.PerfRollup;
import gui.StartMenu;
import gui.controllers.accounting.HelpViewController;
import gui.controllers.accounting.ProfileEditController;
import gui.controllers.accounting.ProfileViewController;
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


import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by qizilbash on 6/25/2016.
 */

public class MainMenuController {

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

    @FXML private AnchorPane systemConfigurationPane;

    @FXML private AnchorPane moduleMaintenancePane;
    @FXML private AnchorPane moduleCreationPane;

    @FXML private AnchorPane essentialResourcesPredictionPane;


    @FXML private AnchorPane allocationRegistrationPane;
    @FXML private AnchorPane requirementViewPane;
    @FXML private AnchorPane resourceAllocationPane;
    @FXML private AnchorPane resourceReportPane;
    @FXML private AnchorPane resourceRequirementPane;
    @FXML private AnchorPane resourceFlowPane;
    @FXML private AnchorPane newResourceRegistrationPane;
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

    @FXML private void initialize(){
        onTheTopPane = emptyPane;
    }

    public void initializeView(){

        initializeProfileMenu();

        initializePermissionMenu();

        initializeHelpMenu();

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
                    reportResourceAllocationMenuItem.setOnAction(event -> reportResourceAllocationMenuItemSelected());
                    permissionMenu.getItems().add(reportResourceAllocationMenuItem);
                    break;
                case "Resource Requirements Report":
                    MenuItem reportResourcerequirementMenuItem = new MenuItem(permission.getTitle());
                    reportResourcerequirementMenuItem.setOnAction(event -> reportResourcerequirementMenuItemSelected());
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

    private void reportResourcesMenuItemSelected() {

    }

    private void reportResourcerequirementMenuItemSelected() {

    }

    private void reportResourceAllocationMenuItemSelected() {

    }

    private void registerResourceAllocationMenuItemSelected() {

    }

    private void registerNewResourceMenuItemSelected() {

    }

    private void predictEssentialResourceAllocationMenuItemSelected() {

    }

    private void estimateResourceAllocationsMenuItemSelected() {

    }

    private void registerProjectScaleMenuItemSelected() {

    }

    private void assignModuleMenuItemSelected() {

    }

    private void registerRequirementMenuItemSelected() {

    }

    private void maintaneModuleMenuItemSelected() {

    }

    private void createModuleMenuItemSelected() {

    }

    private void configureSystemSelected() {
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


    public void setUser(User user){
        this.user = user;
    }


    public void viewProfile() throws IOException {
        Stage viewProfileStage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxmls/accounting/ViewProfileGui.fxml"));
        Parent warningRoot = fxmlLoader.load();
        ProfileViewController controller = fxmlLoader.<ProfileViewController>getController();
        controller.setUser(user);


        viewProfileStage.getIcons().add(new Image(getClass().getResource("../resources/erp.png").toString()));
        viewProfileStage.setScene(new Scene(warningRoot,390,190));
        viewProfileStage.setTitle("Profile View");
        viewProfileStage.setResizable(false);
        viewProfileStage.show();


        viewProfileStage.setOnHiding(event -> rootPane.setDisable(false));

        rootPane.setDisable(true);
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
        Stage viewProfileStage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../fxmls/accounting/EditProfileGui.fxml"));
        Parent warningRoot = fxmlLoader.load();
        ProfileEditController controller = fxmlLoader.<ProfileEditController>getController();
        //controller.setUser(user);


        viewProfileStage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));
        viewProfileStage.setScene(new Scene(warningRoot,390,190));
        viewProfileStage.setTitle("Profile Edit");
        viewProfileStage.setResizable(false);
        viewProfileStage.show();



        viewProfileStage.setOnHiding(event -> rootPane.setDisable(false));

        rootPane.setDisable(true);
    }

    private void showAbout() throws IOException {
        Stage viewProfileStage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../fxmls/HelpGui.fxml"));
        Parent warningRoot = fxmlLoader.load();
        HelpViewController controller = fxmlLoader.<HelpViewController>getController();


        viewProfileStage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));
        viewProfileStage.setScene(new Scene(warningRoot,390,190));
        viewProfileStage.setTitle("Profile Edit");
        viewProfileStage.setResizable(false);
        viewProfileStage.show();



        viewProfileStage.setOnHiding(event -> rootPane.setDisable(false));

        rootPane.setDisable(true);
    }


    public void registerMaintenancePressed(ActionEvent event) {

    }

    public void addChangePressed(ActionEvent event) {

    }

    public void createModulePressed(ActionEvent event) {

    }

    public void predictPressed(ActionEvent event) {

    }

    public void allocationRegisterPressed(ActionEvent event) {

    }

    public void backFromAllocationPane(Event event) {
    }

    public void determineSituationPressed(ActionEvent event) {

    }

    public void viewRelatedResourcesPressed(ActionEvent event) {

    }

    public void backFromRequirmentView(Event event) {

    }

    public void viewRequirementPressed(ActionEvent event) {

    }

    public void getResourceReportPressed(ActionEvent event) {

    }

    public void getRequirementReportPressed(ActionEvent event) {

    }

    public void getFlowReportPressed(ActionEvent event) {

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

    public void configure(ActionEvent event) {

    }

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
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(onTheTopPane.layoutYProperty(),
                                    -1000,
                                    Interpolator.EASE_BOTH)));
        } else if(direction == Direction.DOWN){
            anchorPane.setLayoutX(0);
            anchorPane.setLayoutY(1000);

            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(anchorPane.layoutYProperty(),
                                    25,
                                    Interpolator.EASE_BOTH)));
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
}
