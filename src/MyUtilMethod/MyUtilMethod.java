package MyUtilMethod;

import java.util.Scanner;

public class MyUtilMethod {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * This method gets a good int.
     *
     * @param aString the player input
     * @return a good int
     */
    public static int getGoodInt(String aString) {
        int aInt;
        try {
            aInt = Integer.parseInt(aString);
        } catch (NumberFormatException e) {
            System.out.print("Sorry, not an Int try again: ");
            return getGoodInt(scanner.next());

        }
        return aInt;
    }

    /**
     * This method gets a good double.
     *
     * @param aString the player input
     * @return a good double
     */
    public static double getGoodDouble(String aString) {
        double aDouble;
        try {
            aDouble = Integer.parseInt(aString);
        } catch (NumberFormatException e) {
            System.out.print("Sorry, not a double try again: ");
            return getGoodDouble(scanner.next());

        }
        return aDouble;
    }

    /**
     * this method asks the player a yes or no question and returns true if the player answers yes
     * @param aString the question
     * @return true if the player answers yes
     */
    public static boolean playAgain(String aString) {
        System.out.print(aString);
        char answer = scanner.next().toLowerCase().charAt(0);
        System.out.println();
        return answer == ('y');
    }
}
