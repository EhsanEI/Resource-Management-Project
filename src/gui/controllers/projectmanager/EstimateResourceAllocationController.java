package gui.controllers.projectmanager;

import businesslogic.ClientProjectManagerLogicFacade;
import businesslogic.distribution.resource.InformationResource;
import businesslogic.utility.Date;
import gui.Direction;
import gui.controllers.Controller;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class EstimateResourceAllocationController extends Controller {

    @FXML private AnchorPane estimateResourceAllocationPane;
    @FXML private AnchorPane estimationPane;

    @FXML private DatePicker startDate;
    @FXML private DatePicker endDate;

    @FXML private TextField budgetTextField;
    @FXML private TextField technologyTextField;

    @FXML private ListView<String> technologiesListView;

    private InformationResource[] informationResources;



    public void estimatePressed(ActionEvent event) throws IOException {

        java.util.Date sDate = new java.util.Date(startDate.getValue().toEpochDay());
        java.util.Date eDate = new java.util.Date(endDate.getValue().toEpochDay());
        businesslogic.utility.Date stDate = new businesslogic.utility.Date(sDate);
        businesslogic.utility.Date edDate = new businesslogic.utility.Date(eDate);
        informationResources = ClientProjectManagerLogicFacade.getInstance().estimateResourceAllocations(
                technologiesListView.getItems().toArray(new String[technologiesListView.getItems().size()]),stDate,edDate,
                Integer.parseInt(budgetTextField.getText()));
        animatePaneChange(estimationPane, Direction.RIGHT);
        //TODO
        //show the InformationResources
    }

    public void backFromEstimationResultPressed(Event event) {
        animatePaneChange(estimateResourceAllocationPane,Direction.LEFT);
    }
}
