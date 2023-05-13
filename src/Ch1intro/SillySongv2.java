//SillySongV1
/*
 * This program prints the verses of a silly song
 *
 * @author: Kevin Dobruskin
 * @since: September 29, 2022
 * @version: 2.0
 */

package Ch1intro;

public class SillySongv2 {
    public static void main(String[] args) {
        //step 1
        verse1();
        //step 2
        verse2();
        //step 3
        verse3();
        //step 4
        verse4();
        ///step 5
        verse5();

    }

    public static void verse1() {
        System.out.println("I once wrote a program that wouldn't compile");
        teacher();
    }

    public static void verse2() {
        System.out.println("My program did nothing");
        System.out.println("So I started typing.");
        coding();
    }

    public static void verse3() {
        System.out.println("\"Parse error,\" cried the compiler");
        System.out.println("Luckily I'm such a code baller.");
        coding();
    }

    public static void verse4() {
        System.out.println("Now the compiler wanted an identifier");
        System.out.println("And I thought the situation was getting dire.");
        string();
    }

    public static void verse5() {
        System.out.println("Java complained it expected an enum");
        System.out.println("Boy, these computers really are dumb!");
        scum();
    }

    public static void teacher() {
        System.out.println("I don't know why it wouldn't compile,");
        System.out.println("My teacher just smiled.");
        System.out.println();
    }

    public static void coding() {
        System.out.println("I added System.out.println(\"I <3 coding\"),");
        teacher();
    }

    public static void backSlash() {
        System.out.println("I added a backslash to escape the quotes,");
        coding();
    }

    public static void string() {
        System.out.println("I added a main method with its String[] args,");
        backSlash();
    }

    public static void scum() {
        System.out.println("I added a public class and called it Scum,");
        string();
    }


}
