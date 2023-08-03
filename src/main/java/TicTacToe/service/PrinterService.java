package TicTacToe.service;

public class PrinterService {

    public void printGrid(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
