package gui.controllers;

import gui.StartMenu;
import gui.controllers.accounting.ProfileEditController;
import gui.controllers.accounting.ProfileViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Optional;

/**
 * Created by qizilbash on 6/25/2016.
 */
public class MainMenuController {
    public int user;
    public Stage stage;


    public Menu profileMenu;
    public MenuItem viewProfile;
    public MenuItem editProfile;
    public MenuItem signOut;

    public Menu permissionMenu;

    public Menu helpMenu;
    public MenuItem about;

    @FXML
    public AnchorPane anchorPane;

    @FXML
    public MenuBar menuBar;

    public void initializeGenerally(){
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

        permissionMenu = new Menu("Permissions");

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

        menuBar.getMenus().addAll(profileMenu,permissionMenu,helpMenu);
    }

    public void setUser(int user){
        this.user = user;
    }

    public void viewProfile() throws IOException {
        Stage viewProfileStage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../fxmls/ViewProfileGui.fxml"));
        Parent warningRoot = fxmlLoader.load();
        ProfileViewController controller = fxmlLoader.<ProfileViewController>getController();
        controller.setUser(user);


        viewProfileStage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));
        viewProfileStage.setScene(new Scene(warningRoot,390,190));
        viewProfileStage.setTitle("Profile View");
        viewProfileStage.setResizable(false);
        viewProfileStage.show();



        viewProfileStage.setOnHiding(event -> anchorPane.setDisable(false));

        anchorPane.setDisable(true);
    }

    public void signOut() throws Exception {
        anchorPane.setDisable(true);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning!");
        alert.setContentText("Are you sure?");


        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

        stage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));


        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            stage = (Stage) anchorPane.getScene().getWindow();
            stage.close();
            new StartMenu().start(stage);
        } else {
            anchorPane.setDisable(false);
        }











    }

    private void editProfile() throws IOException {
        Stage viewProfileStage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../../fxmls/EditProfileGui.fxml"));
        Parent warningRoot = fxmlLoader.load();
        ProfileEditController controller = fxmlLoader.<ProfileEditController>getController();
        controller.setUser(user);


        viewProfileStage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));
        viewProfileStage.setScene(new Scene(warningRoot,390,190));
        viewProfileStage.setTitle("Profile Edit");
        viewProfileStage.setResizable(false);
        viewProfileStage.show();



        viewProfileStage.setOnHiding(event -> anchorPane.setDisable(false));

        anchorPane.setDisable(true);
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



        viewProfileStage.setOnHiding(event -> anchorPane.setDisable(false));

        anchorPane.setDisable(true);
    }

}
