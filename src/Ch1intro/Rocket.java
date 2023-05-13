package Ch1intro;
//This program will print a rocketship to the console author @since 9/22/22 @ version 1.0
public class Rocket {
    public static void main(String[] args){
        cone();
        box();
        System.out.println("|United| ");
        System.out.println("|States| ");
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
}
