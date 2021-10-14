import processing.core.PApplet;

public class Sketch extends PApplet {
    public void settings(){
        size(400,400);
    }

    public void draw(){
        background(0);
        ellipse(mouseX, mouseY, 20, 20);
    }

    public static void main(String[] args){
        PApplet.main("Sketch");
    }
}
