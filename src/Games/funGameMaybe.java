package Games;

import java.util.Scanner;

public class funGameMaybe {
    /**
     * This is just baby game form the PECO.
     * Kevin Dobruskin
     * v1
     * 4/6/23
     */
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = new char[11][11];
        int[] playerXY = {5, 5};
        int points = 0;
        int randomX;
        int randomY;
        do {
            do {
                randomX = (int) (Math.random() * 10);
                randomY = (int) (Math.random() * 10);
            } while (randomX == 5 || randomY == 5);
            do {
                clearBoard(board, playerXY, randomX, randomY);
                printBoard(board);
                playerMove(playerXY);
            } while (board[randomX][randomY] != board[playerXY[0]][playerXY[1]]);
            points++;
            System.out.println("points: " + points);
        } while (points != 3);
        System.out.println("You won");

    }

    public static void printBoard(char[][] board) {
        System.out.println("board:");
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }

    public static void playerMove(int[] playerXY) {
        System.out.println("Get to the X! \nUse W A S D to move around");
        String playerScan = scanner.nextLine();
        int playerX = playerXY[0];
        int playerY = playerXY[1];
        int w = 0;
        int a = 0;
        int s = 0;
        int d = 0;
        for (int i = 0; i <= playerScan.length() - 1; i++) {
            if (playerScan.charAt(i) == 'w' || playerScan.charAt(i) == 'W') {
                w++;
            }
            if (playerScan.charAt(i) == 'a' || playerScan.charAt(i) == 'A') {
                a++;
            }
            if (playerScan.charAt(i) == 's' || playerScan.charAt(i) == 'S') {
                s++;
            }
            if (playerScan.charAt(i) == 'd' || playerScan.charAt(i) == 'D') {
                d++;
            }
        }
        playerXY[0] = (playerX - (w) + (s));
        playerXY[1] = (playerY - (a) + (d));

    }

    public static void clearBoard(char[][] board, int[] playerXY, int randomX, int randomY) {
        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                board[x][y] = '-';
                board[randomX][randomY] = 'X';
                board[playerXY[0]][playerXY[1]] = '^';
            }
        }
    }
}