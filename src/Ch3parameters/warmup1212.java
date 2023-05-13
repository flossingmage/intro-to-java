package Ch3parameters;

public class warmup1212 {
    public static void main(String[] args) {
        oddNum(20);
        oddNum(20);
        evenNum(20);
        powerOfTwo(5);
        System.out.println();
        pythagoreamTheorem(3, 4);
        System.out.println(isPrime(5));
        System.out.println(slope(1,0,4,4));
        System.out.println(min(1,5,-4));

    }

    public static void oddNum(int number) {
        for (int i = 1; i <= number; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void evenNum(int number) {
        for (int i = 2; i <= number; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void powerOfTwo(double number) {
        int a = 1;
        System.out.print(a + " ");
        if (number > 1)
        for (double i =number; i>=1;i--) {
            a *= 2;
            System.out.print(a + " ");
        }
    }

    public static void pythagoreamTheorem(int A, int B) {
        double C;
        C = A * A + B * B;
        System.out.println(Math.sqrt(C));

    }

    public static boolean isPrime(int prime) {
        for (double num = 2; num <= Math.sqrt(prime); num++) {
            if ((num % prime) == 0) {
                return false;
            }
        }
        return true;
    }

    public static double slope(int x1, int y1, int x2, int y2){
      double slope;
      slope = (y2 - y1)/(x2-x1);
        return slope;
    }

    public static int min(int num,int num2,int num3) {
    int a = Math.min(Math.min(num,num2),num3);
    return a;

    }
}


