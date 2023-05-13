package Games;

import java.util.Scanner;

public class TicTacToePlayer2 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = '-';
            }
        }
        System.out.println("enter Player 1:");
        String player1Name = scanner.nextLine();
        System.out.println("enter Player 2:");
        String player2Name = scanner.next();
        boolean p1;
    }


    private static void printWinMessage(boolean isPlayerOne, String player1Name, String player2Name) {
        if (isPlayerOne) {
            System.out.println(player1Name + " has won");
        } else {
            System.out.println(player2Name + " has won");
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("board:");
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }
}