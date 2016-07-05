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
public class ViewProfileViewController extends Controller{

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

        //TODO
        System.out.println(jobsInfo.getChildren().size());
        for(Tree<String> item : jobsInfo.getChildren())
            System.out.println(item.toString());


        ArrayList<TreeItem<String>> items = new ArrayList<>();



        for(Tree<String> info : jobsInfo.getChildren())
            items.add(new TreeItem<>(info.toString()));



        TreeItem<String> rootItem = new TreeItem<String> ("Inbox");
        rootItem.setExpanded(true);
        for (TreeItem<String> item : items) {
            TreeItem<String> treeItem = new TreeItem<>(item.toString());
            rootItem.getChildren().add(treeItem);
        }

        jobsInfoTreeView = new TreeView<String> (rootItem);

    }


}
