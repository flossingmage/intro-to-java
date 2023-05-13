package Ch4Conditionals;

import java.util.Random;
import java.util.Scanner;

public class PractisIt {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final var rand = new Random();
        for (var x = 0; x < 50; x++) {
            System.out.print(rand.nextInt(166) + 71 + ",");
        }
        System.out.print(rand.nextInt(166) + 71);
    }


}
