package strategy;

public class DefaultWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWinCondition(char symbol, char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int matchSequence = 3;
        for(int i = 0; i <= rows-matchSequence; i++) {
            for(int j = 0; j <= cols-matchSequence; j++) {
                // Comparison for row match
                int rowWise = 0;
                while(rowWise < matchSequence) {
                    if(grid[i+(rowWise++)][j] != symbol)
                        break;
                }
                if(rowWise == matchSequence)
                    return true;
                // Comparison for column match
                int colWise = 0;
                while(colWise < matchSequence) {
                    if(grid[i][j+(colWise++)] != symbol)
                        break;
                }
                if(colWise == matchSequence)
                    return true;
                // Comparison for diagonal match
                int diagonalWise = 0;
                while(diagonalWise < matchSequence) {
                    if(grid[i+diagonalWise][j+diagonalWise] != symbol)
                        break;
                    diagonalWise++;
                }
                if(diagonalWise == matchSequence)
                    return true;
            }
        }
        return false;
    }
}
