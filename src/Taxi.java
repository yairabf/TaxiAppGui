
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Taxi {
    private int id;

    private Image image;

    private Color color;

    private int x = 0;
    private int y = 9;

    public Pane getPane() {
        //need to change the color setting
        return pane;
    }

    private Pane pane = new Pane();

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }



    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public Taxi(int i, Color c, int x1, int y1) {
        id = i;
        color = c;
        x = x1;
        y = y1;
        image = new Image(getClass().getClassLoader().getResourceAsStream(id+".jpeg"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        pane.getChildren().add(imageView);
    }

}
