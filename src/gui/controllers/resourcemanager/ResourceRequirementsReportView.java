package gui.controllers.resourcemanager;

import businesslogic.ClientResourceManagerLogicFacade;
import businesslogic.distribution.resource.InformationResource;
import businesslogic.report.Report;
import businesslogic.report.ResourceReport;
import businesslogic.report.ResourceRequirementReport;
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
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class ResourceRequirementsReportView extends Controller {

    @FXML private AnchorPane resourceRequirementReportPane;
    @FXML private ComboBox<String> informationResourceCombo;
    @FXML private TableView resultTable;
    private InformationResource[] informationResources;
    private InformationResource selectedInformationResource;

    private Alert alert;


    public void animate(){
        animatePaneChange(resourceRequirementReportPane, Direction.RIGHT);
    }
    public void specialInit() throws IOException, ClassNotFoundException {
        informationResources = ClientResourceManagerLogicFacade.getInstance().getInformationResources(user.getID());
        for(InformationResource informationResource : informationResources)
            informationResourceCombo.getItems().add(getInfoResourceString(informationResource));
        alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));
    }

    @FXML private void getRequirementReportPressed(ActionEvent event) throws IOException, ClassNotFoundException {
        if(!informationResourceCombo.getSelectionModel().getSelectedItem().isEmpty()){
            for(InformationResource informationResource : informationResources)
                if(getInfoResourceString(informationResource).equals(informationResourceCombo.getSelectionModel().getSelectedItem()))
                    selectedInformationResource = informationResource;

            showReport(ClientResourceManagerLogicFacade.getInstance().reportResourceRequirements(selectedInformationResource.getID()));
        }else {
            resultTable.getScene().getRoot().setDisable(true);
            alert.setTitle("Empty selection!");
            alert.setContentText("Please select an information resource");
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

    private String getInfoResourceString(InformationResource informationResource){
        return informationResource.getID() + informationResource.getName();
    }

}
