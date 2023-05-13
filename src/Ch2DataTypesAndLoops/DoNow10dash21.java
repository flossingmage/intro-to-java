package Ch2DataTypesAndLoops;

public class DoNow10dash21 {
    public static void main(String[] args) {
    DoubleIt();
    System.out.println();
    HalfIt();

    }

    public static void DoubleIt () {
        System.out.print(3);
        for (int doubleValue = 6; doubleValue <= 24; doubleValue *= 2) {
            System.out.print(", " + doubleValue);
        }
    }

    public static void HalfIt () {
        System.out.print(24);
        for (int halfValue = 12; halfValue >= 3; halfValue /= 2) {
            System.out.print(", " + halfValue);
        }
    }
}
