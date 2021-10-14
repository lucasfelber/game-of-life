import processing.core.PApplet;

public class Sketch extends PApplet {

    Grid grid;

    public void settings() {
        size(401, 401);
    }

    public void setup(){
        grid = new Grid(this, 20);
        frameRate(1);
    }

    public void draw(){
        background(0);
        grid.update();
        grid.show();
    }

    public static void main(String[] args){
        PApplet.main("Sketch");
    }
}
