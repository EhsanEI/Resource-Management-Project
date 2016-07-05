package gui.controllers.projectmanager;


import businesslogic.distribution.requirement.RequirementPriorityEnum;
import gui.Direction;
import gui.controllers.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 * Created by qizilbash on 7/4/2016.
 */
public class AssignModuleController extends Controller {


    @FXML private AnchorPane assignPane;

    public void init(){

    }

    public void animate(){
        animatePaneChange(assignPane, Direction.RIGHT);
    }

    public void getModulesAndProgrammersPressed(ActionEvent event) {
    }

    public void assignModulePressed(ActionEvent event) {

    }
}
