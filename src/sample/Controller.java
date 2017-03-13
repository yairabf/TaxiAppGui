package sample;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;


public class Controller {
    @FXML
    Button createButton;
    @FXML
    TextField widthText;
    @FXML
    TextField heightText;

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
//
        }

    });
    }

    private void CreateGrid(int h, int w){
        GridPane grid = new GridPane();
        for (int i = 0; i < h; i++) {
            ColumnConstraints column = new ColumnConstraints(40);
            grid.getColumnConstraints().add(column);
        }

        for (int i = 0; i < w; i++) {
            RowConstraints row = new RowConstraints(40);
            grid.getRowConstraints().add(row);
        }

        for(int i = 0; i < h; i++) {
            for(int j=0; j< w; j++) {
                Pane pane = new Pane();
                pane.getStyleClass().add("grid_cell");
                grid.add(pane, i, j);
            }
        }
    }

}

