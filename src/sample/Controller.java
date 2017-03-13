package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;



public class Controller {
    @FXML
    GridPane map;
    @FXML
    Button CreateButton;
@FXML
    public void initialize() {
    CreateButton.setOnMouseClicked();
    }
}

