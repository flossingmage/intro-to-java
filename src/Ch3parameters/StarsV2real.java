package Ch3parameters;

import java.util.Scanner;
public class StarsV2real {
    public static void main(String[] args) {
        Scanner numOfStar = new Scanner(System.in);
        System.out.print("# of stars: ");
        int num = numOfStar.nextInt();
        System.out.println("*".repeat(num));
        numOfStar.close();
    }
}