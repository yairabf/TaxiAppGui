


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
        Parent root = FXMLLoader.load(ClassLoader.getSystemClassLoader().getResource("sample.fxml"));
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
