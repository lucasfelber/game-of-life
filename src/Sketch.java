import processing.core.PApplet;

public class Sketch extends PApplet {

    Grid grid;

    public void settings(){
        size(401,401);
        grid = new Grid(this, 20);
    }

    public void draw(){
        background(0);
        grid.show();
    }

    public static void main(String[] args){
        PApplet.main("Sketch");
    }
}
