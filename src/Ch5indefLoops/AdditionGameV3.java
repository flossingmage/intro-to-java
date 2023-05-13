package Ch5indefLoops;

import java.util.Random;
import java.util.Scanner;

/**
 * This program allows you to play Addition, Subtraction, Multiplication, and Divide Game and with a difficulty choice.
 * Kevin Dobruskin
 * 5/9/2023
 */
public class AdditionGameV3 {
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        var answer = 0.0;
        var lives = 3;
        var numberCorrect = 0;
        var gameMode = printRules();
        var difficulty = getDifficulty();
        do {
            if (gameMode == 4) {
                answer = divide(answer, numberCorrect, difficulty);
            } else {
                answer = getEquation(answer, gameMode, numberCorrect, difficulty);
            }
            System.out.print(" = ");
            var guess = getGoodDouble(scanner.next());
            if (guess == answer) {
                System.out.println("Correct");
                numberCorrect++;
            } else {
                System.out.println("Incorrect try again");
                lives--;
            }
        } while (lives > 0);
        System.out.println("Game Over you got " + numberCorrect + " correct");
    }

    /**
     * This method is the game, but it only has division.
     *
     * @param answer        is the answer to the problem.
     * @param numberCorrect is the number of problems the user has gotten correct.
     * @return the answer to the problem.
     */
    private static double divide(double answer, int numberCorrect, int difficulty) {
        final var num = (rand.nextInt(100 + numberCorrect) + 50) * difficulty;
        System.out.print(num);
        answer = num;
        for (var x = 0; x <= (rand.nextInt(2 + numberCorrect) + 1) * difficulty; x++) {
            if (isPrime(answer)) {
                break;
            }
            answer = isDividable(answer, difficulty);
        }
        return answer;
    }

    /**
     * this method finds an int that is dividable by the answer.
     *
     * @param answer is the answer to the problem.
     * @return the answer to the problem.
     */
    private static double isDividable(double answer, int difficulty) {
        var num = rand.nextInt(10 * difficulty) + 1;
        if (answer == num || (answer / num) % 1 == 0) {
            answer /= num;
            System.out.print(" / " + num);
        } else if (answer / num % 1 != 0) {
            return isDividable(answer, difficulty);
        }
        return answer;
    }

    /**
     * This method checks if the answer is prime.
     *
     * @return it the answer is prime.
     */
    private static boolean isPrime(double answer) {
        for (var i = 2; i <= answer / 2; i++) {
            if (answer % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method is the game, but it doesn't have divide.
     *
     * @param answer        is the answer to the problem.
     * @param gameMode      if the user wants to add, subtract, or multiply.
     * @param numberCorrect is the number of problems the user has gotten correct.
     * @param difficulty    is the difficulty that the user wants.
     * @return the answer to the problem.
     */
    private static double getEquation(double answer, int gameMode, int numberCorrect, int difficulty) {
        for (int i = 0; i <= rand.nextInt((3 + numberCorrect) * difficulty) + 2; i++) {
            int num = rand.nextInt((10 + numberCorrect) * difficulty) + 1;
            if (i == 0) {
                System.out.print(num);
                answer = num;
            } else {
                switch (gameMode) {
                    case 1:
                        System.out.print(" + " + num);
                        answer += num;
                        break;
                    case 2:
                        System.out.print(" - " + num);
                        answer -= num;
                        break;
                    case 3:
                        System.out.print(" * " + num);
                        answer *= num;
                        break;
                    default:
                        System.out.print("Invalid game mode");
                        System.exit(0);
                        break;
                }
            }
        }

        return answer;
    }

    /**
     * This method gets the difficulty from the user.
     *
     * @return the difficulty that the user wants.
     */
    private static int getDifficulty() {
        System.out.print("What difficulty do you want? (1-4): ");
        return getGoodInt(scanner.next());
    }

    /**
     * This method prints the rules of the game.
     *
     * @return the game mode that the user wants to play.
     */
    private static int printRules() {
        System.out.println("Welcome to the Addition Game");
        System.out.println("You will be given a random number of numbers to add");
        System.out.println("You will have 3 lives");
        System.out.print("type 1 for addition, 2 for subtraction, 3 for multiplication, 4 for division: ");
        return getGoodInt(scanner.next());
    }

    /**
     * This method gets an int from the user.
     *
     * @param aString is the string that the user inputs.
     * @return the int that the user inputs.
     */
    private static int getGoodInt(String aString) {
        int aInt;
        do {
            try {
                aInt = Integer.parseInt(aString);
            } catch (NumberFormatException e) {
                System.out.print("Sorry, not an Int try again: ");
                return getGoodInt(scanner.next());
            }
        } while (aInt < 1 || aInt > 4);
        return aInt;
    }

    /**
     * This method gets a double from the user.
     *
     * @param aString is the string that the user inputs.
     * @return the int that the user inputs.
     */
    private static double getGoodDouble(String aString) {
        double aDouble;
        try {
            aDouble = Double.parseDouble(aString);
        } catch (NumberFormatException e) {
            System.out.print("Sorry, not an double try again: ");
            return getGoodDouble(scanner.next());
        }
        return aDouble;
    }
}
