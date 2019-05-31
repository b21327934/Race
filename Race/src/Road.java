import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.*;

import java.util.ArrayList;


public class Road extends StackPane {

    int ScreenWidth=800;
    int ScreenHeight=980;
    public Rectangle car;
    ArrayList<Rectangle> lines;

    public Road() {
        lines = new ArrayList<>();
        Rectangle rectangle = new Rectangle( ScreenWidth/2, ScreenHeight);

        rectangle.setFill(Color.rgb(153, 153, 153));
        rectangle.setTranslateX(ScreenWidth/4);
        getChildren().addAll(rectangle);
        generateLines();
        getChildren().addAll(lines);

    }

    private void generateLines(){
        int y = -490+40;
        int count = 8;
        for(int i = 0; i < count; i++){
            Rectangle rectangle = new Rectangle( 20, 40);
            rectangle.setFill(Color.rgb(0,0,0));
            rectangle.setTranslateX(200);
            rectangle.setTranslateY(y);
            y += (980/count);
            lines.add(rectangle);
        }
    }

    public void updateLines(int velocity){
        for(Rectangle r : lines){
            r.setTranslateY(r.getTranslateY()+velocity);
            if(r.getTranslateY() > 490){
                r.setTranslateY(-450);
            }


        }
    }
}



