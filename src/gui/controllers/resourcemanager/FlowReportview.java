package gui.controllers.resourcemanager;

import businesslogic.ClientResourceManagerLogicFacade;
import businesslogic.distribution.resource.Resource;
import businesslogic.distribution.resource.ResourceType;
import businesslogic.report.FlowReport;

import businesslogic.utility.Table;
import gui.Direction;
import gui.controllers.Controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class FlowReportview extends Controller {


    @FXML private AnchorPane resourceFlowReportPane;
    @FXML private DatePicker fromDate;
    @FXML private DatePicker toDate;

    @FXML private ComboBox<String> resourceNameCombo;
    @FXML private ComboBox<String> resourceTypeCombo;

    @FXML private TableView resultTable;

    private Alert alert;


    public void animate(){
        animatePaneChange(resourceFlowReportPane, Direction.RIGHT);
    }
    public void specialInit(){


        for (ResourceType type : ResourceType.values())
            resourceTypeCombo.getItems().add(type.getTitle());

        resourceTypeCombo.setOnAction(event -> {
            try {
                fillTheResourceNames();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));
    }

    private void fillTheResourceNames() throws IOException, ClassNotFoundException {
        String[] names = ClientResourceManagerLogicFacade.getInstance().getResourceNames(user.getID(), resourceTypeCombo.getSelectionModel().getSelectedItem());
        for(String name : names)
            resourceNameCombo.getItems().add(name);
    }

    public void getFlowReportPressed(ActionEvent event) throws IOException, ClassNotFoundException {

        if(resourceNameCombo.getSelectionModel().getSelectedItem() != null && resourceTypeCombo.getSelectionModel().getSelectedItem() != null){
            Resource[] resources = ClientResourceManagerLogicFacade.getInstance().getResources(user.getID(),
                    resourceTypeCombo.getSelectionModel().getSelectedItem(),
                    resourceNameCombo.getSelectionModel().getSelectedItem());

            Date sDate = new Date(fromDate.getValue().toEpochDay());
            Date eDate = new Date(toDate.getValue().toEpochDay());
            businesslogic.utility.Date startDate = new businesslogic.utility.Date(sDate);
            businesslogic.utility.Date endDate = new businesslogic.utility.Date(eDate);

            Table table = ClientResourceManagerLogicFacade.getInstance().reportFlowResourceAllocations(resources[0],
                    startDate,endDate);
            showReport(table);
        }else {
            resultTable.getScene().getRoot().setDisable(true);
            alert.setTitle("Empty selection!");
            alert.setContentText("Please select a resource type and/or resource name.");
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                resultTable.getScene().getRoot().setDisable(false);
                return;
            }
        }

    }

    private void showReport(Table table) {

        String[] headers = table.getHeaders();
        String[][] contents = table.getContents();


        ObservableList<String[]> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(contents));



        for (int i = 0; i < headers.length; i++) {
            TableColumn tc = new TableColumn(headers[i]);
            final int colNo = i;
            tc.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(TableColumn.CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo]));
                }
            });
            tc.setPrefWidth(resultTable.getPrefWidth()/headers.length);
            resultTable.getColumns().add(tc);
        }

        resultTable.setItems(data);

    }






}
