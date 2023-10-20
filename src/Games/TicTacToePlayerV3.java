package Games;

import java.util.Scanner;

/**
 * This program allows you to play tic-tac-toe.
 * Kevin Dobruskin
 * 5/3/2023
 */
public class TicTacToePlayerV3 {

    public static final Scanner scanner = new Scanner(System.in);
    private static final int BOARD_SIZE = 3;

    public static void main(String[] args) {
        final var board = new char[BOARD_SIZE][BOARD_SIZE];
        for (var x = 0; x < BOARD_SIZE; x++) {
            for (var y = 0; y < BOARD_SIZE; y++) {
                board[x][y] = '-';
            }
        }

        final var names = getNames();
        var p1 = 0;
        printBoard(board);
        while (!checkWinner(board)) {
            if (p1 % 2 == 0) {
                System.out.println(names.playerX + "s turn:");
            } else {
                System.out.println(names.playerO + "s turn:");
            }
            var newMove = playerPlay(board);
            board[newMove.row][newMove.column] = XorO(p1);
            printBoard(board);
            p1++;
        }
        if (p1 % 2 == 1) {
            System.out.println(names.playerX + " has won");
        } else {
            System.out.println(names.playerO + " has won");
        }
        scanner.close();
    }

    /**
     * This method gets the players names.
     * @return the players name
     */
    private static Players getNames() {
        System.out.print("enter Player X: ");
        final var playerX = scanner.nextLine();
        System.out.print("enter Player O: ");
        final var playerO = scanner.nextLine();
        return new Players(playerX, playerO);
    }

    /**
     * This method makes plays the players turn.
     * @param board the board
     * @return the players move
     */
    public static PlayerMove playerPlay(char[][] board) {
        System.out.print("enter column 1-"+BOARD_SIZE+": ");
        final var column = getGoodInt(scanner.next()) - 1;
        System.out.print("enter row 1-"+ BOARD_SIZE +": ");
        final var row = getGoodInt(scanner.next()) - 1;
        if (board[row][column] != '-') {
            System.out.println("location already used redo turn");
            return playerPlay(board);
        }
        return new PlayerMove(row, column);
    }

    /**
     * This method checks if there is a winner.
     * @param board the board
     * @return if there is a winner
     */
    public static boolean checkWinner(char[][] board) {
        var win = true;
        for (var x = 0; x < BOARD_SIZE; x++) {
            win = board[x][x] != '-' && board[x][x] == board[0][0];
            if (!win) {
                break;
            }
        }
        if (win) {
            return true;
        }
        for (var x = 0; x < BOARD_SIZE; x++) {
            win = board[x][BOARD_SIZE - 1 - x] != '-' && board[BOARD_SIZE - 1 - x][x] == board[0][BOARD_SIZE - 1];
            if (!win) {
                break;
            }
        }
        if (win) {
            return true;
        }

        for (var check = 0; check < BOARD_SIZE; check++) {
            for (var x = 0; x < BOARD_SIZE; x++) {
                win = board[check][x] != '-' && board[check][x] == board[check][0];
                if (!win) {
                    break;
                }
            }
            if (win) {
                return true;
            }
            for (var x = 0; x < BOARD_SIZE; x++) {
                win = board[x][check] != '-' && board[x][check] == board[0][check];
                if (!win) {
                    break;
                }
            }
            if (win) {
                return true;
            }
        }

        var tie = true;
        for (var i = 0; i < BOARD_SIZE; i++) {
            for (var j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == '-') {
                    tie = false;
                    break;
                }
            }
        }
        if (tie) {
            System.out.println("tie");
            System.exit(0);
        }
        return false;
    }

    /**
     * This method prints the board.
     * @param board the board
     */
    public static void printBoard(char[][] board) {
        System.out.println("board:");
        for (var x = 0; x < BOARD_SIZE; x++) {
            for (var y = 0; y < BOARD_SIZE; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }

    /**
     * This method gets a good int.
     * @param aString the player input
     * @return a good int
     */
    public static int getGoodInt(String aString) {
        int aInt;
        try {
            aInt = Integer.parseInt(aString);
        } catch (NumberFormatException e) {
            System.out.print("Sorry, not an Int try again: ");
            return getGoodInt(scanner.next());
        }
        if (aInt > BOARD_SIZE || aInt < 1) {
            System.out.print("the int can only be 1-" + BOARD_SIZE +" try again: ");
            return getGoodInt(scanner.next());
        }
        return aInt;
    }

    /**
     * This method gets the player sign
     * @param p1 the number of turns that happened so far.
     * @return the player sign
     */
    private static char XorO(int p1) {
        if (p1 % 2 == 0) {
            return 'X';
        }
        return 'O';
    }

    /**
     * This class represents a player move.
     */
    private static class PlayerMove {
        public final int row;
        public final int column;

        public PlayerMove(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    /**
     * This class represents the players names.
     */
    private static class Players {
        public final String playerX;
        public final String playerO;

        public Players(String playerX, String playerO) {
            this.playerX = playerX;
            this.playerO = playerO;
        }
    }
}