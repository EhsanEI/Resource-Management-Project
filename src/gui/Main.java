package gui;

import accounting.Job;
import accounting.User;
import com.sun.org.apache.regexp.internal.REUtil;
import distribution.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Esi on 5/20/2016.
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        User user = new User("ali", "alavi", new ArrayList<>());
        Job j = new Job("job", new ArrayList<>());
        j.addPermission("RegisterNewResource");
        user.addJob(j);

        String [] perms = user.getPermissions();

        StackPane root = new StackPane();

        if(Arrays.asList(perms).contains("RegisterNewResource")) {
            primaryStage.setTitle("Register New Resource");

            VBox types = new VBox();
            types.setSpacing(10);

            //type
            final ToggleGroup typeGroup = new ToggleGroup();

            RadioButton human = new RadioButton();
            human.setText("Human Resource");
            human.setUserData("Human Resource");
            human.setToggleGroup(typeGroup);
            types.getChildren().add(human);

            RadioButton physical = new RadioButton();
            physical.setText("Physical Resource");
            physical.setUserData("Physical Resource");
            physical.setToggleGroup(typeGroup);
            types.getChildren().add(physical);

            RadioButton financial = new RadioButton();
            financial.setText("Financial Resource");
            financial.setUserData("Financial Resource");
            financial.setToggleGroup(typeGroup);
            types.getChildren().add(financial);

            RadioButton information = new RadioButton();
            information.setText("Information Resource");
            information.setUserData("Information Resource");
            information.setToggleGroup(typeGroup);
            types.getChildren().add(information);

            //common attributes
            Label idLabel = new Label("ID");
            TextField idField = new TextField ();
            HBox idhb = new HBox();
            idhb.getChildren().addAll(idLabel, idField);
            idhb.setSpacing(10);

            VBox commonvb = new VBox();
            commonvb.setSpacing(10);
            commonvb.getChildren().addAll(idhb);

            //human attributes
            Label fnameLabel = new Label("First Name");
            TextField fnameField = new TextField ();
            HBox fnamehb = new HBox();
            fnamehb.getChildren().addAll(fnameLabel, fnameField);
            fnamehb.setSpacing(10);

            Label lnameLabel = new Label("Last Name");
            TextField lnameField = new TextField ();
            HBox lnamehb = new HBox();
            lnamehb.getChildren().addAll(lnameLabel, lnameField);
            lnamehb.setSpacing(10);

            VBox humanvb = new VBox();
            humanvb.setSpacing(10);
            humanvb.getChildren().addAll(fnamehb, lnamehb);
            humanvb.setVisible(false);

            //physical resource
            Label physnameLabel = new Label("Name");
            TextField physnameField = new TextField ();
            HBox physnamehb = new HBox();
            physnamehb.getChildren().addAll(physnameLabel, physnameField);
            physnamehb.setSpacing(10);

            VBox physvb = new VBox();
            physvb.setSpacing(10);
            physvb.getChildren().addAll(physnamehb);
            physvb.setVisible(false);

            //information resource
            Label infonameLabel = new Label("Name");
            TextField infonameField = new TextField ();
            HBox infonamehb = new HBox();
            infonamehb.getChildren().addAll(infonameLabel, infonameField);
            infonamehb.setSpacing(10);

            VBox infovb = new VBox();
            infovb.setSpacing(10);
            infovb.getChildren().addAll(infonamehb);
            infovb.setVisible(false);

            //financial resource
            Label finnameLabel = new Label("Name");
            TextField finnameField = new TextField ();
            HBox finnamehb = new HBox();
            finnamehb.getChildren().addAll(finnameLabel, finnameField);
            finnamehb.setSpacing(10);

            Label creditLabel = new Label("Credit");
            TextField creditField = new TextField ();
            HBox credithb = new HBox();
            credithb.getChildren().addAll(creditLabel, creditField);
            credithb.setSpacing(10);

            VBox finvb = new VBox();
            finvb.setSpacing(10);
            finvb.getChildren().addAll(finnamehb, credithb);
            finvb.setVisible(false);

            typeGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
                public void changed(ObservableValue<? extends Toggle> ov,
                                    Toggle old_toggle, Toggle new_toggle) {
                    if (typeGroup.getSelectedToggle() != null) {
                                String userData = typeGroup.getSelectedToggle().getUserData().toString();
                                switch (userData) {
                                    case "Human Resource":
                                        humanvb.setVisible(true);
                                        physvb.setVisible(false);
                                        infovb.setVisible(false);
                                        finvb.setVisible(false);
                                        break;
                                    case "Physical Resource":
                                        humanvb.setVisible(false);
                                        physvb.setVisible(true);
                                        infovb.setVisible(false);
                                        finvb.setVisible(false);
                                        break;
                                    case "Financial Resource":
                                        humanvb.setVisible(false);
                                        physvb.setVisible(false);
                                        infovb.setVisible(false);
                                        finvb.setVisible(true);
                                        break;
                                    case "Information Resource":
                                        humanvb.setVisible(false);
                                        physvb.setVisible(false);
                                        infovb.setVisible(true);
                                        finvb.setVisible(false);
                                        break;
                                }
                    }
                }
            });

            Button btn = new Button();
            btn.setText("Register Resource");
            btn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    if(typeGroup.getSelectedToggle() != null) {
                        Warehouse wh = Warehouse.getInstance();

                        int id = 0;
                        try {
                            id = new Integer(idField.getText()).intValue();
                        }catch(Exception ex) {
                            return;
                        }

                        if(wh.getResource(id) != null) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Duplicate Resource");
                            alert.setHeaderText(null);
                            alert.setContentText("There is a resource with the same ID in the warehouse!");
                            alert.showAndWait();
                            return;
                        }

                        String userData = typeGroup.getSelectedToggle().getUserData().toString();

                        switch (userData) {
                            case "Human Resource":
                                String firstName = fnameField.getText();
                                String lastName = lnameField.getText();
                                Job job = new Job("Employee", new ArrayList<>());

                                ArrayList<Job> jobs = new ArrayList<>();
                                jobs.add(job);
                                User user = new User(firstName, lastName, jobs);
                                HumanResource hr = new HumanResource(user, null, id);
                                wh.addResource(hr);
                                break;
                            case "Physical Resource":
                                String physname = physnameField.getText();
                                PhysicalResource pr = new PhysicalResource(physname, null, id);
                                wh.addResource(pr);
                                break;
                            case "Financial Resource":
                                String finname = finnameField.getText();

                                int credit = 0;
                                try {
                                    credit = new Integer(creditField.getText()).intValue();
                                }catch(Exception ex) {
                                    return;
                                }

                                FinancialResource fr = new FinancialResource(credit, finname, id);
                                wh.addResource(fr);
                                break;
                            case "Information Resource":
                                String infoname = infonameField.getText();

                                InformationResource ir = new InformationResource(infoname, null, id);
                                wh.addResource(ir);
                                break;
                        }
                    }
                }
            });

            StackPane separatesp = new StackPane();
            separatesp.getChildren().addAll(humanvb, physvb, infovb, finvb);

            VBox vb = new VBox();
            vb.setSpacing(10);
            vb.getChildren().addAll(types, commonvb, separatesp, btn);
            root.getChildren().add(vb);
        }

        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }
}