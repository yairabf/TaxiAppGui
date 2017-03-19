


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("resources/sample.fxml"));
        window.setTitle("TaxiApp");
        window.setScene(new Scene(root, 500, 500));
        window.show();
    }




    public static void main(String[] args) {
        GridSize gridSize = new GridSize();
        if (args.length > 0) {
            gridSize.height = Integer.parseInt(args[0]);
            gridSize.width = Integer.parseInt(args[1]);
        }
        launch(args);
    }
}
