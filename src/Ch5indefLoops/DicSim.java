package Ch5indefLoops;

import java.util.Random;

public class DicSim {
    public static final Random rand = new Random();

    public static void main(String[] args) {
        var total = 0;
        var count = 0;
        do {
            var roll = rand.nextInt(6) + 1;
            var roll2 = rand.nextInt(6) + 1;
            total = roll + roll2;
            count++;
            System.out.println(roll + " + " + roll2 + " = " + total);
        } while (total != 7);
        System.out.println("you won after " + count + " tries!");
    }
}
