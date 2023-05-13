package Ch4Conditionals;

import java.util.Random;
import java.util.Scanner;
/*
 * This program allows you to play a guessing game. the computer will pick a number between 1 and 100 and will allow you to guess until you get it. For each guess, I will tell you whether the right answer is higher or lower than your guess.
 * Kevin Dobruskin
 * 4/21/23
 * v1.0
 */

public class KevinDobruskinGuessingGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("This program allows you to play a guessing game. \nI will think of a number between 1 and 100 \nand will allow you to guess until you get it. \nFor each guess, I will tell you whether the \nright answer is higher or lower than your guess.\n");
        // info[0] = number of games, info[1] = total number of guesses, info[2] = most guesses in a game
        double[] info = {0, 0, 0};
        do {
            playGame(info);
        } while (playAgain());
        gameStats(info);
        scanner.close();
    }

    /**
     * keeps track of all the information and calls playerMove.
     *
     * @param info an array that contains the number of games, total guesses, and most guesses in a game.
     */
    public static void playGame(double[] info) {
        info[0] += 1;
        var x = rand.nextInt(101) + 1;
        var move = playerMove(x);
        info[1] += move;
        if (info[2] < move) {
            info[2] = move;
        }
        System.out.println("You got it right in " + move + " guesses");
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
     * asks if the user wants to play again and returns a boolean depending on the answer.
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
     * @param info an array that contains the number of games, total guesses, and most guesses in a game.
     */
    private static void gameStats(double[] info) {
        System.out.println("Overall results:");
        System.out.println("    total games = " + (int) info[0]);
        System.out.println("    total guesses = " + (int) info[1]);
        System.out.println("    guesses/game = " + (info[1] / info[0]));
        System.out.println("    max guesses = " + (int) info[2]);
    }
}

