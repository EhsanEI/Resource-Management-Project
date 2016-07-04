package gui.controllers.resourcemanager;

import businesslogic.distribution.resource.Resource;
import businesslogic.distribution.resource.ResourceType;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import gui.controllers.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class RegisterNewResourceController extends Controller{

    @FXML private ComboBox<String> resourceTypeCombo;

    @FXML private void initialize() {
        for(ResourceType type : ResourceType.values())
            resourceTypeCombo.getItems().add(type.getTitle());
    }


    public void addSpecification(ActionEvent event) {

    }

    public void registerResource(ActionEvent event) {

    }
}
