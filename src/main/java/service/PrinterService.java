package service;

public class PrinterService {

    public void printGrid(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (char[] chars : grid) {
            for (char ch : chars) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
