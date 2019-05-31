import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javafx.scene.layout.StackPane;
import javafx.animation.AnimationTimer;
import javafx.scene.shape.Box;


public class Main extends Application implements EventHandler<KeyEvent> {

    final int TARGET_FPS = 60;
    final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

    final int WIDTH = 800;
    final int HEIGHT = 980;

    double carVelocity = 0;
    Random r = new Random();
    ArrayList<Car> cars = new ArrayList<>();
    public static void main(String[] args) {
        launch(args);
    }

    Car car = null;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("cüneyt");

        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        car = new Car(WIDTH / 2, HEIGHT - 200, Color.rgb(153,0,0));


        for(int i = 0; i < 3; i++){
            Car c = new Car(r.nextInt(400-75) + 200, r.nextInt(980-150), Color.YELLOW);
            cars.add(c);
        }

        Land land = new Land();
        Road road = new Road();


        root.getChildren().addAll(land,road,car);
        root.getChildren().addAll(cars);






        final Box keyboardNode = new Box();
        keyboardNode.setFocusTraversable(true);
        keyboardNode.requestFocus();
        keyboardNode.setOnKeyPressed(this);

        root.getChildren().add(keyboardNode);

        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer animator = new AnimationTimer()
        {
            @Override
            public void handle(long arg0)
            {
                car.update();
                road.updateLines((int)carVelocity);
                land.updateTrees((int)carVelocity);
                updateCars((int)carVelocity);
                if(carVelocity > 0){
                    carVelocity -= 0.5;
                }
                car.setxVelocity(0);
                // render
            }
        };

        animator.start();
    }

    @Override
    public void handle(KeyEvent arg0) {

        if (arg0.getCode() == KeyCode.UP)
        {
            if(carVelocity < 20){
                carVelocity += 5;
            }

        }
        if(arg0.getCode() == KeyCode.RIGHT){
            car.setxVelocity(5);
        }
        if(arg0.getCode() == KeyCode.LEFT){
            car.setxVelocity(-5);
        }
    }

    public void updateCars(int vel){
        for(Car c : cars){
            if(c.getY() > 980){
                c.setY(r.nextInt(900)-1400);
                c.setX(r.nextInt(200-150) + -50);
                c.setTranslateY(c.getY());
                c.setTranslateX(c.getX());
            }
            c.setY(c.getY()+vel);
            c.setTranslateY(c.getY());
        }
    }


}
