package Ch2DataTypesAndLoops;

public class fibonacci {
    public static void main(String[] args) {
        int k = 1, k2 = 1, next;
        for (int fibonacci = 1; fibonacci <= 12; fibonacci++) {
            if (fibonacci > 2) {
                System.out.print(1 + " ");
            }
            next = k + k2;
            System.out.print(next + " ");
            k = k2;
            k2 = next;
        }
    }
}
/*        int n1 = 1, n2 = 1, next;
        System.out.print(n1 + " " + n2 + " ");
        for (int k = 3; k<= 12; k++) {
            next = n2 + n1;
            System.out.print(next + " ");
            n1 = n2;
            n2 = next;
        }
    }
}
*/