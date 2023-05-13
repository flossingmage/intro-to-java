package Ch2DataTypesAndLoops;
/*
do know 10/19
Kevin Dobruskin
@since 10/19/2022
 */

public class DoNow10dash19 {
    public static void main(String[] args) {
    for1to10();
    for2to9();
    }

    public static void for1to10() {
        {
            for (int i = 1; i <= 10; i += 1) {
                System.out.print(" "+i);
            }
        }
    }

    public static void for2to9() {
        {
            for (int x = 1; x <= 10; x += 2) {
                if (x == 1) {
                    System.out.println(" hi");
                } else {
                    System.out.print(" "+x);
                }
            }
        }
    }


}