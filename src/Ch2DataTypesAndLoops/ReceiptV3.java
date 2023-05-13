package Ch2DataTypesAndLoops;

//This program calculates tax, tip and total of a
//restaurant bill. This version eliminates redundancy and groups variables and println statements.
public class ReceiptV3 {
    public static void main(String[] args) {
        // Calculate total owed, assuming 8% tax / 15% tip
        int Subtotal = 38 + 40 + 30;
        double Tax = Subtotal * .08;
        double Tip = Subtotal * .20;

        System.out.print("Subtotal: $" + Subtotal);
        System.out.print("\nTax: $" + Tax);
        System.out.print("\nTip: $" + Tip);
        System.out.print("\nTotal: $");
        System.out.println(Subtotal + Tax + Tip);
    }
}
