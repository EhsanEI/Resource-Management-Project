package gui.controllers.resourcemanager;

import businesslogic.ClientResourceManagerLogicFacade;
import businesslogic.distribution.resource.Resource;
import businesslogic.distribution.resource.ResourceType;
import businesslogic.report.FlowReport;

import businesslogic.utility.Table;
import gui.controllers.Controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class FlowReportController extends Controller {

    @FXML private DatePicker fromDate;
    @FXML private DatePicker toDate;

    @FXML private ComboBox<String> resourceNameCombo;
    @FXML private ComboBox<String> resourceTypeCombo;

    @FXML private TableView resultTable;


    public void specialInit(){
        for (ResourceType type : ResourceType.values())
            resourceTypeCombo.getItems().add(type.getTitle());
        resourceTypeCombo.setOnAction(event -> {
            try {
                fillTheResourceNames();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void fillTheResourceNames() throws IOException {
        String[] names = ClientResourceManagerLogicFacade.getInstance().getResourceNames(user.getID(), resourceTypeCombo.getSelectionModel().getSelectedItem());
        for(String name : names)
            resourceNameCombo.getItems().add(name);
    }

    public void getFlowReportPressed(ActionEvent event) throws IOException {
       /*
        if(resourceNameCombo.getSelectionModel().getSelectedItem() != null && resourceTypeCombo.getSelectionModel().getSelectedItem() != null){
            Resource[] resources = ClientResourceManagerLogicFacade.getInstance().getResources(user.getID(),
                    resourceTypeCombo.getSelectionModel().getSelectedItem(),
                    resourceNameCombo.getSelectionModel().getSelectedItem());

            Date sDate = new Date(fromDate.getValue().toEpochDay());
            Date eDate = new Date(fromDate.getValue().toEpochDay());
            businesslogic.utility.Date startDate = new businesslogic.utility.Date(sDate);
            businesslogic.utility.Date endDate = new businesslogic.utility.Date(eDate);

            FlowReport flowReport = ClientResourceManagerLogicFacade.getInstance().reportFlowResourceAllocations(resources[0],
                    startDate,endDate);
            showReport(flowReport);
        }else {

        }
        */

        showReport(null);

    }

    private void showReport(FlowReport flowReport) {
        /*Table table = flowReport.getTable();

        String[] headers = table.getHeaders();
        String[][] contents = table.getContents();*/

        String[] headers = {"a", "b","c"};
        String[][] contents={{"a", "b","c"},{"a", "b","c"}};

        ArrayList<TableColumn> tableColumns = new ArrayList<>();

        resultTable.getColumns().removeAll(resultTable.getColumns());
        for(String header : headers)
            tableColumns.add(new TableColumn(header));





        for (TableColumn tableColumn : tableColumns)
            resultTable.getColumns().add(tableColumn);

        resultTable.setItems(getFormattedData(contents));
        resultTable.setVisible(true);










    }


    private ObservableList getFormattedData(String[][] contents) {
        ObservableList<String[]> data = FXCollections.observableArrayList();
        for(String[] row : contents)
            data.add(row);
        return data;
    }




}
