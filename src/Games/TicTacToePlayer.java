package Games;

import java.util.Scanner;

/**
 * This program allows you to play tic-tac-toe.
 * Kevin Dobruskin
 * 11/12/2022
 */
public class TicTacToePlayer {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                board[x][y] = '-';
            }
        }
        // getting player ones name
        System.out.println("enter Player 1:");
        String player1Name = scanner.nextLine();
        //getting player twos name
        System.out.println("enter Player 2:");
        String player2Name = scanner.next();

        boolean p1 = true;
        printBoard(board);

        boolean done = false;
        while (!done) {
            if (p1) {
                System.out.println(player1Name + "s turn:");
            } else {
                System.out.println(player2Name + "s turn:");
            }
            int column;
            int row;
            boolean redoTurn = false;
            boolean redoRow = false;
            boolean redoColumn = false;
            do {
                if (redoTurn) {
                    System.out.println("location already used redo turn");
                }
                do {
                    if (redoColumn) {
                        System.out.println("the column can only be 1, 2, and 3 re-input the column");
                    }
                    System.out.println("enter colum 1-3: ");
                    double a = scanner.nextDouble();
                    column = (int) a;
                    redoColumn = true;
                } while (column != 1 && column != 2 && column != 3);
                redoColumn = false;
                do {
                    if (redoRow) {
                        System.out.println("the row can only be 1, 2, and 3, re-input the row");
                    }
                    System.out.println("enter row 1-3: ");
                    double a = scanner.nextDouble();
                    row = (int) a;
                    redoRow = true;
                } while ((row != 1 && row != 2 && row != 3));
                redoRow = false;
                redoTurn = true;
            } while (board[row - 1][column - 1] != '-');

            if (p1) {
                board[row - 1][column - 1] = 'x';
            } else {
                board[row - 1][column - 1] = 'o';
            }
            printBoard(board);
// check if there is a winner
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
                printWinMessage(p1, player1Name, player2Name);
                done = true;
            } else if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
                printWinMessage(p1, player1Name, player2Name);
                done = true;
            } else {
                for (int check = 0; check < 3; check++) {
                    if (board[check][0] == board[check][1] && board[check][1] == board[check][2] && board[check][0] != '-') {
                        printWinMessage(p1, player1Name, player2Name);
                        done = true;
                    } else if (board[0][check] == board[1][check] && board[1][check] == board[2][check] && board[0][check] != '-') {
                        printWinMessage(p1, player1Name, player2Name);
                        done = true;
                    }
                }
            }
// switch player turn
            p1 = !p1;
        }
        scanner.close();
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