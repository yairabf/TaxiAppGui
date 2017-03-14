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
                grid.add(pane, i, j);
            }
        }
        windowPane.getChildren().add(grid);
            }

}

