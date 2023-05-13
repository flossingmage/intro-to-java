package Games;

import java.util.Scanner;

/**
 * this program runs the game hangman with the word being/sentence being hard coded
 * 5/12/2023
 * Kevin Dobruskin
 */

public class Hangman {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        var lives = 6;
        var word = "hello world";
        var board = board(word);
        theHangedMan(lives);
        System.out.println(board);
        do {
            var letter = playGuess();
            lives = updateBoard(board, letter, word, lives);
            theHangedMan(lives);
            System.out.println(board);
        } while (lives != 0 && String.valueOf(board).indexOf('_') != -1);
        ifWon(lives);
    }

    /**
     * this method prints out the man being hanged depending on how many lives the player has.
     *
     * @param lives the number of lives the player has left
     */
    private static void theHangedMan(int lives) {
        if (lives == 6) {
            System.out.println("_____\n|   |\n|\n|\n|\n|\n|");

        } else if (lives == 5) {
            System.out.println("_____\n|   |\n|   0\n|\n|\n|\n|");

        } else if (lives == 4) {
            System.out.println("_____\n|   |\n|   0\n|   |\n|   |\n|\n|");

        } else if (lives == 3) {
            System.out.println("_____\n|   |\n|   0\n|   |\n|   |\n|    \\ \n|");

        } else if (lives == 2) {
            System.out.println("_____\n|   |\n|   0\n|   |\n|   |\n|  / \\ \n|");
        } else if (lives == 1) {
            System.out.println("_____\n|   |\n|   0\n|  /|\n|   |\n|  / \\ \n|");
        } else {
            System.out.println("_____\n|   |\n|   0\n|  /|\\\n|   |\n|  / \\ \n|");
        }
    }

    /**
     * this method prints out if the player won or lost
     *
     * @param lives the number of lives the player has left
     */
    private static void ifWon(int lives) {
        if (lives != 0) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
    }

    /**
     * this method gets the letter the player wants to guess
     *
     * @return the letter the player wants to guess
     */
    private static char playGuess() {
        System.out.print("Enter a letter: ");
        return scanner.next().charAt(0);
    }

    /**
     * this method creates the board for the game
     *
     * @param word the word/sentence the player is trying to guess
     * @return the board for the game
     */
    private static char[] board(String word) {
        char[] board = new char[word.length()];
        for (var i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                board[i] = ' ';
            } else {
                board[i] = '_';
            }
        }
        return board;
    }

    /**
     * this method updates the board depending on the letter the player guessed
     * @param board the board for the game
     * @param letter the letter the player guessed
     * @param word the word/sentence the player is trying to guess
     * @param lives the number of lives the player has left
     * @return the number of lives the player has left
     */
    private static int updateBoard(char[] board, char letter, String word, int lives) {
        if (word.indexOf(letter) != -1) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    board[i] = letter;
                }
            }
        } else {
            lives--;
        }
        return lives;
    }
}
