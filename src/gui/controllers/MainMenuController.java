package gui.controllers;

import businesslogic.accounting.Permission;
import businesslogic.accounting.PermissionTitles;
import businesslogic.accounting.user.User;
import gui.StartMenu;
import gui.controllers.accounting.EditProfileViewController;
import gui.controllers.accounting.ViewProfileViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class MainMenuController {

    private User user;
    private Stage stage;
    private Alert alert;
    private FXMLLoader fxmlLoader;
    private AnchorPane root;

    @FXML private AnchorPane mainPane;

    @FXML private MenuBar menuBar;
    private Menu profileMenu;
    private MenuItem viewProfile;
    private MenuItem editProfile;
    private MenuItem signOut;

    private Menu permissionMenu;

    private Menu reportMenu;

    private Menu helpMenu;
    private MenuItem about;



    //For Test
    private ArrayList<Permission> permissionsList = new ArrayList<>();

    private ViewProfileViewController viewProfileViewController;


    public void setUser(User user) {
        this.user = user;
    }


    public void initializeView() {
        initializeProfileMenu();
        initializePermissionMenu();
        initializeReportMenu();
        initializeHelpMenu();

        alert = new Alert(Alert.AlertType.CONFIRMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResource("../resources/erp.png").toString()));

    }


    private void initializeReportMenu() {
        //TODO
        // get user permissions and check she has report permission or not
        Permission[] permissions = permissionsList.toArray(new Permission[permissionsList.size()]);
        boolean isReportMenu = false;


        for( Permission permission : permissionsList)
            if(permission.getTitle() == PermissionTitles.RESOURCE_ALLOCATION_FLOW_REPORT.getTitleText() ||
                    permission.getTitle() == PermissionTitles.RESOURCE_REQUIREMENTS_REPORT.getTitleText() ||
                    permission.getTitle() == PermissionTitles.RESOURCES_REPORT.getTitleText())
                isReportMenu = true;

        if(isReportMenu){
            reportMenu = new Menu("Report");

            for(Permission permission : permissionsList )
                switch (permission.getTitle()) {
                    case "Resource Allocation Flow Report":
                        MenuItem reportResourceAllocationMenuItem = new MenuItem(permission.getTitle());
                        reportResourceAllocationMenuItem.setOnAction(event -> reportResourceAllocationFlowMenuItemSelected());
                        reportMenu.getItems().add(reportResourceAllocationMenuItem);
                        break;
                    case "Resource Requirements Report":
                        MenuItem reportResourcerequirementMenuItem = new MenuItem(permission.getTitle());
                        reportResourcerequirementMenuItem.setOnAction(event -> reportResourceRequirementMenuItemSelected());
                        reportMenu.getItems().add(reportResourcerequirementMenuItem);
                        break;
                    case "Resources Report":
                        MenuItem reportResourcesMenuItem = new MenuItem(permission.getTitle());
                        reportResourcesMenuItem.setOnAction(event -> reportResourcesMenuItemSelected());
                        reportMenu.getItems().add(reportResourcesMenuItem);
                        break;
                }

            menuBar.getMenus().add(reportMenu);
        }else
            return;

    }


    private void initializePermissionMenu() {
        permissionMenu = new Menu("Permissions");

        //TODO
        // get user permissions and generate based on that
        // For Test
        ////////////////////////////////////////////////////////////
        for(PermissionTitles title : PermissionTitles.values()){
            Permission permission = new Permission();
            permission.setTitle(title.getTitleText());
            permissionsList.add(permission);
        }

        Permission[] permissions = permissionsList.toArray(new Permission[permissionsList.size()]);
        ////////////////////////////////////////////////////////////

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
                    maintaneModuleMenuItem.setOnAction(event -> maintainModuleMenuItemSelected());
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
                    registerResourceAllocationMenuItem.setOnAction(event -> {
                        try {
                            registerResourceAllocationMenuItemSelected();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    permissionMenu.getItems().add(registerResourceAllocationMenuItem);
                    break;

            }

        menuBar.getMenus().add(permissionMenu);

    }


    private void reportResourcesMenuItemSelected() {

    }

    private void reportResourceRequirementMenuItemSelected() {

    }

    private void reportResourceAllocationFlowMenuItemSelected() {

    }


    private void registerResourceAllocationMenuItemSelected() throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxmls/resourcemanager/.fxml"));
        root = fxmlLoader.load();

        viewProfileViewController = fxmlLoader.<ViewProfileViewController>getController();
        viewProfileViewController.setStage(stage);
        viewProfileViewController.setUser(user);

        mainPane.getChildren().removeAll(mainPane.getChildren());
        mainPane.getChildren().add(root);
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

    private void maintainModuleMenuItemSelected() {

    }

    private void createModuleMenuItemSelected() {

    }

    private void configureSystemSelected() {

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

    private void showAbout() throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("../fxmls/HelpView.fxml"));
        Pane root = fxmlLoader.load();
        mainPane.getChildren().removeAll(mainPane.getChildren());
        mainPane.getChildren().add(root);
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

    private void signOut() throws Exception {
        mainPane.setDisable(true);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning!");
        alert.setContentText("Are you sure?");


        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            stage = (Stage) mainPane.getScene().getWindow();
            stage.close();
            //ClientAccountingLogicFacade.getInstance().logout(user.getID());
            new StartMenu().start(stage);
        } else {
           mainPane.setDisable(false);
        }
    }

    private void editProfile() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../fxmls/accounting/EditProfileView.fxml"));
        AnchorPane root = fxmlLoader.load();
        EditProfileViewController editProfileViewController = fxmlLoader.<EditProfileViewController>getController();
        editProfileViewController.setStage(stage);
        editProfileViewController.setUser(user);
        mainPane.getChildren().removeAll(mainPane.getChildren());
        mainPane.getChildren().add(root);
    }

    private void viewProfile() throws IOException {

        fxmlLoader = new FXMLLoader(getClass().getResource("../fxmls/accounting/ViewProfileView.fxml"));
        root = fxmlLoader.load();

        viewProfileViewController = fxmlLoader.<ViewProfileViewController>getController();
        viewProfileViewController.setStage(stage);
        viewProfileViewController.setUser(user);

        mainPane.getChildren().removeAll(mainPane.getChildren());
        mainPane.getChildren().add(root);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
