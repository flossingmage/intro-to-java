package Ch5indefLoops;

import java.util.Random;
import java.util.Scanner;

/**
 * This program allows you to play Addition Game.
 * Kevin Dobruskin
 * 5/5/2023
 */
public class AdditionGame {
    public static final Random rand = new Random();
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int answer = 0;
        int lives = 3;
        do {
            answer = addition(answer);
            System.out.print(" = ");
            int guess = scanner.nextInt();
            if (guess == answer) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect try again");
                lives--;
            }
        } while (lives > 0);
    }

    public static int addition(int answer) {
        for (int i = rand.nextInt(3) + 2; i >= 0; i--) {
            int num = rand.nextInt(10) + 1;
            if (i == 0) {
                System.out.print(num);
            } else {
                System.out.print(num + " + ");
            }
            answer += num;
        }
        return answer;
    }
}
