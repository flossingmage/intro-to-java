package Ch2DataTypesAndLoops;

//This program calculates tax, tip and total of a
//restaurant bill. This version contains redundany.
public class ReceiptV1 {
    public static void main(String[] args) {
        // Calculate total owed, assuming 8% tax / 15% tip

        System.out.print("Subtotal: $");
        System.out.println(38 + 40 + 30);
        System.out.print("Tax: $");
        System.out.println((38 + 40 + 30) * .08);

        System.out.print("Tip: $");
        System.out.println((38 + 40 + 30) * .15);

        System.out.print("Total: $");
        System.out.println(38 + 40 + 30 +
                (38 + 40 + 30) * .15 +
                (38 + 40 + 30) * .08);
    }
}
