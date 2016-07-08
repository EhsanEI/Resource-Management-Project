package gui.controllers.accounting;

import businesslogic.accounting.user.User;
import businesslogic.utility.Tree;
import gui.Direction;
import gui.controllers.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

import javax.swing.event.AncestorEvent;
import java.util.ArrayList;


/**
 * Created by qizilbash on 7/4/2016.
 */
public class ViewProfileView extends Controller{

    @FXML private AnchorPane profileViewPane;

    @FXML private Label usernameLabel;
    @FXML private Label emailLabel;

    @FXML private TreeView<String> jobsInfoTreeView;

    public void animate(){
        animatePaneChange(profileViewPane, Direction.RIGHT);
    }

    public void specialInit(){
        usernameLabel.setText(user.getUsername());
        emailLabel.setText(user.getEmail());
        Tree<String> jobsInfo = user.getJobInfo();

        TreeItem<String> rootItem = new TreeItem<>("Jobs");

        for(Tree<String> child : jobsInfo.getChildren()){
            TreeItem<String> item = new TreeItem<>(child.toString());
            rootItem.getChildren().add(item);
        }

        jobsInfoTreeView.setRoot(rootItem);

    }


}
