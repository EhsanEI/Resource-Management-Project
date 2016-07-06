package gui.controllers.programmer;

import businesslogic.ClientModuleLogicFacade;
import businesslogic.ClientProgrammerLogicFacade;
import businesslogic.distribution.resource.Module;
import businesslogic.distribution.resource.ModuleChange;
import businesslogic.distribution.resource.ModuleChangeDAO;
import businesslogic.utility.Notification;

import gui.Direction;
import gui.controllers.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class ModuleMaintenanceController extends Controller {

    @FXML private AnchorPane moduleMaintenancePane;
    @FXML private ComboBox<String> modulesCombo;

    private Alert alert;

    @FXML private DatePicker startDate;
    @FXML private DatePicker endDate;

    private ArrayList<String> changes = new ArrayList<>();

    public void animate(){
        animatePaneChange(moduleMaintenancePane, Direction.RIGHT);
    }

    public void specialInit() throws IOException, ClassNotFoundException {
        Module[] modules = ClientModuleLogicFacade.getInstance().getModuleList(user.getID());
        if(modulesCombo.getItems().size() == 0)
            for (Module module : modules)
                modulesCombo.getItems().add(getModuleString(module));

        alert = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResource("../../resources/erp.png").toString()));
    }

    @FXML private void registerButtonPressed(ActionEvent event) throws IOException, ClassNotFoundException {
        Module selectedModule = null;
        String selectedItem = modulesCombo.getSelectionModel().getSelectedItem();

        for(Module module : ClientModuleLogicFacade.getInstance().getModuleList(user.getID()))
            if(selectedItem.equals(getModuleString(module)))
                selectedModule = module;

        Date sDate = new Date(startDate.getValue().toEpochDay());
        Date eDate = new Date(endDate.getValue().toEpochDay());
        businesslogic.utility.Date stDate = new businesslogic.utility.Date(sDate);
        businesslogic.utility.Date edDate = new businesslogic.utility.Date(eDate);

        ModuleChange[] moduleChanges = null;

        ModuleChange moduleChange = ModuleChangeDAO.createModuleChange();


        Notification notification = null;
        if( selectedModule !=null)
            ClientProgrammerLogicFacade.getInstance().registerModuleMaintenance(user.getID(),selectedModule.getID(),null);
    }

    @FXML private void addChangePressed(ActionEvent event) {
    }

    private String getModuleString( Module module){
        return String.valueOf(module.getID()) + " : " + module.getName();
    }
}
