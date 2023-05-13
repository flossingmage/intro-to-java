package Ch3parameters;

import java.util.Scanner;
public class StarsV2real {
    public static void main(String[] args) {
        Scanner numOfStar = new Scanner(System.in);
        System.out.print("# of stars: ");
        int num = numOfStar.nextInt();
        String s;
        System.out.println("*".repeat(num));
    }
}