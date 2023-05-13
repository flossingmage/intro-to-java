package Games;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * this program runs the game hangman with the word being randomly chosen from a list of words
 * 5/12/2023
 * Kevin Dobruskin
 */

public class HangmanV2 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String... args) throws IOException {
        do {
            var lives = 6;
            var wrongGuesses = new char[6];
            var word = getRandomWord();
            var board = board(word);
            theHangedMan(lives, wrongGuesses);
            System.out.println(board);
            do {
                var letter = playGuess(wrongGuesses);
                lives = updateBoard(wrongGuesses, board, letter, word, lives);
                theHangedMan(lives, wrongGuesses);
                System.out.println(board);
            } while (lives != 0 && String.valueOf(board).indexOf('_') != -1);
            ifWon(lives, word);
        } while (playAgain());
        scanner.close();
    }

    /**
     * this method prints out the man being hanged depending on how many lives the player has.
     *
     * @param lives the number of lives the player has left
     */
    private static void theHangedMan(int lives, char[] wrongGuesses) {
        if (lives == 6) {
            System.out.println("_____\n|   |\n|\n|\n|\n|\n|");

        } else if (lives == 5) {
            System.out.println("_____\n|   |\n|   0   " + wrongGuesses[0] + "\n|\n|\n|\n|");

        } else if (lives == 4) {
            System.out.println("_____\n|   |\n|   0    " + wrongGuesses[0] + " " + wrongGuesses[1] + "\n|   |\n|   |\n|\n|");

        } else if (lives == 3) {
            System.out.println("_____\n|   |\n|   0    " + wrongGuesses[0] + " " + wrongGuesses[1] + " " + wrongGuesses[2] + " \n|   |\n|   |\n|    \\ \n|");

        } else if (lives == 2) {
            System.out.println("_____\n|   |\n|   0    " + wrongGuesses[0] + " " + wrongGuesses[1] + " " + wrongGuesses[2] + " " + wrongGuesses[3] + " \n|   |\n|   |\n|  / \\ \n|");
        } else if (lives == 1) {
            System.out.println("_____\n|   |\n|   0    " + wrongGuesses[0] + " " + wrongGuesses[1] + " " + wrongGuesses[2] + " " + wrongGuesses[3] + " " + wrongGuesses[4] + " \n|  /|\n|   |\n|  / \\ \n|");
        } else {
            System.out.println("_____\n|   |\n|   0    " + wrongGuesses[0] + " " + wrongGuesses[1] + " " + wrongGuesses[2] + " " + wrongGuesses[3] + " " + wrongGuesses[4] + " " + wrongGuesses[5] + " \n|  /|\\\n|   |\n|  / \\ \n|");
        }
    }

    /**
     * this method prints out if the player won or lost
     *
     * @param lives the number of lives the player has left
     */
    private static void ifWon(int lives, String word) {
        if (lives != 0) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
            System.out.println("The word was " + word);
        }
    }

    /**
     * this method gets the letter the player wants to guess
     *
     * @return the letter the player wants to guess
     */
    private static char playGuess(char[] wrongGuesses) {
        System.out.print("Enter a letter: ");
        return isAlreadyGuessed(wrongGuesses, scanner.next().charAt(0));
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
     *
     * @param board  the board for the game
     * @param letter the letter the player guessed
     * @param word   the word/sentence the player is trying to guess
     * @param lives  the number of lives the player has left
     * @return the number of lives the player has left
     */
    private static int updateBoard(char[] wrongGuesses, char[] board, char letter, String word, int lives) {
        if (word.indexOf(letter) != -1) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    board[i] = letter;
                }
            }
        } else {
            wrongGuesses[6 - lives] = letter;
            lives--;

        }
        return lives;
    }

    /**
     * this method picks a random number and skips that many lines in the file and then returns the word it lands on
     *
     * @return a random word from a list of words
     * @throws IOException if the file is not found
     */
    public static String getRandomWord() throws IOException {
        String line;
        try (Stream<String> lines = Files.lines(Paths.get("G:\\My Drive\\ijp\\workspace\\src\\Games\\1000RandomWords"))) {
            line = lines.skip(random.nextInt(1000)).findFirst().get();
        }
        return line;
    }

    /**
     * this method checks if the letter the player guessed has already been guessed
     *
     * @param wrongGuesses the letters the player has already guessed
     * @param letter       the letter the player guessed
     * @return the letter the player guessed
     */
    private static char isAlreadyGuessed(char[] wrongGuesses, char letter) {
        for (char wrongGuess : wrongGuesses) {
            if (wrongGuess == letter) {
                System.out.println("You already guessed that letter");
                return playGuess(wrongGuesses);
            }
        }
        return letter;
    }

    /**
     * this method asks the player if they want to play again
     *
     * @return true if the player wants to play again and false if they don't
     */
    private static boolean playAgain() {
        System.out.print("Do you want to play again?(Yes or No) ");
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("yes")) {
            return true;
        } else if (answer.equalsIgnoreCase("no")) {
            return false;
        } else {
            System.out.println("Please enter YES or NO");
            return playAgain();
        }
    }
}
