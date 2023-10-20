package Ch3parameters;

import java.util.Scanner;
public class StarsV2 {
    public static void main(String[] args) {
        Scanner numOfStar = new Scanner(System.in);
        System.out.print("# of stars: ");
        int num = numOfStar.nextInt();
        for (int Star=1; Star<=num; Star++) {
            System.out.println();
        }
        numOfStar.close();
    }
}