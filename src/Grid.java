public class Grid {
    Sketch s;

    int cellSize;

    public Grid(Sketch s, int cellSize){
        this.s = s;
        this.cellSize = cellSize;
    }

    public void update(){
        //rect at ...
    }

    public void show(){
        s.stroke(255);
        for(int i = 0; i <= s.width; i += cellSize){
            s.line(i, 0, i, s.height);
        }
        for(int i = 0; i <= s.height; i += cellSize){
            s.line(0, i, s.width, i);
        }
    }
}
