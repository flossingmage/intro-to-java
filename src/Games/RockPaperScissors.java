package Games;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static final Scanner scanner = new Scanner(System.in);
    public static final Random random = new Random(2);

    public static void main(String[] args) {
        rockPaperScissors();
    }

    public static void rockPaperScissors() {
        System.out.println("1 to play rock, 2 to play paper, 3 to play scissors");
        var player = scanner.nextInt();
        var computer = random.nextInt(3) + 1;
        System.out.println("computer played " + computer);
        if (player == computer) {
            System.out.println("tie");
            rockPaperScissors();
        } else if (player == 1 && computer == 3) {
            System.out.println("player wins");
        } else if (player == 2 && computer == 1) {
            System.out.println("player wins");
        } else if (player == 3 && computer == 2) {
            System.out.println("player wins");
        } else {
            System.out.println("computer wins");
        }
    }
}