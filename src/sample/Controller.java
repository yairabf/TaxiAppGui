package sample;

import javafx.beans.binding.Bindings;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Insets;
import javafx.scene.CacheHint;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class Controller {
    @FXML
    Button createButton;
    @FXML
    TextField widthText;
    @FXML
    TextField heightText;
    @FXML
    Pane windowPane;

    @FXML
    public void initialize() {
    createButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event){
            int h = Integer.parseInt(heightText.getText());
            int w = Integer.parseInt(widthText.getText());
            heightText.setVisible(false);
            widthText.setVisible(false);
            createButton.setVisible(false);
            CreateGrid(h,w);
            windowPane.setVisible(true);

//
        }

    });
    }
    private Pane[][] table;

    private void CreateGrid(int h, int w){
        GridPane grid = new GridPane();
        for (int i = 0; i < h; i++) {

            ColumnConstraints column = new ColumnConstraints(40);
            RowConstraints row = new RowConstraints(40);
            //grid.getRowConstraints().add(row);
            grid.getColumnConstraints().add(column);
            grid.setGridLinesVisible(true);
        }

        for (int i = 0; i < w; i++) {
            RowConstraints row = new RowConstraints(40);
            grid.getRowConstraints().add(row);
        }

        for(int i = 0; i < h; i++) {
            for(int j=0; j< w; j++) {
                Pane pane = new Pane();
                //pane.backgroundProperty().setValue(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
                //pane.getStyleClass().add("-fx-background-color: black, white; -fx-background-insets: 0,0,1,1,0;");
              /*  String image1 = JavaFXBuilderFactory.class.getResource("res/rodblock.jpg").toExternalForm();
                pane.setStyle("-fx-background-image: url('" + image1 + "'); " +
                        "-fx-background-position: center center; " +
                        "-fx-background-repeat: stretch;");*/
                grid.add(pane, i, j);
               // pane.setStyle("-fx-background-color: aqua");
                //Image image = new Image("/res/rodblock.jpg");
                //pane.setBackground(new Background(new BackgroundImage(image);

                //table[i][j] = pane;
            }
        }
        windowPane.getChildren().add(grid);

        /*double width = GridMaker.SCREEN_SIZE/w*h;
        Pane p = new Pane();

        Rectangle[][] rec = new Rectangle [h][w];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                rec[i][j] = new Rectangle();
                rec[i][j].setX(i * width);
                rec[i][j].setY(j * width);
                rec[i][j].setWidth(width);
                rec[i][j].setHeight(width);
                rec[i][j].setFill(null);
                rec[i][j].setStroke(Color.BLACK);
                p.getChildren().add(rec[i][j]);
*/
            }

}

