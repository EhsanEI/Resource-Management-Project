package gui.controllers.resourcemanager;

import businesslogic.ClientResourceManagerLogicFacade;
import businesslogic.distribution.Allocation;
import businesslogic.distribution.Allocation_DAO;
import businesslogic.distribution.requirement.Requirement;
import businesslogic.distribution.requirement.RequirementDAO;
import businesslogic.distribution.requirement.RequirementPriorityEnum;
import businesslogic.distribution.resource.Resource;
import gui.Direction;
import gui.controllers.Controller;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class ResourceAllocationView extends Controller{

    private Alert alert;

    private ArrayList<Requirement> requirements = new ArrayList<>();
    private Requirement selectedRequirement;

    @FXML private AnchorPane resourceAllocationPane;
    @FXML private AnchorPane requirementViewPane;

    @FXML private ListView<String> requirementsListView;
    @FXML private ListView<String> requirementSpecificationListView;
    @FXML private ListView<String> relatedResourcesNamesListView;

    @FXML private void initialize(){
        onTheTopPane = resourceAllocationPane;

        // TODO
        //Requirement[] requirements = clientResourceManagerLogicFacade.getRequirements(user.getID());
        Requirement requirement = RequirementDAO.createRequirement();
        requirement.setStartDate("4/4/73");
        requirement.setEndDate("4/3/76");
        requirement.setQuantity(2);
        requirement.setResourceName("printer");
        requirement.setResourceType("PhysicalResource");
        requirement.setRequirementPriority(RequirementPriorityEnum.ORDINARY.ordinal());
        requirements.add(requirement);

        for(Requirement item : requirements)
            requirementsListView.getItems().add(getRequirementString(item));

        alert = new Alert(Alert.AlertType.INFORMATION);
    }

    @FXML private void acceptAllocationButtonPressed(ActionEvent event) throws IOException {
        if(relatedResourcesNamesListView.getSelectionModel().getSelectedItems().size() == 0){
            resourceAllocationPane.setDisable(true);
            alert.setContentText("Please select at least animate resource to allocation");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                resourceAllocationPane.setDisable(false);
                return;
            }
        }

        ArrayList<Resource> allocatedResources = new ArrayList<>();

        //TODO
        //Resource[] resources = clientResourceManagerLogicFacade.getResources(user.getID(),selectedRequirement.getResourceType(),selectedRequirement.getResourceName());
        Resource[] resources = {};
        for(String item : relatedResourcesNamesListView.getSelectionModel().getSelectedItems())
            for (Resource resource : resources)
                if(getResourceString(resource) == item)
                    allocatedResources.add(resource);

        Allocation allocation = Allocation_DAO.createAllocation_();
        allocation.setRequirement(selectedRequirement);
        allocation.addResources(allocatedResources.toArray(new Resource[allocatedResources.size()]));

        //TODO
        //ClientResourceManagerLogicFacade.getInstance().registerResourceAllocation(user.getID(), allocation, allocatedResources.toArray(new Resource[allocatedResources.size()]));
    }

    @FXML private void rejectAllocationButtonPressed(ActionEvent event) {
        //clientResourceManagerLogicFacade.rejectAllocation(user.getID(), selectedRequirementToAllocation);
    }

    @FXML private void backFromRequirmentView(Event event) {
        animatePaneChange(resourceAllocationPane, Direction.LEFT);
    }

    @FXML private void viewRequirementPressed(ActionEvent event) {

        if(requirementsListView.getSelectionModel().getSelectedItem() == null){
            requirementViewPane.setDisable(true);
            alert.setContentText("Please select animate requirement");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                requirementViewPane.setDisable(false);
                return;
            }
        }

        String requirement = requirementsListView.getSelectionModel().getSelectedItem();
        for ( Requirement item : requirements)
            if(requirement.equals(getRequirementString(item)))
                selectedRequirement = item;


        requirementSpecificationListView.getItems().removeAll(requirementSpecificationListView.getItems());

        requirementSpecificationListView.getItems().addAll(
                "ID : " + String.valueOf(selectedRequirement.getID()),
                "Name : " + String.valueOf(selectedRequirement.getResourceName()),
                "Resource Type : " + String.valueOf(selectedRequirement.getResourceType()),
                "Start Date : " + String.valueOf(selectedRequirement.getStartDate()),
                "End Date : " + String.valueOf(selectedRequirement.getEndDate()),
                "Quantity : " + selectedRequirement.getQuantity(),
                "Information Resource : " + " "
        );

        //TODO
        //Resource[] resources = clientResourceManagerLogicFacade.getResources(user.getID(),selectedRequirement.getResourceType(),selectedRequirement.getResourceName());
        relatedResourcesNamesListView.getItems().removeAll(relatedResourcesNamesListView.getItems());
        Resource[] resources = {};
        for (Resource resource : resources)
            relatedResourcesNamesListView.getItems().add(getResourceString(resource));

        animatePaneChange(requirementViewPane, Direction.RIGHT);
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
