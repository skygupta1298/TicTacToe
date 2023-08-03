package TicTacToe.strategy;

public interface WinningStrategy {

    boolean checkWinCondition(char symbol, char[][] grid);
}
