/**
 * allows and n amount of people
 *
 * @author Kevin Dobruskin
 * @version 3.0
 * @since 2/9/2023
 */
package Ch4Conditionals;

import java.util.Scanner;

public class BMIv3 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        findBMI();
        scanner.close();
    }

    /**
     * Take the BMI and find and print the weight class.
     *
     * @param BMI The BMI of the person whose weight class you want to find.
     */
    public static void findWeightClass(double BMI) {
        if (BMI >= 30) {
            System.out.println("obese");
            System.out.println();
        } else if (BMI >= 25 && BMI < 30) {
            System.out.println("overweight");
            System.out.println();
        } else if (BMI >= 18.5 && BMI < 25) {
            System.out.println("normal");
            System.out.println();
        } else if (BMI < 18.5) {
            System.out.println("under weight");
            System.out.println();
        }

    }

    /**
     * Ask the user for weight and height and calculate and return BMI.
     *
     */
    public static void findBMI() {
        System.out.print("how many people are there: ");
        int numOfBMI = scanner.nextInt();
        for (int i = 0; i <= numOfBMI; i++) {
            System.out.println("Enter next person's information");
            System.out.print("height (in inches): ");
            double height = scanner.nextDouble();
            System.out.print("weight (in pounds): ");
            double weight = scanner.nextDouble();
            double BMI = (weight / Math.pow(height, 2) * 703);
            System.out.println();
            System.out.println("Person" + i + " BMI = " + BMI);
            findWeightClass(BMI);
        }
    }

    /**
     * Finds the difference of BMI between the two people.
     *
     * @param BMI1 The BMI of the first person.
     * @param BMI2 The BMI of the second person.
     */
   public static void differenceOfBMI(double BMI1, double BMI2) {
        double difference = BMI1 - BMI2;
        if (difference > 0) {
            System.out.println("Difference = " + difference);
        } else {
            System.out.println("Difference = " + (difference * -1));
        }
    }
}
