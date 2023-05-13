package Ch1intro;
// fixing redundancy author Kevin Dobruskin 9/23/2022 v1.0
public class hex {
    public static void main(String[] args) {
        top();
        bottom();
        System.out.println();
        bottom();
        line();
        System.out.println();
        top();
        System.out.println("|  STOP  |");
        bottom();
        System.out.println();
        top();
        line();
    }

    public static void top() {
        System.out.println("  ______");
        System.out.println(" /      \\");
        System.out.println("/        \\");
    }

    public static void bottom() {
        System.out.println("\\        /");
        System.out.println(" \\______/");

    }

    public static void line() {
        System.out.println("+--------+");
    }
}

