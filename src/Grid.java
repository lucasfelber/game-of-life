public class Grid {
    Sketch s;

    int cellSize;

    Cell[][] cells;

    public Grid(Sketch s, int cellSize){
        this.s = s;
        this.cellSize = cellSize;

        cells = new Cell[s.width / cellSize][s.height / cellSize];

        for(int a = 0; a < s.width / cellSize; a++){
            for(int b = 0; b < s.height / cellSize; b++){
                cells[a][b] = new Cell(s, this, a, b);
            }
        }

        cells[2][1].state = true;
        cells[3][2].state = true;
        cells[3][3].state = true;
        cells[2][3].state = true;
        cells[1][3].state = true;
    }

    public void update(){
        for(Cell[] cellArr : cells){
            for(Cell cell : cellArr){
                cell.update();
            }
        }
    }

    public void show(){
        s.stroke(255);

        for(int i = 0; i <= s.width; i += cellSize){
            s.line(i, 0, i, s.height);
        }
        for(int i = 0; i <= s.height; i += cellSize){
            s.line(0, i, s.width, i);
        }

        for(Cell[] cellArr : cells){
            for(Cell cell : cellArr){
                cell.show();
            }
        }
    }
}
