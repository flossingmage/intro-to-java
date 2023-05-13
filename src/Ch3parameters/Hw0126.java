package Ch3parameters;

import java.util.Scanner;

public class Hw0126 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.println("Hello " + name + "! welcome to IJP! ");
        System.out.print("Enter GPA : ");
        double GPA = scanner.nextDouble();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.println("Hello " + name + "\nage " + age +"\nyour current GPA is " + GPA);
        scanner.close();
    }
}
