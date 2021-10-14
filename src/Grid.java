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

        cells[0][0].state = true;
        cells[0][1].state = true;
        cells[0][2].state = true;
        cells[1][0].state = true;
        cells[1][1].state = true;
        cells[1][2].state = true;
        cells[2][0].state = true;
        cells[2][1].state = true;
        cells[2][2].state = true;

        for(Cell[] cellArray : cells){
            for(Cell cell : cellArray){
                cell.show();
            }
        }

        System.out.println(cells[0][0].getNumberOfNeighbours());
    }
}
