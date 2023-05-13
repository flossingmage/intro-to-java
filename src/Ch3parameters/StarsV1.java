package Ch3parameters;

public class StarsV1 {
    public static void main(String[] args) {
        lineOf7();
        System.out.println();
        lineOf14();
        System.out.println();
        lineOf35();

    }
    public static void lineOf14() {
        for (int Star=1; Star<=14; Star++) {
            System.out.println("*");
        }

    }
    public static void lineOf7() {
        for (int Star=1; Star<=7; Star++) {
            System.out.println("*");
        }
    }
    public static void lineOf35() {
        for (int Star=1; Star<=35; Star++) {
            System.out.println("*");
        }
    }
}