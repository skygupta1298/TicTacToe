package TicTacToe;

import TicTacToe.model.Player;

import java.util.Scanner;

import static TicTacToe.utils.Constants.EXIT_CONDITION_TEXT;
import static TicTacToe.utils.Constants.GAME_OVER_TEXT;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number of rows of board");
        int rows = sc.nextInt();
        System.out.println("Please enter number of columns of board");
        int cols = sc.nextInt();
        Board board = new Board(rows, cols);
        System.out.println("Please enter number of players");
        int players = sc.nextInt();
        int index = 0;
        while(index++ < players) {
            System.out.println("Please enter user name and symbol for player " + index);
            String name = sc.next();
            String symbol = sc.next();
            if(symbol.length() > 1 || board.isSymbolTaken(symbol.charAt(0))) {
                System.out.println("Invalid symbol entered");
                continue;
            }
            Player player = new Player(index, name, symbol.charAt(0));
            board.addPlayer(player);
        }
        sc.nextLine();
        while(true) {
            if(!board.checkIfAnyValidMoveLeft()) {
                System.out.println(GAME_OVER_TEXT);
                break;
            }
            System.out.println("Please enter next move");
            String input = sc.nextLine();
            if(EXIT_CONDITION_TEXT.equals(input)) {
                break;
            }
            String[] move = input.split(" ");
            boolean win = board.move(Integer.parseInt(move[0]), Integer.parseInt(move[1]));
            if(win) {
                break;
            }
        }
    }
}
