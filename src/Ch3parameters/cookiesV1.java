package Ch3parameters;

public class cookiesV1 {
    public static void main(String[] args) {
        cookies20(3);
        /*Scanner cookies = new Scanner(System.in);
        int numberOfCookies = cookies.nextInt();
        printNumber()

*/
    }
    public static void cookies20(int cookies) {
        System.out.println("Mix the following ingredients in a bowl " +
                "for " + cookies + " cookies:");
        System.out.println(4 * cookies + " cups of flour");
        System.out.println(4 * 1 +" cup of butter");
        System.out.println(4 * 1 +" cup of sugar");
        System.out.println(4 * 2 +" eggs");
        System.out.println(4 * 20 +" pounds of chocolate chips");
    }
}

