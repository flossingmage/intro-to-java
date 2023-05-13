package Ch2DataTypesAndLoops;

//This program calculates tax, tip and total of a
//restaurant bill. This version eliminates redundancy.
public class ReceiptV2 {
    public static void main(String[] args) {
        // Calculate total owed, assuming 8% tax / 15% tip
        int Subtotal = 38 + 40 + 30;
        double Tax = Subtotal * .08;
        double Tip = Subtotal * .15;

        System.out.print("Subtotal: $");
        System.out.println(Subtotal);

        System.out.print("Tax: $");
        System.out.println(Tax);

        System.out.print("Tip: $");
        System.out.println(Tip);

        System.out.print("Total: $");
        System.out.println(Subtotal + Tax + Tip);
    }
}
