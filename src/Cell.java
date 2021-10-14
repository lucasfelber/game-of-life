import java.util.ArrayList;

public class Cell {
    Sketch s;
    Grid grid;

    float pixelX, pixelY;
    int x, y;

    boolean state;

    public Cell(Sketch s, Grid grid, int x, int y){
        this.s = s;
        this.grid = grid;

        this.x = x;
        this.y = y;

        this.pixelX = x * grid.cellSize;
        this.pixelY = y * grid.cellSize;

        state = false;
    }

    public void show(){
        if(state){
            s.fill(0,255,0);
            s.rect(pixelX, pixelY, grid.cellSize, grid.cellSize);
        }
    }

    public int getNumberOfNeighbours(){
        int result = 0;
        for(int a = -1; a <= 1; a++){
            for(int b = -1; b <= 1; b++){
                try {
                    if (!(a == 0 && b == 0) && grid.cells[x + a][x + b] != null) {
                        if (grid.cells[x + a][x + b].state) {
                            result++;
                        }
                    }
                }catch(java.lang.ArrayIndexOutOfBoundsException ignored){
                }
            }
        }
        return result;
    }
}
