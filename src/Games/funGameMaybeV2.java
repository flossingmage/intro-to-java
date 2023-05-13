package Games;

import java.util.Random;
import java.util.Scanner;

public class funGameMaybeV2 {
    /**
     * This is just baby game from the PECO but less bad.
     * Kevin Dobruskin
     * v2
     * 4/24/23
     */
    private static final Scanner scanner = new Scanner(System.in);

    private static final Random random = new Random();


    public static void main(String[] args) {
        char[][] board = new char[12][12];
        int[] playerXY = {5, 5};
        int points = 0;
        int randomX;
        int randomY;
        do {
            do {
                randomX = random.nextInt(10) + 1;
                randomY = random.nextInt(10) + 1;
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
        scanner.close();
    }

    public static void printBoard(char[][] board) {
        System.out.println("board:");
        for (int x = 1; x < 11; x++) {
            for (int y = 1; y < 11; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }

    public static void playerMove(int[] playerXY) {
        System.out.println("Get to the X! \nUse W A S D to move around");
        String playerScan = scanner.nextLine();
        playerScan += " ";
        int playerX = playerXY[0];
        int playerY = playerXY[1];
        int X = 0;
        int Y = 0;
        for (int i = 0; i <= playerScan.length() - 1; i++) {
            String s = playerScan.substring(i, i + 1).toLowerCase();
            switch (s) {
                case "w":
                    X--;
                    break;
                case "a":
                    Y--;
                    break;
                case "s":
                    X++;
                    break;
                case "d":
                    Y++;
                    break;
            }
        }
        checkIfWorks(X, Y, playerX, playerY, playerXY);
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

    public static void checkIfWorks(int X, int Y, int playerX, int playerY, int[] playerXY) {
        int[] XY = {playerX, playerY};
        XY[0] += X;
        XY[1] += Y;
        do {
            do {
                if (XY[0] >= 11) {
                    XY[0] -= 10;
                }
                if (XY[0] < 1) {
                    XY[0] += 10;
                }
                if (XY[1] >= 11) {
                    XY[1] -= 10;
                }
                if (XY[1] < 1) {
                    XY[1] += 10;
                }
            } while (XY[0] >= 11 || XY[0] < 1);
        } while (XY[1] >= 11 || XY[1] < 1);
        playerXY[0] = (XY[0]);
        playerXY[1] = (XY[1]);

    }
}