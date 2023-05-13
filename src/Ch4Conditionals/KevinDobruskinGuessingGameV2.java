package Ch4Conditionals;

import java.util.Random;
import java.util.Scanner;
/*
 * This program allows you to play a guessing game. the computer will pick a number between 1 and 100 and will allow you to guess until you get it. For each guess, I will tell you whether the right answer is higher or lower than your guess.
 * Kevin Dobruskin
 * 4/27/23
 * v2.0
 */

public class KevinDobruskinGuessingGameV2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("This program allows you to play a guessing game. \nI will think of a number between 1 and 100 \nand will allow you to guess until you get it. \nFor each guess, I will tell you whether the \nright answer is higher or lower than your guess.\n");
        var totalGames = 0;
        var totalGuesses = 0;
        var mostGuesses = 0;
        do {
            totalGuesses++;
            var move = playGame();
            totalGuesses += move;
            if (mostGuesses < move) {
                mostGuesses = move;
            }
        } while (playAgain());
        gameStats(totalGames, totalGuesses, mostGuesses);
        scanner.close();
    }

    /**
     * keeps track of all the information and calls playerMove.
     */
    public static int playGame() {
        var x = rand.nextInt(101) + 1;
        var move = playerMove(x);
        System.out.println("You got it right in " + move + " guesses");
        return move;

    }

    /**
     * calls getGoodInt and checks if the int is too high or low.
     *
     * @param x the number that the player is trying to guess.
     * @return the number of guesses it took to get the right answer.
     */
    private static int playerMove(int x) {
        int y;
        var turn = 0;
        System.out.println("I'm thinking of a number...");
        do {
            turn++;
            y = getGoodInt();
            if (y > x) {
                System.out.println("lower");
            } else if (y < x) {
                System.out.println("higher");
            }
        } while (y != x);
        return turn;
    }

    /**
     * asks and returns an int if not an int then calls itself again until user puts in an int.
     *
     * @return an int
     */
    public static int getGoodInt() {
        System.out.print("Your guess? ");
        String aString = scanner.next();
        int aInt;
        try {
            aInt = Integer.parseInt(aString);
        } catch (NumberFormatException e) {
            System.out.println("Sorry, not an Int ");
            return getGoodInt();
        }
        return aInt;
    }

    /**
     * asks the player if they want to play again.
     *
     * @return A boolean that represents if the player wants to play again
     */
    private static boolean playAgain() {
        System.out.print("Do you want to play again? ");
        String answer = scanner.next().toLowerCase();
        System.out.println();
        return answer.equals("yes");
    }

    /**
     * prints out the overall results of the game.
     *
     * @param totalGames   the total number of games played.
     * @param totalGuesses the total number of guesses.
     * @param mostGuesses  the most guesses in a game.
     */
    private static void gameStats(int totalGames, int totalGuesses, int mostGuesses) {
        System.out.println("Overall results:");
        System.out.println("    total games = " + totalGames);
        System.out.println("    total guesses = " + totalGuesses);
        System.out.println("    guesses/game = " + (totalGuesses / totalGames));
        System.out.println("    max guesses = " + mostGuesses);
    }
}
