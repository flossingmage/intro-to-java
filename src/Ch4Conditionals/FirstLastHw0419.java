package Ch4Conditionals;

import java.util.Random;

public class FirstLastHw0419 {
    public static void main(String[] args) {
        System.out.println("Let's roll some dice! ");
        Random rand = new Random();
        int odds = 0;
        int rolls = 0;
        while (odds < 3) {
            int roll = rand.nextInt(6) + 1;
            rolls++;
            System.out.println("you rolled a: " + roll);
            if (roll % 2 == 1) {
                odds++;
            } else {
                odds = 0;
            }
        }
        System.out.println("Three in a row after " + rolls + " rolls");
    }
}
