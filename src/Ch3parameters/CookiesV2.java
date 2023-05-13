package Ch3parameters;

import java.util.Scanner;

public class CookiesV2 {
    public static void main(String[] args) {
        Scanner cookies = new Scanner(System.in);
        System.out.println("How many cookies do you want to bake");
        int numberOfCookies = cookies.nextInt();
        cookies20(numberOfCookies);

    }
    public static void cookies20(int cookies) {
        System.out.println("Mix the following ingredients in a bowl " +
                "for " + cookies + " cookies:");
        System.out.println(cookies * 4 + " cups of flour");
        System.out.println(cookies * 1 +" cup of butter");
        System.out.println(cookies * 1 +" cup of sugar");
        System.out.println(cookies * 2 +" eggs");
        System.out.println(cookies * 20 +" pounds of chocolate chips");
    }
}

