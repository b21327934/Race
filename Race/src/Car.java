import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;




public class Car extends Pane {


    public Rectangle car;
    private int x;
    private int y;
    private int xVelocity;
    private int yVelocity;

    public Car(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.xVelocity = 0;
        this.yVelocity = 0;

        car = new Rectangle(75, 150);

        car.setTranslateX(x);
        car.setTranslateY(y);
        car.setFill(c);
        getChildren().addAll(car);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public Rectangle getCar() {
        return car;
    }

    public void setCar(Rectangle car) {
        this.car = car;
    }

    public void update(){
        x = x + xVelocity;
        y = y + yVelocity;
        car.setTranslateX(x);
        car.setTranslateY(y);
    }

}
