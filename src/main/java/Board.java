import model.Player;
import service.PrinterService;
import strategy.DefaultWinningStrategy;
import strategy.WinningStrategy;

import java.util.*;

import static utils.Constants.*;

public class Board {

    private final char[][] grid;
    private final Queue<Player> players;
    private final Map<Character, Player> symbolPlayerMap;
    private final WinningStrategy winningStrategy;
    private final PrinterService printerService;

    private int validMovesLeft;

    public Board(int row, int col) {
        this.grid = new char[row][col];
        for(char[] currRow : this.grid) {
            Arrays.fill(currRow, EMPTY_CELL_CHARACTER);
        }
        this.players = new LinkedList<>();
        this.symbolPlayerMap = new HashMap<>();
        this.winningStrategy = new DefaultWinningStrategy();
        this.printerService = new PrinterService();
        this.validMovesLeft = row * col;
    }

    public void addPlayer(Player player) {
        players.add(player);
        symbolPlayerMap.put(player.getSymbol(), player);
    }

    public boolean isSymbolTaken(char symbol) {
        return symbolPlayerMap.containsKey(symbol);
    }

    public boolean move(int row, int col) {
        if(players.isEmpty()) {
            return false;
        }
        Player player = players.peek();
        boolean winConditionSatisfied = false;
        if(grid[row-1][col-1] == EMPTY_CELL_CHARACTER) {
            grid[row-1][col-1] = player.getSymbol();
            validMovesLeft -= 1;
            if(winningStrategy.checkWinCondition(player.getSymbol(), grid)) {
                System.out.printf(WINNING_MOVE_TEXT, player.getName());
                winConditionSatisfied = true;
            } else {
                players.poll();
                players.add(player);
            }
        } else {
            System.out.println(INVALID_MOVE_WARNING);
        }
        printerService.printGrid(grid);
        return winConditionSatisfied;
    }

    public boolean checkIfAnyValidMoveLeft() {
        return validMovesLeft > 0;
    }
}
