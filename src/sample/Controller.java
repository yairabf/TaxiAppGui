package sample;

import javafx.beans.binding.Bindings;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Insets;
import javafx.scene.CacheHint;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.Random;

import java.util.ArrayList;


public class Controller {
    @FXML
    Button createButton;
    @FXML
    TextField widthText;
    @FXML
    TextField heightText;
    @FXML
    VBox center;
    @FXML
    BorderPane borderPane;

    @FXML
    HBox hBox;
    private Button sendButton = new Button("send");
    private TextField sendField = new TextField();

    private Button addButton = new Button("add");
    private TextField addField = new TextField();

    private TextField errorField = new TextField();

    private TextField timeField = new TextField("Time: 0");
    private int time = 0;

    private GridPane grid = new GridPane();
    
    private Pane[][] table;

    private ArrayList<Taxi> taxisList = new ArrayList<>();
    private int h;
    private int w;
    private int carId = 0;



    @FXML
    public void initialize() {
        //makes sure user cant change the time field
        timeField.setDisable(true);
        errorField.setStyle("-fx-text-fill: red");
    createButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event){
            h = GridSize.height;
            w = GridSize.width;
            hBox.getChildren().removeAll(createButton,heightText,widthText);
            CreateGrid(h,w);
            addField.setMaxWidth(100);
            errorField.setMaxWidth(100);
            sendField.setMaxWidth(100);
            timeField.setMaxWidth(100);
            hBox.getChildren().addAll(sendField,sendButton,addField,addButton,timeField, errorField);
        }

    });
    addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            int numberOfDrivers = Integer.parseInt(addField.getText());
            for(int i =  0; i < numberOfDrivers; i++) {
                Taxi taxi = new Taxi(carId, Color.color(Math.random(), Math.random(), Math.random()), 0, h-1);
                carId++;
                taxisList.add(taxi);
                grid.add(taxi.getPane(),0,h-1);
            }
            addField.clear();
        }
    });

    sendButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                time++;
                timeField.setText("Time: " + time);
                String input = sendField.getText();
                String[] parts = input.split(",");
                String movement = parts[1];
                int taxiId = Integer.parseInt(parts[0]);
                switch (movement) {
                    case "a":
                        moveLeft(taxiId);
                        break;
                    case "d":
                        moveRight(taxiId);
                        break;
                    case "w":
                        moveUp(taxiId);
                        break;
                    case "s" :
                        moveDown(taxiId);
                        break;
                    default:
                        errorField.setText("ERROR!!");
                        Task<Void> sleeper = new Task<Void>() {
                            @Override
                            protected Void call() throws Exception {
                                try {
                                    Thread.sleep(1500);
                                } catch (InterruptedException e) {
                                }
                                return null;
                            }
                        };
                        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                            @Override
                            public void handle(WorkerStateEvent event) {
                                errorField.clear();
                            }
                        });
                        new Thread(sleeper).start();
                        break;
                }

            }
        });
    }

    private void moveLeft(int taxiId) {
        Taxi taxi = taxisList.get(taxiId);
        if(taxi.getX() -1 < 0) {
            errorField.setText("ERROR!!");
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    errorField.clear();
                }
            });
            new Thread(sleeper).start();
        }
        else {
            grid.getChildren().remove(taxi.getPane());
            grid.add(taxi.getPane(), taxi.getX() - 1, taxi.getY());
            taxi.setX(taxi.getX() - 1);
        }
        sendField.clear();
    }

    private void moveRight(int taxiId) {
        Taxi taxi = taxisList.get(taxiId);
        if(taxi.getX() + 1 > w - 1) {
            errorField.setText("ERROR!!");
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    errorField.clear();
                }
            });
            new Thread(sleeper).start();
        }
        else {
            grid.getChildren().remove(taxi.getPane());
            grid.add(taxi.getPane(), taxi.getX() + 1, taxi.getY());
            taxi.setX(taxi.getX() + 1);
        }
        sendField.clear();
    }

    private void moveUp(int taxiId) {
        Taxi taxi = taxisList.get(taxiId);
        if(taxi.getY() -1 < 0) {
            errorField.setText("error");
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    errorField.clear();
                }
            });
            new Thread(sleeper).start();
        }
        else {
            grid.getChildren().remove(taxi.getPane());
            grid.add(taxi.getPane(),taxi.getX(), taxi.getY() - 1);
            taxi.setY(taxi.getY() - 1);
        }
        sendField.clear();
    }

    private void moveDown(int taxiId) {
        Taxi taxi = taxisList.get(taxiId);
        if(taxi.getY() + 1 > h - 1) {
            errorField.setText("error");
            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                    }
                    return null;
                }
            };
            sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    errorField.clear();
                }
            });
            new Thread(sleeper).start();
        }
        else {
            grid.getChildren().remove(taxi.getPane());
            grid.add(taxi.getPane(),taxi.getX(), taxi.getY() + 1);
            taxi.setY(taxi.getY() + 1);
        }
        sendField.clear();
    }

    private void CreateGrid(int h, int w){
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        for (int i = 0; i < h; i++) {
            ColumnConstraints column = new ColumnConstraints(50);
            RowConstraints row = new RowConstraints(50);
            grid.getColumnConstraints().add(column);
            grid.setGridLinesVisible(true);
        }

        for (int i = 0; i < w; i++) {
            RowConstraints row = new RowConstraints(50);
            grid.getRowConstraints().add(row);
        }

        for(int i = 0; i < h; i++) {
            for(int j=0; j< w; j++) {
                grid.setGridLinesVisible(true);
                Pane pane = new Pane();
                grid.add(pane, i, j);
            }
        }
        scrollPane.setContent(grid);
        center.getChildren().add(scrollPane);

    }

}

