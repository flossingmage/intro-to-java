package Ch4Conditionals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class basicMod1 {
    public static void main(String[] args) {
        String stuff = "ABCDEFGHIJKLMNOPQRSTUVQXYZ0123456789_";
        try {
            // Scan the text file
            Scanner scanner = new Scanner(new File("G:\\My Drive\\ijp\\workspace\\src\\Ch4Conditionals\\modThisFile"));

            // If there is an Int mod and print the char the modded number is equal to
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt() % 37;
                System.out.print(stuff.charAt(num));
            }

            scanner.close();
            // if there is a File Excaption catch it
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


