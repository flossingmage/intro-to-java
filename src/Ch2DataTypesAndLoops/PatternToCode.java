package Ch2DataTypesAndLoops;

public class PatternToCode {
    public static void main(String[] args) {
    numberStaircase();
    }

    public static void dotNumberPattern() {
        for (int rows = 1; rows <= 5; rows++) {
            for (int dots = 0; dots <= 4 - rows; dots++) {
                System.out.print(".");
            }
            for (int num = 1; num <= rows; num++) {
                System.out.print(rows);
            }
            System.out.println();
        }


    }

    public static void starPattern() {
        for (int y = 1; y<= 5; y++) {
            for (int x = 1; x <= y; x++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void rightNumberAngle() {
        for (int y = 1; y <= 5; y++) {
            for (int x = 1; x <= y; x++) {
                System.out.print(y);
            }
            System.out.println();
        }
    }

    public static void numberStaircase() {
        for (int x = 1; x<=5; x++){
            for (int space=5; space>=x; space--){
                System.out.print(" ");
            }
            for (int num = 1; num <= 1; num++) {
                System.out.print(x);
            }
            System.out.println();
        }
    }

}