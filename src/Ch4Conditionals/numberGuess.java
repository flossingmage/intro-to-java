package Ch4Conditionals;

import java.util.Scanner;

public class numberGuess {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int x = (int) (Math.random() * 100);
        int y;
        System.out.println(x);
        String string = "hello";
        System.out.println(string.length());
        do {
            y = getGoodInt();
            if (y > x) {
                System.out.println("To high");
            } else if (y < x) {
                System.out.println("To low");
            }
        } while (y != x);
        System.out.println("you win");
    }

    public static int getGoodInt() {
        System.out.print("enter a number : ");
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
}
