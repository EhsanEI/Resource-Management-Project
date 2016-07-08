package gui.controllers.resourcemanager;

import businesslogic.ClientResourceManagerLogicFacade;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.resource.Project;
import businesslogic.utility.Tree;
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
import java.util.Optional;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class PredictEssentialResourceAllocationView extends Controller{

    @FXML private AnchorPane essentialResourcesPredictionPane;
    @FXML private AnchorPane predictionResultPane;
    @FXML private AnchorPane projectViewPane;
    @FXML private TreeView predictedProjectsTreeView;
    @FXML private TreeView projectsTreeView;
    @FXML private TreeView selectedProjectTreeView;


    private Project[] projects;
    private Project selectedProject;

    private Alert alert;

    public void animate(){
        animatePaneChange(essentialResourcesPredictionPane, Direction.RIGHT);
    }

    public void specialInit() throws IOException, ClassNotFoundException {
        projects = ClientResourceManagerLogicFacade.getInstance().getAllProjectList();

        TreeItem<String> rootItem = new TreeItem<>("Projects");


        for (Project project : projects){
            TreeItem<String> item = new TreeItem<>(project.getName());
            item.getChildren().add(new TreeItem<>("ID : " + project.getID()));
            item.getChildren().add(new TreeItem<>("Budget : " + project.getBudget()));
            rootItem.getChildren().addAll(item);
        }

        projectsTreeView.setRoot(rootItem);

        alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));
    }

    @FXML private void predictPressed(ActionEvent event) throws IOException, ClassNotFoundException {
        if(projectsTreeView.getSelectionModel().getSelectedItems().size() != 1){
            alert.setTitle("Invalid Selection");
            alert.setContentText("Please select just one project.");

            projectsTreeView.getScene().getRoot().setDisable(true);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                projectsTreeView.getScene().getRoot().setDisable(false);
                return;
            }

        }else{
            String name = (String)projectsTreeView.getSelectionModel().getSelectedItem();
            for(Project project : projects)
                if(project.getName().equals(name))
                    selectedProject = project;

            Project[] predictedProjects  = ClientResourceManagerLogicFacade.getInstance().predictEssentialResourceAllocations(selectedProject);

            TreeItem<String> rootItem = new TreeItem<>("Predicted Projects");

            for (Project project : predictedProjects){
                TreeItem<String> item = new TreeItem<>(project.getName());
                item.getChildren().add(new TreeItem<>("ID : " + project.getID()));
                item.getChildren().add(new TreeItem<>("Budget : " + project.getBudget()));
                rootItem.getChildren().addAll(item);
            }

            predictedProjectsTreeView.setRoot(rootItem);
            animatePaneChange(predictionResultPane,Direction.RIGHT);
        }
    }

    private String getProjectString(Project project){
        return project.getID() + project.getName();
    }

    @FXML private void backFromPrediction(Event event) {
        animatePaneChange(essentialResourcesPredictionPane,Direction.LEFT);
    }

    @FXML private void backFromProjectView(Event event) {
        animatePaneChange(predictionResultPane, Direction.LEFT);
    }

    @FXML private void viewProjectPressed(ActionEvent event) {
        if(predictedProjectsTreeView.getSelectionModel().getSelectedItems().size() != 1){
            alert.setTitle("Invalid Selection");
            alert.setContentText("Please select just one project.");

            projectsTreeView.getScene().getRoot().setDisable(true);

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                projectsTreeView.getScene().getRoot().setDisable(false);
                return;
            }

        }else {
            TreeItem<String> rootItem = new TreeItem<>(selectedProject.getName());

            rootItem.getChildren().addAll(
                    new TreeItem<>("ID : " + selectedProject.getID()),
                    new TreeItem<>("Budget : " + selectedProject.getBudget()),
                    new TreeItem<>("Unique Identifier : " + selectedProject.getUniqueIdentifier()));

            Requirement[] requirements = selectedProject.getRequirements();

            TreeItem<String> item = new TreeItem<>("Requirements");
            for(Requirement requirement : requirements){
                item.getChildren().addAll(
                        new TreeItem<>("ID : " + requirement.getID()),
                        new TreeItem<>("Resource Name :" + requirement.getResourceName()),
                        new TreeItem<>("Resource type : " + requirement.getResourceType()));
                rootItem.getChildren().addAll(item);
            }


            predictedProjectsTreeView.setRoot(rootItem);

            animatePaneChange(projectViewPane,Direction.RIGHT);

        }
    }
}
