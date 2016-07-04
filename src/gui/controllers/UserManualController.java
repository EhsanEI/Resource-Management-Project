package gui.controllers;

import gui.Direction;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.jpedal.PdfDecoder;
import org.jpedal.exception.PdfException;

import java.awt.*;
import java.awt.image.BufferedImage;



/**
 * Created by qizilbash on 7/4/2016.
 */
public class UserManualController {

    @FXML private ImageView readingFrame;

    @FXML private Button perviousPageButton;
    @FXML private Button nextPageButton;

    private int currentPageNumber = 1;

    private double animationTime = 700;

    @FXML private AnchorPane userManualPane;
    private AnchorPane onTheTopPane;

    public void animate() {
        onTheTopPane = new AnchorPane();
        animatePaneChange(userManualPane, Direction.RIGHT);
    }

    public void init() throws PdfException {
/*
        PdfDecoder pdf = new PdfDecoder();
        pdf.openPdfFile("C:\\Users\\qizilbash\\Documents\\Java\\EnterpriseResourcePlannig\\Resource-Management-Project\\src\\gui\\controllers\\timing.pdf");
        showPage(currentPageNumber,  pdf);
        pdf.closePdfFile();
*/
    }

    private void animatePaneChange(AnchorPane anchorPane, Direction direction){
        Timeline timeline = new Timeline();

        if(direction == Direction.TOP)
        {
            anchorPane.setLayoutX(0);
            anchorPane.setLayoutY(-1000);

            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(anchorPane.layoutYProperty(),
                                    0,
                                    Interpolator.EASE_BOTH)));
            if(!(onTheTopPane == anchorPane))
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.millis(animationTime),
                                new KeyValue(onTheTopPane.layoutYProperty(),
                                        1000,
                                        Interpolator.EASE_BOTH)));
        } else if(direction == Direction.RIGHT){
            anchorPane.setLayoutX(1000);
            anchorPane.setLayoutY(0);

            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(anchorPane.layoutXProperty(),
                                    0,
                                    Interpolator.EASE_BOTH)));
            if(!(onTheTopPane == anchorPane))
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.millis(animationTime),
                                new KeyValue(onTheTopPane.layoutYProperty(),
                                        1000,
                                        Interpolator.EASE_BOTH)));
        } else if(direction == Direction.DOWN){
            anchorPane.setLayoutX(0);
            anchorPane.setLayoutY(1000);

            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(anchorPane.layoutYProperty(),
                                    0,
                                    Interpolator.EASE_BOTH)));
            if(!(onTheTopPane == anchorPane))
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.millis(animationTime),
                                new KeyValue(onTheTopPane.layoutYProperty(),
                                        -1000,
                                        Interpolator.EASE_BOTH)));
        } else {
            anchorPane.setLayoutX(-1000);
            anchorPane.setLayoutY(0);

            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis(animationTime),
                            new KeyValue(anchorPane.layoutXProperty(),
                                    0,
                                    Interpolator.EASE_BOTH)));
            if(!(onTheTopPane == anchorPane))
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.millis(animationTime),
                                new KeyValue(onTheTopPane.layoutXProperty(),
                                        1000,
                                        Interpolator.EASE_BOTH)));
        }

        timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();

        timeline.setOnFinished(event -> onTheTopPane = anchorPane);
    }

    public void nextPagePressed(ActionEvent event) {

    }

    public void perviousPageButtonPressed(ActionEvent event) {

    }


    private Image getPageAsImage(int page, int width, int height, PdfDecoder pdf) {

        BufferedImage img;
        try {
            img = pdf.getPageAsImage(page);



            //Use deprecated method since there's no real alternative
            //(for JavaFX 2.2+ can use SwingFXUtils instead).
            if (true)
                return javafx.scene.image.Image.impl_fromPlatformImage(img);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void showPage(int page, PdfDecoder pdf) {

        //Check in range
        if (page > pdf.getPageCount())
            return;
        if (page < 1)
            return;




        //Show/hide buttons as neccessary
        if (page == pdf.getPageCount())
            nextPageButton.setVisible(false);
        else
            nextPageButton.setVisible(true);

        if (page == 1)
            perviousPageButton.setVisible(false);
        else
            perviousPageButton.setVisible(true);


        //Calculate scale
        int pW = pdf.getPdfPageData().getCropBoxWidth(page);
        int pH = pdf.getPdfPageData().getCropBoxHeight(page);

        Dimension s = Toolkit.getDefaultToolkit().getScreenSize();

        s.width -= 100;
        s.height -= 100;

        double xScale = (double)s.width / pW;
        double yScale = (double)s.height / pH;
        double scale = xScale < yScale ? xScale : yScale;

        //Work out target size
        pW *= scale;
        pH *= scale;

        //Get image and set
        Image i = getPageAsImage(page,pW,pH,pdf);
        readingFrame.setImage(i);

        //Set size of components
        readingFrame.setFitWidth(pW);
        readingFrame.setFitHeight(pH);

    }

}
