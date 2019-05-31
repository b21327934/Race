import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Random;

public class Land extends Pane {

    Timeline timeline = new Timeline();
    int ScreenWidth=800;
    int ScreenHeight=980;
    Random r = new Random();

    public Rectangle line;
    private ArrayList<Circle> leftTrees;
    private ArrayList<Circle> rightTrees;

    public Land() {

        leftTrees = new ArrayList<>();
        rightTrees = new ArrayList<>();

        setStyle("-fx-background-color:rgb(59,148,45);");

        setMaxHeight(ScreenHeight);
        setMinHeight(ScreenHeight);
        setMaxWidth(ScreenWidth);
        setMinWidth(ScreenWidth);

        setTrees();

        for(Circle c : leftTrees){
            getChildren().add(c);
        }

        //getChildren().addAll(leftTrees.get(0));
    }

    private void setTrees(){
        for(int i = 0; i < 4; i++){
            Circle tree = new Circle();

            int x = r.nextInt(100) + 50;
            int y = (980 / 4) * (i + 1) - 100;
            tree.setCenterX(x);
            tree.setCenterY(y);
            tree.setRadius(40);
            tree.setFill(Color.DARKGREEN);
            leftTrees.add(tree);
        }
    }

    private void generateTree(){
        Circle tree = new Circle();

        int x = r.nextInt(100) + 50;

        tree.setCenterX(x);
        tree.setCenterY(0);
        tree.setRadius(40);
        tree.setFill(Color.DARKGREEN);
        leftTrees.add(tree);
    }

    public void updateTrees(int velocity){
        for(Circle c : leftTrees){
            if(c.getCenterY() > 980+40){
                c.setCenterY(-50);
                c.setCenterX(r.nextInt(100) + 50);
            }
            c.setCenterY(c.getCenterY() + velocity);
        }
    }


}