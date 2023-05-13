package Ch3parameters;

import java.util.Scanner;

public class Receipt {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double total = people();
        double tax = Tax();
        double tip = Tip();
        int howManyPaying = howManyPaying();
        bill(total, tax, tip, howManyPaying);
        scanner.close();
    }

    public static double people() {
        double totalCost = 0;
        int numOfPeople;
        System.out.print("How many people are there: ");
        numOfPeople = scanner.nextInt();
        for (int i = 1; i <= numOfPeople; i++) {
            System.out.print("enter person" + i + "'s meal cost: ");
            double price = scanner.nextDouble();
            totalCost += price;
        }
        return totalCost;
    }

    public static double Tax() {
        System.out.print("Tax rate: ");
        return scanner.nextDouble();
    }

    public static double Tip() {
        System.out.print("Tip rate: ");
        return scanner.nextDouble();
    }

    public static int howManyPaying() {
        System.out.print("How many people are sharing the bill: ");
        return scanner.nextInt();
    }

    public static void bill(double total, double tax, double tip, int howManyPaying) {
        System.out.println("subtotal: " + String.format("%.2f", total));
        System.out.println("tax: " + String.format("%.2f", tax));
        System.out.println("tip: " + String.format("%.2f", tip));
        System.out.println("total: " + String.format("%.2f", (total + tax + tip)));
        System.out.println("Cost/Person " + String.format("%.2f", (tip + tax + total) / howManyPaying));
    }
}