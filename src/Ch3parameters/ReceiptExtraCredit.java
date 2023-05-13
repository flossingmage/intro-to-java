package Ch3parameters;
/*
 * This program will print a receipt and give me extra credit
 * Kevin Dobruskin
 * 2/1/23
 * v2.0
 */

import java.util.Scanner;

public class ReceiptExtraCredit {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double total = people();
        double tax = Tax();
        double tip = Tip();
        int howManyPaying = howManyPaying();
        bill(total, tax, tip, howManyPaying);
        scanner.close();
    }

    // checks if the input of an Int will cause an error
    public static int getGoodInt(String Message) {
        System.out.print(Message);
        String aString = scanner.next();
        int aInt;
        try {
            aInt = Integer.parseInt(aString);
        } catch (NumberFormatException e) {
            System.out.print("Sorry, not an Int ");
            return getGoodInt(Message);
        }
        return aInt;
    }

    // checks if the input of a double will cause an error
    public static double getGoodDouble(String aMessage) {
        System.out.print(aMessage);
        String aString = scanner.next();
        double aDouble;
        try {
            aDouble = Double.parseDouble(aString);
        } catch (NumberFormatException e) {
            System.out.print("Sorry, not a double ");
            return getGoodDouble(aMessage);
        }
        return aDouble;
    }

    // finds how many people are eating and cost of each person
    public static double people() {
        double totalCost = 0;
        int numOfPeople = getGoodInt(("How many people are there: "));
        for (int i = 1; i <= numOfPeople; i++)
            totalCost += getGoodDouble("enter person" + i + "'s meal cost: ");
        return totalCost;
    }

    // finds the % that is left as tax
    public static double Tax() {
        return (getGoodDouble(" enter tax rate: "));
    }

    // finds the % that is left as tip
    public static double Tip() {
        return getGoodDouble("enter tip rate: ");
    }

    // finds out how many people are paying the bill
    public static int howManyPaying() {
        return getGoodInt("How many people are sharing the bill: ");
    }

    //this method prints out the receipt
    public static void bill(double total, double tax, double tip, int howManyPaying) {
        tax = (total / 100) * tax;
        tip = (total / 100) * tip;
        double trueTotal = tax + tip + total;
        System.out.println("subtotal: " + String.format("%.2f", total));
        System.out.println("tax: " + String.format("%.2f", tax));
        System.out.println("tip: " + String.format("%.2f", tip));
        System.out.println("total: " + String.format("%.2f", trueTotal));
        System.out.println("Cost/Person " + String.format("%.2f", (trueTotal / howManyPaying)));
    }
}
