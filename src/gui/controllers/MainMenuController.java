package gui.controllers;

import businesslogic.accounting.Permission;
import businesslogic.accounting.PermissionTitles;
import businesslogic.accounting.user.User;
import gui.StartMenu;
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
                        reportResourceAllocationMenuItem.setOnAction(event -> {
                            try {
                                loadFXML("../fxmls/resourcemanager/FlowReportView.fxml");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        reportMenu.getItems().add(reportResourceAllocationMenuItem);
                        break;
                    case "Resource Requirements Report":
                        MenuItem reportResourceRequirementMenuItem = new MenuItem(permission.getTitle());
                        reportResourceRequirementMenuItem.setOnAction(event -> {
                            try {
                                loadFXML("../fxmls/resourcemanager/ResourceRequirementsReportView.fxml");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        reportMenu.getItems().add(reportResourceRequirementMenuItem);
                        break;
                    case "Resources Report":
                        MenuItem reportResourcesMenuItem = new MenuItem(permission.getTitle());
                        reportResourcesMenuItem.setOnAction(event -> {
                            try {
                                loadFXML("../fxmls/resourcemanager/ResourceReportView.fxml");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
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
                    configureSystemMenuItem.setOnAction(event -> {
                        try {
                            loadFXML("../fxmls/admin/SystemConfigurationView.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

                    permissionMenu.getItems().add(configureSystemMenuItem);
                    break;
                case "Register Module Creation":
                    MenuItem createModuleMenuItem = new MenuItem(permission.getTitle());
                    createModuleMenuItem.setOnAction(event -> {
                        try {
                            loadFXML("../fxmls/programmer/ModuleCreationView.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    permissionMenu.getItems().add(createModuleMenuItem);
                    break;
                case "Register Module Maintenance":
                    MenuItem maintaneModuleMenuItem = new MenuItem(permission.getTitle());
                    maintaneModuleMenuItem.setOnAction(event -> {
                        try {
                            loadFXML("../fxmls/programmer/ModuleMaintenanceView.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    permissionMenu.getItems().add(maintaneModuleMenuItem);
                    break;
                case "Register Requirement":
                    MenuItem registerRequirementMenuItem = new MenuItem(permission.getTitle());
                    registerRequirementMenuItem.setOnAction(event -> {
                        try {
                            loadFXML("../fxmls/projectmanager/RegisterRequirementView.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    permissionMenu.getItems().add(registerRequirementMenuItem);
                    break;
                case "Assign Module":
                    MenuItem assignModuleMenuItem = new MenuItem(permission.getTitle());
                    assignModuleMenuItem.setOnAction(event -> {
                        try {
                            loadFXML("../fxmls/projectmanager/AssignModuleView.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    permissionMenu.getItems().add(assignModuleMenuItem);
                    break;
                case "Register Project Scale":
                    MenuItem registerProjectScaleMenuItem = new MenuItem(permission.getTitle());
                    registerProjectScaleMenuItem.setOnAction(event -> {
                        try {
                            loadFXML("../fxmls/projectmanager/RegisterProjectScaleView.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    permissionMenu.getItems().add(registerProjectScaleMenuItem);
                    break;
                case "Estimate Resource Allocations":
                    MenuItem estimateResourceAllocationsMenuItem = new MenuItem(permission.getTitle());
                    estimateResourceAllocationsMenuItem.setOnAction(event -> {
                        try {
                            loadFXML("../fxmls/projectmanager/EstimateResourceAllocationView.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    permissionMenu.getItems().add(estimateResourceAllocationsMenuItem);
                    break;
                case "Predict Essential Resource Allocation":
                    MenuItem predictEssentialResourceAllocationMenuItem = new MenuItem(permission.getTitle());
                    predictEssentialResourceAllocationMenuItem.setOnAction(event -> {
                        try {
                            loadFXML("../fxmls/resourcemanager/PredictEssentialResourceAllocationsView.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    permissionMenu.getItems().add(predictEssentialResourceAllocationMenuItem);
                    break;
                case "Register New Resource":
                    MenuItem registerNewResourceMenuItem = new MenuItem(permission.getTitle());
                    registerNewResourceMenuItem.setOnAction(event -> {
                        try {
                            loadFXML("../fxmls/resourcemanager/RegisterNewResourceView.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    permissionMenu.getItems().add(registerNewResourceMenuItem);
                    break;
                case "Register Resource Allocation":
                    MenuItem registerResourceAllocationMenuItem = new MenuItem(permission.getTitle());
                    registerResourceAllocationMenuItem.setOnAction(event -> {
                        try {
                            loadFXML("../fxmls/resourcemanager/ResourceAllocationView.fxml");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    permissionMenu.getItems().add(registerResourceAllocationMenuItem);
                    break;

            }

        menuBar.getMenus().add(permissionMenu);

    }


    private void loadFXML(String address) throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource(address));
        root = fxmlLoader.load();
        fxmlLoader.<Controller>getController().init(stage, user);
        fxmlLoader.<Controller>getController().animate();
        mainPane.getChildren().removeAll(mainPane.getChildren());
        mainPane.getChildren().add(root);
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
                loadFXML("../fxmls/accounting/ViewProfileView.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        editProfile = new MenuItem("Edit Profile");
        editProfile.setOnAction(event -> {
            try {
                loadFXML("../fxmls/accounting/EditProfileView.fxml");
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
            //TODO
            //ClientAccountingLogicFacade.getInstance().logout(user.getID());
            new StartMenu().start(stage);
        } else {
           mainPane.setDisable(false);
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
