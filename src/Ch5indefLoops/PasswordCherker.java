package Ch5indefLoops;

import java.util.Scanner;

public class PasswordCherker {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        String temp;
        do {
            System.out.print("Enter password: ");
            temp = scanner.nextLine();
        } while (!temp.equals("hi"));
        System.out.println("you got it right");

    }
}
