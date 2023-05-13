package Ch5indefLoops;

import java.util.Random;
import java.util.Scanner;

/**
 * This program allows you to play Addition, Subtraction, Multiplication, and Divide Game.
 * Kevin Dobruskin
 * 5/5/2023
 */
public class AdditionGameV2 {
    public static final Random rand = new Random();
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        var answer = 0.0;
        var lives = 3;
        var numberCorrect = 0;
        int gameMode = printRules();
        do {
            answer = Game(answer, gameMode, numberCorrect);
            System.out.print(" = ");
            double guess = getGoodDouble(scanner.next());
            if (guess == answer) {
                System.out.println("Correct");
                numberCorrect++;
            } else {
                System.out.println("Incorrect try again");
                lives--;
            }
        } while (lives > 0);
    }

    /**
     * This method is the game
     *
     * @param answer   is the answer to the problem.
     * @param gameMode sees if the user wants to add, subtract, multiply, or divide.
     * @return the answer to the problem.
     */
    public static double Game(double answer, int gameMode, int numberCorrect) {
        for (int i = 0; i <= rand.nextInt(3 + numberCorrect) + 2; i++) {
            int num = rand.nextInt(10 + numberCorrect) + 1;
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
                    case 4:
                        System.out.print(" / " + num);
                        answer /= num;
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
     * This method prints the rules of the game.
     *
     * @return the game mode that the user wants to play.
     */
    public static int printRules() {
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
    public static int getGoodInt(String aString) {
        int aInt;
        try {
            aInt = Integer.parseInt(aString);
        } catch (NumberFormatException e) {
            System.out.print("Sorry, not an Int try again: ");
            return getGoodInt(scanner.next());
        }
        return aInt;
    }

    /**
     * This method gets a double from the user.
     *
     * @param aString is the string that the user inputs.
     * @return the int that the user inputs.
     */
    public static double getGoodDouble(String aString) {
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
