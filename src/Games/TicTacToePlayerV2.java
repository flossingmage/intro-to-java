package Games;

import java.util.Scanner;

/**
 * This program allows you to play tic-tac-toe.
 * Kevin Dobruskin
 * 5/1/2023
 */
public class TicTacToePlayerV2 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (var x = 0; x < 3; x++) {
            for (var y = 0; y < 3; y++) {
                board[x][y] = '-';
            }
        }

        String[] playerNames = new String[2];
        getNames(playerNames);
        var p1 = 0;
        printBoard(board);
        // row, column
        int[] playerMove = new int[2];
        while (!checkWinner(board)) {
            playGame(board, playerNames, p1, playerMove);
            p1++;
        }
        System.out.println((playerNames[p1 % 2] + " has won"));
        scanner.close();
    }

    /**
     * plays the code that runs the came
     *
     * @param board       the board
     * @param playerNames the names of the players
     * @param p1          whose turn it is
     * @param playerMove  the row and column of the player move
     */
    public static void playGame(char[][] board, String[] playerNames, int p1, int[] playerMove) {
        System.out.println(playerNames[p1 % 2] + "s turn:");
        playerPlay(playerMove, board);
        board[playerMove[0]][playerMove[1]] = XorO(p1);
        printBoard(board);
        ifTie(board);
    }

    /**
     * asks the players for their names.
     *
     * @param playerNames the names of the players
     */
    public static void getNames(String[] playerNames) {
        System.out.print("enter Player 1: ");
        playerNames[0] = scanner.nextLine();
        System.out.print("enter Player 2: ");
        playerNames[1] = scanner.next();
    }

    /**
     * makes the player move.
     *
     * @param playerMove the row and column of the player move
     * @param board      the board
     */
    public static void playerPlay(int[] playerMove, char[][] board) {
        System.out.print("enter column 1-3: ");
        playerMove[1] = getGoodInt(scanner.next()) - 1;
        System.out.print("enter row 1-3: ");
        playerMove[0] = getGoodInt(scanner.next()) - 1;
        if (board[playerMove[0]][playerMove[1]] != '-') {
            System.out.println("location already used redo turn");
            playerPlay(playerMove, board);
        }
    }

    /**
     * checks if there is a winner.
     *
     * @param board the board
     * @return if there is a winner
     */
    public static boolean checkWinner(char[][] board) {
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-' || board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return true;
        } else {
            for (var check = 0; check < 3; check++) {
                if (board[check][0] == board[check][1] && board[check][1] == board[check][2] && board[check][0] != '-' || board[0][check] == board[1][check] && board[1][check] == board[2][check] && board[0][check] != '-') {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * prints the board
     *
     * @param board the board
     */
    public static void printBoard(char[][] board) {
        System.out.println("board:");
        for (var x = 0; x < 3; x++) {
            for (var y = 0; y < 3; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }

    /**
     * checks if the input is an int
     *
     * @return the input if it is an int
     */
    public static int getGoodInt(String aString) {
        int aInt;
        try {
            aInt = Integer.parseInt(aString);
        } catch (NumberFormatException e) {
            System.out.print("Sorry, not an Int try again: ");
            return getGoodInt(scanner.next());
        }
        if (aInt > 3 || aInt < 1) {
            System.out.print("the int can only be 1-3 try again: ");
            return getGoodInt(scanner.next());
        }
        return aInt;
    }

    /**
     * returns x or o depending on whose turn it is
     *
     * @param p1 the turn number
     * @return x or o
     */
    private static char XorO(int p1) {
        if (p1 % 2 == 0) {
            return 'x';
        }
        return 'o';
    }

    /**
     * checks if there is a tie
     *
     * @param board the board
     */
    private static void ifTie(char[][] board) {
        if (board[0][0] != '-' && board[0][1] != '-' && board[0][2] != '-' && board[1][0] != '-' && board[1][1] != '-' && board[1][2] != '-' && board[2][0] != '-' && board[2][1] != '-' && board[2][2] != '-') {
            System.out.println("Tie");
            System.exit(0);
        }
    }
}
