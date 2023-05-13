package Ch1intro;
//This program will print a rocket ship to the console author Kevin Dobruskin @since 9/22/22 @ version 2.0
public class Rocketv2 {
    public static void main(String[] args){
        cone();
        box();
        usa();
        box();
        cone();
    }

    public static void box() {
        System.out.println("+------+ ");
        System.out.println("|      |");
        System.out.println("|      |");
        System.out.println("+------+ ");

    }

    public static void cone() {
        System.out.println("   /\\    ");
        System.out.println("  /  \\   ");
        System.out.println(" /    \\  ");

    }

    public static void usa() {
        System.out.println("|United| ");
        System.out.println("|States| ");
    }
}
