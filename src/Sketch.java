import processing.core.PApplet;

public class Sketch extends PApplet {

    int[][] grid;
    int cols;
    int rows;
    int cellSize;

    public void settings() {
        size(600, 600);

        cellSize = 10;
        cols = width / cellSize;
        rows = height / cellSize;

        grid = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                grid[i][j] = floor(random(2));
            }
        }
    }

    public void draw(){
        background(0);

        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                int x = i * cellSize;
                int y = j * cellSize;
                if(grid[i][j] == 1){
                    fill(0,255,0);
                    stroke(0);
                    rect(x, y, cellSize - 1, cellSize - 1);
                }
            }
        }

        int[][] next = new int[cols][rows];

        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                int state = grid[i][j];

                int sum = 0;
                int neighbours = countNeighbours(grid, i, j);

                if(state == 0 && neighbours == 3){
                    next[i][j] = 1;
                }else if(state == 1 && (neighbours < 2 || neighbours > 3)){
                    next[i][j] = 0;
                }else{
                    next[i][j] = state;
                }
            }
        }
        grid = next;
    }

    public int countNeighbours(int[][] grid, int x, int y){
        int sum = 0;
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                int col = (x + i + cols) % cols;
                int row = (y + j + rows) % rows;
                sum += grid[col][row];
            }
        }
        sum -= grid[x][y];
        return sum;
    }

    public static void main(String[] args){
        PApplet.main("Sketch");
    }
}
